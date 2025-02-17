package com.lmx.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.lmx.subject.application.convert.SubjectAnswerDTOConverter;
import com.lmx.subject.application.convert.SubjectCategoryDTOConverter;
import com.lmx.subject.application.convert.SubjectInfoDTOConverter;
import com.lmx.subject.application.dto.SubjectCategoryDTO;
import com.lmx.subject.application.dto.SubjectInfoDTO;
import com.lmx.subject.common.entity.PageResult;
import com.lmx.subject.common.entity.Result;
import com.lmx.subject.domain.entity.SubjectAnswerBO;
import com.lmx.subject.domain.entity.SubjectCategoryBO;
import com.lmx.subject.domain.entity.SubjectInfoBO;
import com.lmx.subject.domain.service.SubjectInfoDomainService;
import com.lmx.subject.infra.basic.entity.SubjectCategory;
import com.lmx.subject.infra.basic.service.SubjectCategoryService;
import com.lmx.subject.infra.basic.service.SubjectInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 刷题controller
 * @author lmx
 * @create 2019-09-04 17:04
 */
@RestController
@RequestMapping("/subject")
@Slf4j
public class SubjectController {
    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO){
        try {
            if (log.isInfoEnabled()){
                log.info("SubjectController.add.subjectInfo:{}", JSON.toJSONString(subjectInfoDTO));
            }

            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(),
                    "难度不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(subjectInfoDTO.getSubjectName()),
                    "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(),
                    "题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(),
                    "分数不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds()),
                    "分类id不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds()),
                    "标签id不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE
                    .convertDtoToInfoBo(subjectInfoDTO);
            List<SubjectAnswerBO> subjectAnswerBOS = SubjectAnswerDTOConverter.INSTANCE
                    .convertListDtoToAnswerBoList(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(subjectAnswerBOS);
            subjectInfoDomainService.add(subjectInfoBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectController.add.exception:{}", e.getMessage(),e);
            return Result.fail("新增题目失败");
        }
    }

    @PostMapping("/getSubjectPage")
    public Result<PageResult<SubjectInfoDTO>> getSubjectPage(@RequestBody SubjectInfoDTO subjectInfoDTO){
        try {
            if (log.isInfoEnabled()){
                log.info("SubjectController.getSubjectPage.subjectInfo:{}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(),
                    "分类id不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(),
                    "标签id不能为空");
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE
                    .convertDtoToInfoBo(subjectInfoDTO);

            PageResult<SubjectInfoBO> boPageResult = subjectInfoDomainService.getSubjectPage(subjectInfoBO);
            return Result.ok(boPageResult);
        } catch (Exception e) {
            log.error("SubjectController.add.exception:{}", e.getMessage(),e);
            return Result.fail("分页查询失败");
        }
    }

    @PostMapping("/querySubjectInfo")
    public Result<PageResult<SubjectInfoDTO>> querySubjectInfo(@RequestBody SubjectInfoDTO subjectInfoDTO){
        try {
            if (log.isInfoEnabled()){
                log.info("SubjectController.querySubjectInfo.subjectInfo:{}", JSON.toJSONString(subjectInfoDTO));

            }
            Preconditions.checkNotNull(subjectInfoDTO.getId(),
                    "题目id不能为空");
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE
                    .convertDtoToInfoBo(subjectInfoDTO);

            SubjectInfoBO boResult = subjectInfoDomainService.querySubjectInfo(subjectInfoBO);
            SubjectInfoDTO dtoResult = SubjectInfoDTOConverter.INSTANCE.convertBoToInfoDto(boResult);
            return Result.ok(dtoResult);
        } catch (Exception e) {
            log.error("SubjectController.add.exception:{}", e.getMessage(),e);
            return Result.fail("查询题目详情失败");
        }
    }
}
