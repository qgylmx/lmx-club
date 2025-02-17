package com.lmx.subject.infra.basic.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmx.subject.infra.basic.entity.SubjectMultiple;
import com.lmx.subject.infra.basic.entity.SubjectMultiple;

import java.util.List;

/**
 * 多选信息表(SubjectMultiple)表服务接口
 *
 * @author makejava
 * @since 2025-02-13 21:15:37
 */
public interface SubjectMultipleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectMultiple queryById(Integer id);



    /**
     * 新增数据
     *
     * @param subjectMultiple 实例对象
     * @return 实例对象
     */
    SubjectMultiple insert(SubjectMultiple subjectMultiple);
    /**
     * 批量新增数据
     */
    void batchInsert(List<SubjectMultiple> subjectMultipleList);

    /**
     * 修改数据
     *
     * @param subjectMultiple 实例对象
     * @return 实例对象
     */
    SubjectMultiple update(SubjectMultiple subjectMultiple);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<SubjectMultiple> queryByCondition(SubjectMultiple subjectMultiple);
}
