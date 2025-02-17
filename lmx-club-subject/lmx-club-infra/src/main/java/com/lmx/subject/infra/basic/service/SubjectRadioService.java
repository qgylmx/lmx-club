package com.lmx.subject.infra.basic.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmx.subject.infra.basic.entity.SubjectRadio;

import java.util.List;

/**
 * 单选题信息表(SubjectRadio)表服务接口
 *
 * @author makejava
 * @since 2025-02-13 21:15:53
 */
public interface SubjectRadioService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectRadio queryById(Integer id);



    /**
     * 新增数据
     *
     * @param subjectRadio 实例对象
     * @return 实例对象
     */
    SubjectRadio insert(SubjectRadio subjectRadio);
    /**
     * 批量新增数据
     */
    void batchInsert(List<SubjectRadio> subjectRadioList);

    /**
     * 修改数据
     *
     * @param subjectRadio 实例对象
     * @return 实例对象
     */
    SubjectRadio update(SubjectRadio subjectRadio);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<SubjectRadio> queryByCondition(SubjectRadio subjectRadio);
}
