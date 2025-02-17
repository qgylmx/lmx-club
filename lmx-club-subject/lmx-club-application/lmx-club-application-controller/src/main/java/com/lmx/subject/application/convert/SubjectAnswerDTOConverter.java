package com.lmx.subject.application.convert;

import com.lmx.subject.application.dto.SubjectAnswerDTO;
import com.lmx.subject.application.dto.SubjectInfoDTO;
import com.lmx.subject.domain.entity.SubjectAnswerBO;
import com.lmx.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectAnswerDTOConverter {
    SubjectAnswerDTOConverter INSTANCE =Mappers.getMapper(SubjectAnswerDTOConverter.class);
    SubjectAnswerBO convertDtoToAnswerBo(SubjectAnswerDTO subjectAnswerDTO);
    List<SubjectAnswerBO> convertListDtoToAnswerBoList(List<SubjectAnswerDTO> subjectAnswerDTOList);

}
