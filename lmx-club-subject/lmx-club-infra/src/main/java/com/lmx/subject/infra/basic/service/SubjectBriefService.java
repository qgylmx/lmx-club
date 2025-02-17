package com.lmx.subject.infra.basic.service;

import com.lmx.subject.infra.basic.entity.SubjectBrief;
import com.lmx.subject.infra.basic.entity.SubjectRadio;

import java.util.List;

/**
 * 简答题(SubjectBrief)表服务接口
 *
 * @author makejava
 * @since 2025-02-13 21:14:49
 */
public interface SubjectBriefService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectBrief queryById(Integer id);



    /**
     * 新增数据
     *
     * @param subjectBrief 实例对象
     * @return 实例对象
     */
    SubjectBrief insert(SubjectBrief subjectBrief);
    /**
     * 批量新增数据
     */
    void batchInsert(List<SubjectBrief> subjectBriefList);
    /**
     * 修改数据
     *
     * @param subjectBrief 实例对象
     * @return 实例对象
     */
    SubjectBrief update(SubjectBrief subjectBrief);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    SubjectBrief queryByCondition(SubjectBrief subjectBrief);
}
