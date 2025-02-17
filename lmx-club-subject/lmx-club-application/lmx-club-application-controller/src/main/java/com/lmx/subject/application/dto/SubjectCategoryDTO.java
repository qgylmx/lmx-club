package com.lmx.subject.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 题目分类(SubjectCategory)实体类
 *
 * @author makejava
 * @since 2025-02-01 22:00:21
 */
@Data
public class SubjectCategoryDTO implements Serializable {
    private static final long serialVersionUID = -36950234775305136L;
/**
     * 主键
     */
    private Integer id;
/**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类的类型
     */
    private Integer categoryType;
/**
     * 图标连接
     */
    private String imageUrl;
/**
     * 父级id
     */
    private Integer parentId;
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
}

