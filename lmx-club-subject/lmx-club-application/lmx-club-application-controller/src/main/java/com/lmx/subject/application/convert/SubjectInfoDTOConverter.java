package com.lmx.subject.application.convert;

import com.lmx.subject.application.dto.SubjectCategoryDTO;
import com.lmx.subject.application.dto.SubjectInfoDTO;
import com.lmx.subject.domain.entity.SubjectCategoryBO;
import com.lmx.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectInfoDTOConverter {
    SubjectInfoDTOConverter INSTANCE =Mappers.getMapper(SubjectInfoDTOConverter.class);
    SubjectInfoBO convertDtoToInfoBo(SubjectInfoDTO subjectInfoDTO);
    SubjectInfoDTO convertBoToInfoDto(SubjectInfoBO subjectInfoBO);

}
