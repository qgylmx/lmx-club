package com.lmx.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.lmx.subject.common.enums.IsDeleteFlagEnum;
import com.lmx.subject.domain.convert.SubjectCategoryConverter;
import com.lmx.subject.domain.entity.SubjectCategoryBO;
import com.lmx.subject.domain.service.SubjectCategoryDomainService;
import com.lmx.subject.infra.basic.entity.SubjectCategory;
import com.lmx.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * SubjectCategoryDomainServiceImpl
 *
 * @author lmx
 * @description
 * @date 2020/04/01
 */
@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {
    @Resource
    private SubjectCategoryService subjectCategoryService;

    public void add(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeleteFlagEnum.UN_DELETED.getCode());
        subjectCategoryService.insert(subjectCategory);

    }

    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeleteFlagEnum.UN_DELETED.getCode());
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBO> boList = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryList);
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.queryPrimaryCategory.subjectCategory:{}", JSON.toJSONString(boList));
        }
        return boList;
    }

    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        int count = subjectCategoryService.update(subjectCategory);
        return count >0;
    }

    public Boolean delete(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeleteFlagEnum.DELETRD.getCode());
        int count = subjectCategoryService.update(subjectCategory);
        return count >0;
    }
}
