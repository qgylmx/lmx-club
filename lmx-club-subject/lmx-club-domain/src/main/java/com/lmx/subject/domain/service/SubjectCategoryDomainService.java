package com.lmx.subject.domain.service;

import com.lmx.subject.domain.entity.SubjectCategoryBO;
import com.lmx.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

public interface SubjectCategoryDomainService {
    void add(SubjectCategoryBO subjectCategoryBO);

    /**
     * 查询大类分类
     */
    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    /**
     * 更新分类
     */

    Boolean update(SubjectCategoryBO subjectCategoryBO);
    /**
     * 删除分类
     */
    Boolean delete(SubjectCategoryBO subjectCategoryBO);
}
