package com.liguo.hgl.proxydao.dao;

import java.util.List;

import com.liguo.hgl.proxydao.base.BaseMapper;
import com.liguo.hgl.proxydao.model.Criteria;
import com.liguo.hgl.proxydao.model.TbPayWater;

public interface TbPayWaterMapper extends BaseMapper {
    /**
     * 根据条件查询记录总数
     */
    int countByObject(Criteria criteria);

    /**
     * 根据条件删除记录
     */
    int deleteByObject(Criteria criteria);

    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(TbPayWater record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(TbPayWater record);

    /**
     * 根据条件查询记录集
     */
    List<TbPayWater> selectByObject(Criteria criteria);

    /**
     * 根据主键查询记录
     */
    TbPayWater selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(TbPayWater record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(TbPayWater record);
}