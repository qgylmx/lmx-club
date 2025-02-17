package com.lmx.subject.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 题目答案
 * @since 2025-02-13 21:14:30
 */
@Data
public class SubjectAnswerDTO implements Serializable {
    /**
     * 答案选项标识
     */
    private Integer optionType;
    /**
     * 答案选项内容
     */
    private String optionContent;
    /**
     * 答案选项是否正确
     */
    private Integer isCorrect;

}

