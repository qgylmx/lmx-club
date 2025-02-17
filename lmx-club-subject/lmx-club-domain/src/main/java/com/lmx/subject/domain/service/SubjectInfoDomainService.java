package com.lmx.subject.domain.service;

import com.lmx.subject.common.entity.PageResult;
import com.lmx.subject.domain.entity.SubjectCategoryBO;
import com.lmx.subject.domain.entity.SubjectInfoBO;

import java.util.List;

public interface SubjectInfoDomainService {

    void add(SubjectInfoBO subjectInfoBO);
    /**
     * 分页查询
     */

    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    /**
     * 查询题目详情
     */
    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);
}
