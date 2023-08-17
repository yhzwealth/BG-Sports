package com.wealth.vo;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @program: BG-Sports
 * @author: iamYBG
 * @description: 赔率Vo
 * @create: 2021-12-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class RareVo {

    private Double rare1;
    private Double rare2;

    private Integer max1;
    private Integer max2;

}
