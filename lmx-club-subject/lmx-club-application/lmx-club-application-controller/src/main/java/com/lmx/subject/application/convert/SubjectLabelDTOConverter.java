package com.lmx.subject.application.convert;

import com.lmx.subject.application.dto.SubjectCategoryDTO;
import com.lmx.subject.application.dto.SubjectLabelDTO;
import com.lmx.subject.domain.entity.SubjectCategoryBO;
import com.lmx.subject.domain.entity.SubjectLabelBO;
import com.lmx.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 标签dto转换
 *
 * @author lmx
 */
@Mapper
public interface SubjectLabelDTOConverter {
    SubjectLabelDTOConverter INSTANCE =Mappers.getMapper(SubjectLabelDTOConverter.class);
    SubjectLabelBO convertDtoToLabelBO(SubjectLabelDTO subjectLabelDTO);
    List<SubjectLabelDTO> convertBoToLabelDTOList(List<SubjectLabelBO> subjectLabelBOList);
}
