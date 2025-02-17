package com.lmx.subject.application.convert;

import com.lmx.subject.application.dto.SubjectCategoryDTO;
import com.lmx.subject.domain.entity.SubjectCategoryBO;
import com.lmx.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * SubjectCategoryConverter
 *
 * @author lmx
 * @version 1.0
 * &#064;date  2020/4/16 16:05
 */
@Mapper
public interface SubjectCategoryDTOConverter {
    SubjectCategoryDTOConverter INSTANCE =Mappers.getMapper(SubjectCategoryDTOConverter.class);
    SubjectCategoryBO convertBoToCategory(SubjectCategoryDTO subjectCategoryDTO);
    List<SubjectCategoryDTO> convertBoToCategoryDTOList(List<SubjectCategoryBO> subjectCategoryBOList);

    SubjectCategoryBO convertBoToCategoryBO(SubjectCategoryDTO subjectCategoryDTO);
}
