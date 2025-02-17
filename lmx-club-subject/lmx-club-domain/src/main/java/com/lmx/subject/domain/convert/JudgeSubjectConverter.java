package com.lmx.subject.domain.convert;

import com.lmx.subject.domain.entity.SubjectAnswerBO;
import com.lmx.subject.infra.basic.entity.SubjectJudge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface JudgeSubjectConverter {
    JudgeSubjectConverter INSTANCE =Mappers.getMapper(JudgeSubjectConverter.class);
    List<SubjectAnswerBO> convertEntityToBoList(List<SubjectJudge> subjectJudgeList);
}
