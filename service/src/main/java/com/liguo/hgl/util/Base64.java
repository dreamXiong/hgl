package com.liguo.hgl.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base64编码工具类
 * @author wzt
 */
public class Base64 {
    /** 规则字符 */
    private static final char[] LEGAL_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    /** 日志常量类 */
    private static final Logger LOGGER = LoggerFactory.getLogger(Base64.class);

    /**
     * 对传入数据加密
     * @param data data
     * @return 加密结果
     */
    public static String encode(byte[] data) {
        int start = 0;
        int len = data.length;
        StringBuffer buf = new StringBuffer(data.length * 3 / 2);

        int end = len - 3;
        int i = start;
        int n = 0;

        while (i <= end) {
            int d = ((((int) data[i]) & 0x0ff) << 16) | ((((int) data[i + 1]) & 0x0ff) << 8) | (((int) data[i + 2]) & 0x0ff);

            buf.append(LEGAL_CHARS[(d >> 18) & 63]);
            buf.append(LEGAL_CHARS[(d >> 12) & 63]);
            buf.append(LEGAL_CHARS[(d >> 6) & 63]);
            buf.append(LEGAL_CHARS[d & 63]);

            i += 3;

            if (n++ >= 14) {
                n = 0;
                buf.append(" ");
            }
        }

        if (i == start + len - 2) {
            int d = ((((int) data[i]) & 0x0ff) << 16) | ((((int) data[i + 1]) & 255) << 8);

            buf.append(LEGAL_CHARS[(d >> 18) & 63]);
            buf.append(LEGAL_CHARS[(d >> 12) & 63]);
            buf.append(LEGAL_CHARS[(d >> 6) & 63]);
            buf.append("=");
        }
        else if (i == start + len - 1) {
            int d = (((int) data[i]) & 0x0ff) << 16;

            buf.append(LEGAL_CHARS[(d >> 18) & 63]);
            buf.append(LEGAL_CHARS[(d >> 12) & 63]);
            buf.append("==");
        }

        return buf.toString();
    }

    /**
     * 对传入字符解码
     * @param c 传入字符
     * @return 字符对应ASCII数值
     */
    private static int decode(char c) {
        if (c >= 'A' && c <= 'Z') {
            return ((int) c) - 65;
        }
        else if (c >= 'a' && c <= 'z') {
            return ((int) c) - 97 + 26;
        }
        else if (c >= '0' && c <= '9') {
            return ((int) c) - 48 + 26 + 26;
        }
        else {
            switch (c) {
                case '+':
                    return 62;
                case '/':
                    return 63;
                case '=':
                    return 0;
                default:
                    throw new RuntimeException("unexpected code: " + c);
            }
        }
    }

    /**
     * Decodes the given Base64 encoded String to a new byte array. The byte array holding the decoded data is returned.
     * <一句话功能简述>
     * @param s S
     * @return byte[]
     */

    public static byte[] decode(String s) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            decode(s, bos);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        byte[] decodedBytes = bos.toByteArray();
        try {
            bos.close();
            bos = null;
        }
        catch (IOException ex) {
            LOGGER.error("Error while decoding BASE64: ", ex);
        }
        return decodedBytes;
    }

    /**
     * 解码并输出
     * @param s 字符串
     * @param os 输出流
     * @throws IOException IO异常
     */
    private static void decode(String s, OutputStream os) throws IOException {
        int i = 0;

        int len = s.length();

        while (true) {
            while (i < len && s.charAt(i) <= ' ') {
                i++;
            }

            if (i == len) {
                break;
            }

            int tri = (decode(s.charAt(i)) << 18) + (decode(s.charAt(i + 1)) << 12) + (decode(s.charAt(i + 2)) << 6)
                    + (decode(s.charAt(i + 3)));

            os.write((tri >> 16) & 255);
            if (s.charAt(i + 2) == '=') {
                break;
            }
            os.write((tri >> 8) & 255);
            if (s.charAt(i + 3) == '=') {
                break;
            }
            os.write(tri & 255);

            i += 4;
        }
    }
}