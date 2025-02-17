package com.lmx.subject.domain.handler.subject;

import com.lmx.subject.common.enums.IsDeleteFlagEnum;
import com.lmx.subject.common.enums.SubjectInfoTypeEnum;

import com.lmx.subject.domain.convert.BriefSubjectConverter;
import com.lmx.subject.domain.entity.SubjectInfoBO;
import com.lmx.subject.domain.entity.SubjectOptionBO;
import com.lmx.subject.infra.basic.entity.SubjectBrief;

import com.lmx.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;

/**
 * 简答题目的策略类
 * @author lmx
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler{
    @Resource
    private SubjectBriefService subjectBriefService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        SubjectBrief subjectBrief = BriefSubjectConverter.INSTANCE.convertBoToEntity(subjectInfoBO);
        subjectBrief.setSubjectId(subjectInfoBO.getId());
        subjectBrief.setIsDeleted(IsDeleteFlagEnum.UN_DELETED.getCode());
        subjectBriefService.insert(subjectBrief);
    }

    @Override
    public SubjectOptionBO query(Integer subjectId) {
        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId(subjectId);
        SubjectBrief result = subjectBriefService.queryByCondition(subjectBrief);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setSubjectAnswer(result.getSubjectAnswer());
        return subjectOptionBO;
    }
}
