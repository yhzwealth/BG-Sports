package com.wealth.vo;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @program: BG-Sports
 * @author: iamYBG
 * @description: 注量Vo
 * @create: 2021-12-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class InVolumeVo {

    private Long teamId;
    private Integer total;

}
