package com.lmx.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 判断题(SubjectJudge)实体类
 *
 * @author makejava
 * @since 2025-02-13 21:15:13
 */
@Data
public class SubjectJudge implements Serializable {
    private static final long serialVersionUID = 190430700412882649L;
/**
     * 主键
     */
    private Integer id;
/**
     * 题目id
     */
    private Integer subjectId;
/**
     * 是否正确
     */
    private Integer isCorrect;
/**
     * 创建人
     */
    private String createdBy;
/**
     * 创建时间
     */
    private Date createdTime;
/**
     * 更新人
     */
    private String updateBy;
/**
     * 更新时间
     */
    private Date updateTime;

    private Integer isDeleted;

}

