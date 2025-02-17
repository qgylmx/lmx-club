package com.lmx.subject.application.dto;

import com.lmx.subject.common.entity.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 题目信息表
 * @since 2025-02-13 21:14:30
 */
@Data
public class SubjectInfoDTO extends PageInfo implements Serializable {
    private static final long serialVersionUID = -26266766356044289L;
/**
     * 主键
     */
    private Integer id;
/**
     * 题目名称
     */
    private String subjectName;
/**
     * 题目难度
     */
    private Integer subjectDifficult;
/**
     * 出题人名
     */
    private String settleName;
/**
     * 题目类型 1单选 2多选 3判断 4简答
     */
    private Integer subjectType;
/**
     * 题目分数
     */
    private Integer subjectScore;
/**
     * 题目解析
     */
    private String subjectParse;


    private Integer isDeleted;
    /**
     * 题目答案
     */
    private String subjectAnswer;
    /**
     * 题目分类id
     */
    private List<Integer> categoryIds;
    /**
     * 题目标签id
     */
    private List<Integer> labelIds;
    /**
     * 题目标签名称
     */
    private List<String> labelName;
    /**
     * 题目选项
     */
    private List<SubjectAnswerDTO>  optionList;

    private Integer categoryId;

    private Integer labelId;

}

