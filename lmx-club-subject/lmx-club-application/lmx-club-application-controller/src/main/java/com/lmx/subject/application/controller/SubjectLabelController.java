package com.lmx.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.lmx.subject.application.convert.SubjectLabelDTOConverter;
import com.lmx.subject.application.dto.SubjectLabelDTO;
import com.lmx.subject.common.entity.Result;
import com.lmx.subject.domain.entity.SubjectLabelBO;
import com.lmx.subject.domain.service.SubjectLabelDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/subject/label")
@Slf4j
public class SubjectLabelController {
    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;
    /**
     * 添加标签
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try {
            if (log.isInfoEnabled()){
                log.info("SubjectLabelController.add.subjectLabel:{}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkArgument(!StringUtils.isBlank(subjectLabelDTO.getLabelName()),
                    "标签名称不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE
                    .convertDtoToLabelBO(subjectLabelDTO);
            Boolean result =subjectLabelDomainService.add(subjectLabelBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.exception:{}", e.getMessage(),e);
            return Result.fail("新增标签失败");
        }
    }
    /**
     * 更新标签
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try {
            if (log.isInfoEnabled()){
                log.info("SubjectLabelController.update.subjectLabel:{}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getId(),"标签id不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE
                    .convertDtoToLabelBO(subjectLabelDTO);
            Boolean result =subjectLabelDomainService.update(subjectLabelBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.exception:{}", e.getMessage(),e);
            return Result.fail("更新标签失败");
        }
    }

    /**
     * 删除标签
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try {
            if (log.isInfoEnabled()){
                log.info("SubjectLabelController.delete.subjectLabel:{}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getId(),"标签id不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE
                    .convertDtoToLabelBO(subjectLabelDTO);
            Boolean result =subjectLabelDomainService.delete(subjectLabelBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.exception:{}", e.getMessage(),e);
            return Result.fail("更新标签失败");
        }
    }
    /**
     * 查询分类下标签
     */
    @PostMapping("/queryLabelByCategoryId")
    public Result<List<SubjectLabelDTO>> queryLabelByCategoryId(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try {
            if (log.isInfoEnabled()){
                log.info("SubjectLabelController.queryLabelByCategoryId.subjectLabel:{}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getCategoryId(),"分类id不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE
                    .convertDtoToLabelBO(subjectLabelDTO);
            List<SubjectLabelBO> resultList =subjectLabelDomainService.queryLabelByCategoryId(subjectLabelBO);
            List<SubjectLabelDTO> result = SubjectLabelDTOConverter.INSTANCE.convertBoToLabelDTOList(resultList);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryLabelByCategoryId.exception:{}", e.getMessage(),e);
            return Result.fail("查询分类下标签失败");
        }
    }

}
