package com.wealth.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @program: BG-Sports
 * @author: iamYBG
 * @description: 投注Vo
 * @create: 2021-12-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class BetVo {
    private Long id;
    private String username;
    private Integer coins;
    private Double rare;
    private String matchType;
    private String matchName;
    private String teamName;
    private String winnerName;

    @JsonFormat(timezone = "GMT+8", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Integer state;
    private Integer player1Score;
    private String player1name;
    private Integer player2Score;
    private String player2name;
}
