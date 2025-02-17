package com.lmx.subject.domain.service.impl;
import com.lmx.subject.common.enums.IsDeleteFlagEnum;
import com.lmx.subject.domain.convert.SubjectLabelConverter;
import com.lmx.subject.domain.entity.SubjectLabelBO;
import com.lmx.subject.domain.service.SubjectLabelDomainService;
import com.lmx.subject.infra.basic.entity.SubjectLabel;
import com.lmx.subject.infra.basic.entity.SubjectMapping;
import com.lmx.subject.infra.basic.service.SubjectLabelService;
import com.lmx.subject.infra.basic.service.SubjectMappingService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {
    @Resource
    private SubjectLabelService subjectLabelService;
    @Resource
    private SubjectMappingService subjectMappingService;
    public Boolean add(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBoToLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeleteFlagEnum.UN_DELETED.getCode());
        int count = subjectLabelService.insert(subjectLabel);
        return count > 0;
    }
    @Override
    public Boolean update(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBoToLabel(subjectLabelBO);

        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }
    @Override
    public Boolean delete(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBoToLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeleteFlagEnum.DELETRD.getCode());
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }
    @Override
    public List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO) {
        Integer categoryId = subjectLabelBO.getCategoryId();
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(categoryId);
        subjectMapping.setIsDeleted(IsDeleteFlagEnum.UN_DELETED.getCode());
        List<SubjectMapping> subjectMappingList =subjectMappingService.queryLabelId(subjectMapping);
        if ((CollectionUtils.isEmpty(subjectMappingList))){
            return Collections.emptyList();
        }
        List<Integer> labelIdList = subjectMappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> labelList =subjectLabelService.batchQueryById(labelIdList);
        List<SubjectLabelBO> bolist = new LinkedList<>();
        labelList.forEach(label->{
            SubjectLabelBO bo = new SubjectLabelBO();
            bo.setId(label.getId());
            bo.setCategoryId(categoryId);
            bo.setLabelName(label.getLabelName());
            bo.setSortNum(label.getSortNum());
            bolist.add(bo);
        });
        return bolist;
    }
}
