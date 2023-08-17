package com.wealth.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: StudentManager
 * @author: iamYBG
 * @description: 投注实体类
 * @create: 2021-12-06
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class Bet implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private Integer coins;
    private Double rare;
    private Long matchId;
    private Long teamId;

    @JsonFormat(timezone = "GMT+8", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
