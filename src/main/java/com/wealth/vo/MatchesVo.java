package com.wealth.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @program: BG-Sports
 * @author: iamYBG
 * @description: 比赛视图
 * @create: 2021-12-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class MatchesVo {

    private Long id;
    private String name;
    private Long player1;
    private String player1name;
    private String play1pic;
    private Integer player1Score;
    private Long player2;
    private String player2name;
    private String play2pic;
    private Integer player2Score;

    @JsonFormat(timezone = "GMT+8", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String type;


}
