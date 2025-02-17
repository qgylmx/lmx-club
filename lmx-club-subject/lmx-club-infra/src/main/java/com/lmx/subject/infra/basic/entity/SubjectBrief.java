package com.lmx.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 简答题(SubjectBrief)实体类
 *
 * @author makejava
 * @since 2025-02-13 21:14:49
 */
@Data
public class SubjectBrief implements Serializable {
    private static final long serialVersionUID = 638389591240760897L;
/**
     * 主键
     */
    private Integer id;
/**
     * 题目答案
     */
    private String subjectAnswer;
/**
     * 题目id
     */
    private Integer subjectId;
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

