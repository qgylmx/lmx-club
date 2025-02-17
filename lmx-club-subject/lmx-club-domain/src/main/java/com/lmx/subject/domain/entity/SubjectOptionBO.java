package com.lmx.subject.domain.entity;

import com.lmx.subject.common.entity.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 题目信息表
 * @since 2025-02-13 21:14:30
 */
@Data
public class SubjectOptionBO extends PageInfo implements Serializable {
    private static final long serialVersionUID = -26266766356044289L;

    /**
     * 题目答案
     */
    private String subjectAnswer;

    /**
     * 题目选项
     */
    private List<SubjectAnswerBO>  optionList;


}

