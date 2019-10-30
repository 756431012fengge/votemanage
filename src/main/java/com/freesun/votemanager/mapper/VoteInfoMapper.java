package com.freesun.votemanager.mapper;



import com.freesun.votemanager.pojo.VoteInfo;


import java.util.List;
import java.util.Map;

public interface VoteInfoMapper {

    /* List<Map<String,Object>> getVoteList();*/
    List<VoteInfo> getVoteList(Map<String,Object> map);


}
