package com.lmx.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 单选题信息表(SubjectRadio)实体类
 *
 * @author makejava
 * @since 2025-02-13 21:15:53
 */
@Data
public class SubjectRadio implements Serializable {
    private static final long serialVersionUID = -34706237211999700L;
/**
     * 主键
     */
    private Integer id;
/**
     * 题目id
     */
    private Integer subjectId;
/**
     * 选项类型
     */
    private Integer optionType;
/**
     * 选项内容
     */
    private String optionContent;
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

