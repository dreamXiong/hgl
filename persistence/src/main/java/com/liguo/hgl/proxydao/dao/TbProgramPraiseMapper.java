package com.liguo.hgl.proxydao.dao;

import com.liguo.hgl.proxydao.base.BaseMapper;
import com.liguo.hgl.proxydao.exception.DataAlreadyModifyException;
import com.liguo.hgl.proxydao.model.Criteria;
import com.liguo.hgl.proxydao.model.TbProgramPraise;

import java.util.List;

public interface TbProgramPraiseMapper extends BaseMapper {
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
    int insert(TbProgramPraise record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(TbProgramPraise record);

    /**
     * 根据条件查询记录集
     */
    List<TbProgramPraise> selectByObject(Criteria example);

    /**
     * 根据主键查询记录
     */
    TbProgramPraise selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(TbProgramPraise record) throws DataAlreadyModifyException;

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(TbProgramPraise record) throws DataAlreadyModifyException;
}