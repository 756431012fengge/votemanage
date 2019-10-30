package com.freesun.votemanager.controller;


import com.freesun.votemanager.pojo.VoteInfo;
import com.freesun.votemanager.service.VoteInfoService;
import com.freesun.votemanager.util.ResultObj;
import com.freesun.votemanager.vo.VoteInfoVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 郑枫
 * @since 2019-10-25
 */
@RestController
@RequestMapping("/voteinfo")
public class VoteInfoController {

    @Autowired
    private VoteInfoService voteInfoService;

    @GetMapping("toGetVoteList")
    public ResultObj toGetVoteList(VoteInfoVo voteInfoVo){
        System.out.println("VoteInfoVo = " + voteInfoVo+"标题:"+voteInfoVo.getTitle());
        Map<String, Object> map=new HashMap<>();
        map.put("pageNum",voteInfoVo.getPageNum());
        map.put("pageSize",voteInfoVo.getPageSize());
        map.put("title",voteInfoVo.getTitle());
        Page<VoteInfo> page = voteInfoService.getVoteList(map);
        System.out.println("page.getTotal() = " + page.getTotal());
        PageInfo<VoteInfo> pageinfo=new PageInfo<>(page);
        return ResultObj.success().add("page",pageinfo);
    }
}
