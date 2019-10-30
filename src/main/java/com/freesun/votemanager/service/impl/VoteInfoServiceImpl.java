package com.freesun.votemanager.service.impl;


import com.freesun.votemanager.mapper.VoteInfoMapper;
import com.freesun.votemanager.pojo.VoteInfo;
import com.freesun.votemanager.service.VoteInfoService;
import com.freesun.votemanager.vo.VoteInfoVo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VoteInfoServiceImpl implements VoteInfoService {

    @Autowired
    VoteInfoMapper voteInfoMapper;

    @Override
    public Page<VoteInfo> getVoteList(Map<String,Object> map) {
        Page<VoteInfo> page = PageHelper.startPage(map);
        List<VoteInfo> voteList = voteInfoMapper.getVoteList(map);
        return page;
    }
}
