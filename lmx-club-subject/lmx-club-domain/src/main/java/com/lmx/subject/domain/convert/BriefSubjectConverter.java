package com.lmx.subject.domain.convert;

import com.lmx.subject.domain.entity.SubjectAnswerBO;
import com.lmx.subject.domain.entity.SubjectInfoBO;
import com.lmx.subject.infra.basic.entity.SubjectBrief;
import com.lmx.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface BriefSubjectConverter {
    BriefSubjectConverter INSTANCE =Mappers.getMapper(BriefSubjectConverter.class);
    SubjectBrief convertBoToEntity(SubjectInfoBO subjectInfoBO);
}
