package com.lmx.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 题目标签表(SubjectLabel)实体类
 *
 * @author makejava
 * @since 2025-02-13 10:58:05
 */
@Data
public class SubjectLabel implements Serializable {
    private static final long serialVersionUID = -58955464516540566L;
/**
     * 主键
     */
    private Integer id;
/**
     * 标签名称
     */
    private String labelName;
/**
     * 分类id
     */
    private Integer categoryId;
/**
     * 排序
     */
    private Integer sortNum;
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

