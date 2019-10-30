package com.freesun.votemanager.controller;


import com.freesun.votemanager.util.ResultObj;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 郑枫
 * @since 2019-10-24
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @RequiresPermissions(value = "addVote")
    @GetMapping("toSaveSubject")
    public ResultObj toSaveSubject(){

        return ResultObj.success();
    }

    @RequiresPermissions(value = "joinVote")
    @GetMapping("toSaveVote")
    public ResultObj toSaveVote(){

        return ResultObj.success();
    }

    @RequiresPermissions(value = "modifyVote")
    @GetMapping("toSafeVote")
    public ResultObj toSafeVote(){

        return ResultObj.success();
    }
}
