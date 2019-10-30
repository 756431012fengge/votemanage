package com.freesun.votemanager.service;


import com.freesun.votemanager.pojo.VoteInfo;
import com.github.pagehelper.Page;

import java.util.Map;

public interface VoteInfoService {

    Page<VoteInfo> getVoteList(Map<String,Object> map);
}
