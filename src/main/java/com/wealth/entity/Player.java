package com.wealth.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: StudentManager
 * @author: iamYBG
 * @description: 玩家实体类
 * @create: 2021-12-06
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String pic;
}
