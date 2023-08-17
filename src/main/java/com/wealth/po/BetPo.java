package com.wealth.po;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @program: BG-Sports
 * @author: iamYBG
 * @description: 竞猜传入
 * @create: 2021-12-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class BetPo {
    private String username;
    private Integer coins;
    private Double rare;
    private Long matchId;
    private Long teamId;
    private Integer playerNum;
}
