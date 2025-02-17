package com.lmx.subject.domain.convert;

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
public interface SubjectCategoryConverter {
    SubjectCategoryConverter INSTANCE =Mappers.getMapper(SubjectCategoryConverter.class);
    SubjectCategory convertBoToCategory(SubjectCategoryBO subjectCategoryBO);
    List<SubjectCategoryBO> convertBoToCategory(List<SubjectCategory> categoryList);
}
