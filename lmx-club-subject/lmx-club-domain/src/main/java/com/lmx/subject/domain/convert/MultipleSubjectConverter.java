package com.lmx.subject.domain.convert;

import com.lmx.subject.domain.entity.SubjectAnswerBO;
import com.lmx.subject.infra.basic.entity.SubjectMultiple;
import com.lmx.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface MultipleSubjectConverter {
    MultipleSubjectConverter INSTANCE =Mappers.getMapper(MultipleSubjectConverter.class);
    SubjectMultiple convertBoToEntity(SubjectAnswerBO subjectAnswerBO);
    List<SubjectAnswerBO> convertEntityToBoList(List<SubjectMultiple> subjectMultipleList);

}
