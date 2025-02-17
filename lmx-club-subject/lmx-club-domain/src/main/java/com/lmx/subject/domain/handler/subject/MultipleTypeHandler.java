package com.lmx.subject.domain.handler.subject;

import com.lmx.subject.common.enums.SubjectInfoTypeEnum;
import com.lmx.subject.domain.convert.MultipleSubjectConverter;
import com.lmx.subject.domain.entity.SubjectAnswerBO;
import com.lmx.subject.domain.entity.SubjectInfoBO;
import com.lmx.subject.domain.entity.SubjectOptionBO;
import com.lmx.subject.infra.basic.entity.SubjectMultiple;
import com.lmx.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 多选题目的策略类
 * @author lmx
 */
@Component
public class MultipleTypeHandler implements SubjectTypeHandler{
    @Resource
    private SubjectMultipleService subjectMultipleService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        List<SubjectMultiple> subjectMultipleList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectMultiple subjectMultiple = MultipleSubjectConverter.INSTANCE.convertBoToEntity(option);
            subjectMultiple.setSubjectId(subjectInfoBO.getId());
            subjectMultiple.setIsCorrect(option.getIsCorrect());
            subjectMultipleList.add(subjectMultiple);
        });
        subjectMultipleService.batchInsert(subjectMultipleList);

    }

    @Override
    public SubjectOptionBO query(Integer subjectId) {
        SubjectMultiple subjectMultiple = new SubjectMultiple();
        subjectMultiple.setSubjectId(subjectId);
        List<SubjectMultiple> result = subjectMultipleService.queryByCondition(subjectMultiple);
        List<SubjectAnswerBO> subjectAnswerBOList = MultipleSubjectConverter.INSTANCE.convertEntityToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;

    }
}
