package com.lmx.subject.domain.handler.subject;

import com.lmx.subject.common.enums.SubjectInfoTypeEnum;
import com.lmx.subject.domain.entity.SubjectInfoBO;
import com.lmx.subject.domain.entity.SubjectOptionBO;

public interface SubjectTypeHandler {
    /**
     * 枚举身份识别
     */
    SubjectInfoTypeEnum getHandlerType();
    /**
     * 添加
     */
    void add(SubjectInfoBO subjectInfoBO);
    /**
     * 查询
     */
    SubjectOptionBO query(Integer subjectId);
}
