package com.wealth.vo;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @program: BG-Sports
 * @author: iamYBG
 * @description: 比赛胜率Vo
 * @create: 2021-12-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class MatchRateVo {
    private Long player1;
    private Long player2;
    private Double winRate;
}
