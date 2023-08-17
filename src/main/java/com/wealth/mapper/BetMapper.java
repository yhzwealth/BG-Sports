package com.wealth.mapper;

import com.wealth.entity.Bet;
import com.wealth.po.BetPo;
import com.wealth.vo.BetVo;
import com.wealth.vo.InVolumeVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetMapper{
    List<BetVo> getBetInfo(String username,Integer page, Integer number);
    Integer getBetCount(String username);
    Integer countTodayBet(String username);
    List<InVolumeVo> getTotalCoins(Long id);
    void insertBet(@Param("po") BetPo po);
}
