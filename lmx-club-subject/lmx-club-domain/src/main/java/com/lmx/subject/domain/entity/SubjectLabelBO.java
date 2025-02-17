package com.lmx.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * SubjectLabelDTO
 *
 * @author lmx

 */
@Data
public class SubjectLabelBO implements Serializable {
    private static final long serialVersionUID = -58955464516540566L;
/**
     * 主键
     */
    private Integer id;
/**

     * 分类id
     */
    private Integer categoryId;
/**
     * 标签名称
     */
    private String labelName;
/**

     * 排序
     */
    private Integer sortNum;

}

