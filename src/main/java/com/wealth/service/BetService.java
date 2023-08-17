package com.wealth.service;

import com.wealth.po.BetPo;
import com.wealth.vo.BetVo;
import com.wealth.vo.RareVo;

import java.util.List;

public interface BetService {
    List<BetVo> getBetInfo(String username, Integer page);
    Integer getBetCount(String username);
    Integer countTodayBet(String username);
    RareVo getRare(Long id);
    Boolean bet(BetPo bet);
}
