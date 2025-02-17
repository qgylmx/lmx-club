package com.lmx.subject.domain.convert;

import com.lmx.subject.domain.entity.SubjectAnswerBO;

import com.lmx.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface RadioSubjectConverter {
    RadioSubjectConverter INSTANCE =Mappers.getMapper(RadioSubjectConverter.class);
    SubjectRadio convertBoToEntity(SubjectAnswerBO subjectAnswerBO);
    List<SubjectAnswerBO> convertEntityToBoList(List<SubjectRadio> subjectRadioList);
}
