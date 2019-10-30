package com.freesun.votemanager.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.freesun.votemanager.pojo.Options;
import com.freesun.votemanager.pojo.Subject;
import com.freesun.votemanager.pojo.VoteInfo;
import com.freesun.votemanager.service.OptionsService;
import com.freesun.votemanager.service.SubjectService;
import com.freesun.votemanager.service.VoteInfoService;
import com.freesun.votemanager.util.ResultObj;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;
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
@RequestMapping("/options")
public class OptionsController {

    @Autowired
    private OptionsService optionsService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    VoteInfoService voteInfoService;


    @GetMapping("toGetOptions")
    public ResultObj toGetOptions(Integer id){
        QueryWrapper<Options> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("osid",id);
        List<Options> list = optionsService.list(queryWrapper);
        Subject subject = subjectService.getById(id);
        List<Map<String, Object>> mapList = optionsService.getUserSeizeBySid(id);
        return ResultObj.success()
                .add("options",list)
                .add("totalUser",mapList.size())
                .add("subject",subject);
    }

    @PostMapping("toSaveItem/{sid}/{uid}")
    public ResultObj toSaveItem(@PathVariable("sid") Integer sid,
                                @PathVariable("uid") Integer uid,
                                @RequestParam("oid") List<Integer> oids){
        System.out.println("sid = " + sid);
        System.out.println("uid = " + uid);
        System.out.println("map = " + oids);
        Map<String,Object> map=new HashMap<>();
        map.put("uid",uid);
        map.put("sid",sid);
        for (Integer oid : oids) {
            map.put("oid",oid);
            optionsService.saveItem(map);
        }
        return ResultObj.success();
    }

    @GetMapping("toSaveItem/{sid}/{uid}")
    public ResultObj toSaveItem(@PathVariable("sid") Integer sid,
                                @PathVariable("uid") Integer uid){
        Map<String,Object> map = new HashMap<>();
        map.put("uid",uid);
        map.put("sid",sid);
        boolean exesit = optionsService.voteExesit(map);
        if(exesit){
            return ResultObj.fail();
        }
        return ResultObj.success();

    }

    @GetMapping("toGetOptionsInfo")
    public ResultObj toGetOptionsInfo(Integer id){
        List<Map<String, Object>> optionsInfo = optionsService.getOptionsInfo(id);
        Long sum=0L;
        for (Map<String, Object> map : optionsInfo) {
            Long num = (Long) map.get("optCounts");
            sum+=num;
        }
        if(sum!=0){
            for (Map<String, Object> map : optionsInfo) {
                Long num = (Long) map.get("optCounts");
                NumberFormat nf = NumberFormat.getPercentInstance();
                nf.setMinimumFractionDigits(2);
                double pr=(num*1.0/sum);
                String percent = nf.format(pr);
                map.put("percent",percent);
            }
        }else{
            for (Map<String, Object> map : optionsInfo) {
                map.put("percent","0.00%");
            }
        }

        Subject subject = subjectService.getById(id);
        return ResultObj.success().add("optionsInfo",optionsInfo)
                .add("subject",subject).add("sum",sum);
    }
    @GetMapping("toGetVoteInfo")
    public ResultObj toGetVoteInfo(Integer sid){
        QueryWrapper<Options> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("osid",sid);
        List<Options> options = optionsService.list(queryWrapper);
        Subject subject = subjectService.getById(sid);
        return ResultObj.success().add("options",options).add("subject",subject);
    }
}
