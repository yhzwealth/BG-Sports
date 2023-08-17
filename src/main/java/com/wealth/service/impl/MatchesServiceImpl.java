package com.wealth.service.impl;

import com.wealth.mapper.MatchesMapper;
import com.wealth.service.MatchesService;
import com.wealth.vo.MatchesVo;
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
public class MatchesServiceImpl implements MatchesService {

    @Autowired
    private MatchesMapper matchesMapper;

    @Value("${page.matchPageNum}")
    private Integer pageNum;

    @Value("${storage.local.visitAddress}")
    private String picUrl;

    @Override
    public List<MatchesVo> getUnCompleteMatch(String type, Integer page) {
        if (type.equals("all")) {
            type = null;
        }
        List<MatchesVo> match = matchesMapper.getUnCompleteMatch((page - 1) * pageNum, pageNum, type);
        return match.stream().peek(k -> {
            k.setPlay1pic(picUrl + k.getPlay1pic());
            k.setPlay2pic(picUrl + k.getPlay2pic());
        }).collect(Collectors.toList());
    }

    @Override
    public List<MatchesVo> getUnCompleteMatch() {
        List<MatchesVo> match = matchesMapper.getUnCompleteMatch(0, 3, null);
        return match.stream().peek(k -> {
            k.setPlay1pic(picUrl + k.getPlay1pic());
            k.setPlay2pic(picUrl + k.getPlay2pic());
        }).collect(Collectors.toList());
    }

    @Override
    public Integer getUnCompleteMatchCount(String type) {
        if (type.equals("all")) {
            type = null;
        }
        return matchesMapper.getUnCompleteMatchCount(type);
    }

    @Override
    public List<MatchesVo> getCompleteMatch(String type, Integer page) {
        if (type.equals("all")) {
            type = null;
        }
        List<MatchesVo> match = matchesMapper.getCompleteMatch((page - 1) * pageNum, pageNum, type);
        return match.stream().peek(k -> {
            k.setPlay1pic(picUrl + k.getPlay1pic());
            k.setPlay2pic(picUrl + k.getPlay2pic());
        }).collect(Collectors.toList());
    }

    @Override
    public Integer getCompleteMatchCount(String type) {
        if (type.equals("all")) {
            type = null;
        }
        return matchesMapper.getCompleteMatchCount(type);
    }

    @Override
    public MatchesVo getMatch(Long id) {
        MatchesVo match = matchesMapper.getMatch(id);
        return match.setPlay1pic(picUrl + match.getPlay1pic()).setPlay2pic(picUrl + match.getPlay2pic());
    }
}
