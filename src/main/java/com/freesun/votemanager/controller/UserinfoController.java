package com.freesun.votemanager.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.freesun.votemanager.commons.ActiverUser;
import com.freesun.votemanager.commons.Constast;
import com.freesun.votemanager.pojo.Userinfo;
import com.freesun.votemanager.service.UserinfoService;
import com.freesun.votemanager.util.ResultObj;
import com.freesun.votemanager.vo.UserinfoVo;
import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 郑枫
 * @since 2019-10-24
 */
@RestController
@RequestMapping("/user")
public class UserinfoController {

    @Autowired
    private UserinfoService userinfoService;

    //登录验证
    @PostMapping("login")
    public ResultObj login(UserinfoVo userinfoVo){
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token=new UsernamePasswordToken(userinfoVo.getUsername(),userinfoVo.getPassword());
        try {
            subject.login(token);
            ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
            System.out.println("登录成功");
            Userinfo userinfo = activerUser.getUserinfo();
            //用户名重复
            if(userinfo.getIsOnline().equals(Constast.IS_ONLINE)){
                return ResultObj.fail().add("loginInfo",Constast.LOGIN_AGAIN);
            }
            userinfo.setIsOnline(Constast.IS_ONLINE);
            UpdateWrapper<Userinfo> updateWrapper=new UpdateWrapper<>();
            updateWrapper.set("is_online",Constast.IS_ONLINE);
            updateWrapper.eq("user_id",userinfo.getUserId());
            userinfoService.update(updateWrapper);
            return ResultObj.success().add("loginInfo", Constast.LOGIN_SUCCESS)
                    .add("userInfo",userinfo.getUserId());
        } catch (AuthenticationException e) {
            System.out.println("失败");
            return ResultObj.fail().add("loginInfo",Constast.LOGIN_FAILE);

        }

    }
    //查询用户名
    @GetMapping("toUsername/{username}")
    public ResultObj toUsername(@PathVariable String username){
        QueryWrapper<Userinfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        Userinfo userinfo = userinfoService.getOne(queryWrapper);
        if(null!=userinfo){
            return ResultObj.fail().add("message",Constast.USERNAME_IS_EXIST);
        }
        return ResultObj.success().add("message",Constast.USERNAME_CAN_USE);
    }
    //查询用户ByID
    @GetMapping("toGetUserById")
    public ResultObj toGetUserById(@RequestParam("id") Integer id) {
        Userinfo userinfo = userinfoService.getById(id);
        return ResultObj.success().add("uname", userinfo.getRealename());
    }
    //注册用户
    @PostMapping("toRegister")
    public ResultObj toRegister(UserinfoVo userinfoVo){
        boolean result = userinfoService.save(userinfoVo);
        if(result){
            return ResultObj.success().add("regInfo",Constast.REG_SUCCESS);
        }
        return ResultObj.fail().add("regInfo",Constast.REG_FAILE);
    }
}
