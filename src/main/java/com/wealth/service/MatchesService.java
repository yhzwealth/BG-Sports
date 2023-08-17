package com.wealth.service;

import com.wealth.vo.MatchesVo;

import java.util.List;

public interface MatchesService {
    List<MatchesVo> getUnCompleteMatch(String type,Integer page);
    List<MatchesVo> getUnCompleteMatch();
    Integer getUnCompleteMatchCount(String type);
    List<MatchesVo> getCompleteMatch(String type,Integer page);
    Integer getCompleteMatchCount(String type);
    MatchesVo getMatch(Long id);
}
