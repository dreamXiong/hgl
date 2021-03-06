package com.liguo.hgl.proxydao.dao;

import com.liguo.hgl.proxydao.base.BaseMapper;
import com.liguo.hgl.proxydao.model.Criteria;
import com.liguo.hgl.proxydao.model.TbAdminPermission;

import java.util.List;
import java.util.Map;

public interface TbAdminPermissionMapper extends BaseMapper {
    /**
     * 根据条件查询记录总数
     */
    int countByObject(Criteria example);

    /**
     * 根据条件删除记录
     */
    int deleteByObject(Criteria example);

    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(TbAdminPermission record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(TbAdminPermission record);

    /**
     * 根据条件查询记录集
     */
    List<TbAdminPermission> selectByObject(Criteria example);
    /**
     * 根据条件查询记录集
     */
    List<Map<String,Object>> selectByObjectToMap(Criteria example);

    /**
     * 根据主键查询记录
     */
    TbAdminPermission selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(TbAdminPermission record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(TbAdminPermission record);
    
    /**
     * 
     * <根据一组子节点查询权限>
     * @param strList
     * @return
     * @author wzt
     * @since   2016年5月3日
     */
    List<TbAdminPermission> selectByStringList(List<String> strList);
    
    TbAdminPermission selectByURL(Criteria criteria);
}