package com.wealth.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: StudentManager
 * @author: iamYBG
 * @description: 比赛实体类
 * @create: 2021-12-06
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class Matches implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;
    private Long player1;
    private Integer player1Score;
    private Long player2;
    private Integer player2Score;
    private Double winRate;

    @JsonFormat(timezone = "GMT+8", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String type;
    private Integer state;
}
