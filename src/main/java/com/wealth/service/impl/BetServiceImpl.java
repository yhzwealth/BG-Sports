package com.wealth.service.impl;

import com.wealth.entity.User;
import com.wealth.mapper.BetMapper;
import com.wealth.mapper.MatchesMapper;
import com.wealth.mapper.UserMapper;
import com.wealth.po.BetPo;
import com.wealth.service.BetService;
import com.wealth.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: StudentManager
 * @author: iamYBG
 * @description:
 * @create: 2021-12-06
 */
@Service
public class BetServiceImpl implements BetService {

    @Autowired
    private BetMapper betMapper;

    @Autowired
    private MatchesMapper matchesMapper;

    @Autowired
    private UserMapper userMapper;

    @Value("${page.betPageNum}")
    private Integer pageNum;

    @Value("${bet.returnRate}")
    private Double p;

    @Value("${bet.principal}")
    private Integer k;

    @Override
    public List<BetVo> getBetInfo(String username, Integer page) {
        List<BetVo> info = betMapper.getBetInfo(username, (page - 1) * pageNum, pageNum);
        info = info.stream().peek(k -> {
            if (k.getState() == 1) {
                k.setWinnerName(k.getPlayer1Score() > k.getPlayer2Score() ? k.getPlayer1name() : k.getPlayer2name());
            }
        }).collect(Collectors.toList());
        return info;
    }

    @Override
    public Integer getBetCount(String username) {
        return betMapper.getBetCount(username);
    }

    @Override
    public Integer countTodayBet(String username) {
        return betMapper.countTodayBet(username);
    }

    @Override
    public RareVo getRare(Long id) {
        MatchRateVo winRate = matchesMapper.getWinRate(id);
        double play1Rate = winRate.getWinRate() / (1 + winRate.getWinRate());
        double play2Rate = 1 / (1 + winRate.getWinRate());
        int initialCoins1 = (int) (play1Rate * k);
        int initialCoins2 = (int) (play2Rate * k);
        List<InVolumeVo> totalCoins = betMapper.getTotalCoins(id);
        int total = totalCoins.stream().map(InVolumeVo::getTotal).reduce(0, Integer::sum) + k;
        int now1 = initialCoins1 + totalCoins.stream().filter(k -> k.getTeamId().equals(winRate.getPlayer1())).findFirst().orElse(new InVolumeVo().setTotal(0)).getTotal();
        int now2 = initialCoins2 + totalCoins.stream().filter(k -> k.getTeamId().equals(winRate.getPlayer2())).findFirst().orElse(new InVolumeVo().setTotal(0)).getTotal();
        play1Rate = (double) now1 / total;
        play2Rate = (double) now2 / total;
        int max1, max2;
        if (play1Rate > 0.857) {
            max1 = 0;
        } else {
            max1 = (int) (((0.857) * total - now1) / 0.143);
        }
        if (play1Rate > 0.857) {
            max2 = 0;
        } else {
            max2 = (int) (((0.857) * total - now2) / 0.143);
        }
        double play1rare = p / play1Rate;
        double play2rare = p / play2Rate;
        return new RareVo(play1rare, play2rare, max1, max2);
    }

    @Override
    public Boolean bet(BetPo bet) {
        synchronized (BetServiceImpl.class) {
            MatchesVo match = matchesMapper.getMatch(bet.getMatchId());
            if (match.getTime().getTime() < System.currentTimeMillis() + 300000) {
                return false;
            }
            User info = userMapper.getInfo(bet.getUsername());
            if (info.getCoins() < bet.getCoins()) {
                return false;
            }
            RareVo rare = getRare(bet.getMatchId());
            if (bet.getPlayerNum() == 1) {
                if (rare.getMax1() < 10 || bet.getCoins() > rare.getMax1()) {
                    return false;
                } else if (bet.getRare() < rare.getRare1() - 0.1 || bet.getRare() > rare.getRare1() + 0.1){
                    return false;
                }
            } else if (bet.getPlayerNum() == 2 ) {
                if(rare.getMax2() < 10 || bet.getCoins() > rare.getMax2()){
                    return false;
                }
                else if (bet.getRare() < rare.getRare2() - 0.1 || bet.getRare() > rare.getRare2() + 0.1){
                    return false;
                }
            }else {
                return false;
            }
            userMapper.updateCoins(bet.getUsername(),-bet.getCoins());
            betMapper.insertBet(bet);

            return true;
        }
    }
}
