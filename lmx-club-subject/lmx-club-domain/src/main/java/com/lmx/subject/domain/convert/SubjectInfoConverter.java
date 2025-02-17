package com.lmx.subject.domain.convert;

import com.lmx.subject.domain.entity.SubjectCategoryBO;
import com.lmx.subject.domain.entity.SubjectInfoBO;
import com.lmx.subject.domain.entity.SubjectOptionBO;
import com.lmx.subject.infra.basic.entity.SubjectCategory;
import com.lmx.subject.infra.basic.entity.SubjectInfo;
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
public interface SubjectInfoConverter {
    SubjectInfoConverter INSTANCE =Mappers.getMapper(SubjectInfoConverter.class);

    SubjectInfo convertBoToInfo(SubjectInfoBO subjectInfoBO);
    SubjectInfoBO convertOptionToInBo(SubjectOptionBO subjectOptionBO);
    SubjectInfoBO convertOptionAndInfoToBo(SubjectOptionBO subjectOptionBO, SubjectInfo subjectInfo);

    List<SubjectInfoBO> convertListInfoToBo(List<SubjectInfo> subjectInfoList);
}
