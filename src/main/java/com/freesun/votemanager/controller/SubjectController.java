package com.freesun.votemanager.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.freesun.votemanager.pojo.Options;
import com.freesun.votemanager.pojo.Subject;
import com.freesun.votemanager.service.OptionsService;
import com.freesun.votemanager.service.SubjectService;
import com.freesun.votemanager.util.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 郑枫
 * @since 2019-10-26
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;
    @Autowired
    private OptionsService optionsService;
    @PostMapping("saveSubject")
    public ResultObj saveSubject(Subject subject,
                                 @RequestParam("options") List<String> list){
        List<Options> optionsList=new ArrayList<>();
        HashSet set = new HashSet<>(list);
        Boolean result = set.size() == list.size() ? true : false;
        if(result){
            subjectService.save(subject);
            for (String s : list) {
            Options options=new Options();
            options.setOsid(subject.getSid());
            options.setOcontent(s);
            optionsList.add(options);
            }
            optionsService.saveBatch(optionsList);
            return ResultObj.success();
        }
        return ResultObj.fail().add("optInfo","有重复选项");
    }

    @PutMapping("saveSubject/{sid}")
    public ResultObj updateSubject(Subject subject,
                                 @RequestParam("options") List<String> list) {
        for (String s : list) {
            System.out.println("s = " + s);
        }
        System.out.println("subject = " + subject);
        List<Options> optionsList=new ArrayList<>();
        HashSet set = new HashSet<>(list);
        Boolean result = set.size() == list.size() ? true : false;
        if(result){
            subjectService.updateById(subject);
            QueryWrapper<Options> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("osid",subject.getSid());
            optionsService.remove(queryWrapper);
            for (String s : list) {
                Options options=new Options();
                options.setOsid(subject.getSid());
                options.setOcontent(s);
                optionsList.add(options);
            }
            optionsService.saveBatch(optionsList);
        return ResultObj.success();
     }
        return ResultObj.fail().add("optInfo","有重复选项");
    }
}
