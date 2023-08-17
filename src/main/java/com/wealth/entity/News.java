package com.wealth.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: StudentManager
 * @author: iamYBG
 * @description: 新闻实体类
 * @create: 2021-12-06
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String pic;
    private String content;
    private Integer views;

    @JsonFormat(timezone = "GMT+8", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
