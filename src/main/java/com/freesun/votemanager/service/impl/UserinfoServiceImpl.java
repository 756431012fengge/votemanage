package com.freesun.votemanager.service.impl;

import com.freesun.votemanager.commons.Constast;
import com.freesun.votemanager.pojo.RoleUser;
import com.freesun.votemanager.pojo.Userinfo;
import com.freesun.votemanager.mapper.UserinfoMapper;
import com.freesun.votemanager.service.RoleUserService;
import com.freesun.votemanager.service.UserinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 郑枫
 * @since 2019-10-24
 */
@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements UserinfoService {

    @Value(value = "${shiro.hash-algorithm-name}")
    private String hashAlgorithmName;
    @Value(value = "${shiro.hash-iterations}")
    private Integer hashIterations;

    @Autowired
    private RoleUserService roleUserService;
    @Override
    public boolean save(Userinfo userinfo) {
        if(hashAlgorithmName.equals("md5")){
            Md5Hash hash= new Md5Hash(userinfo.getPassword(),userinfo.getRealename(),hashIterations);
            userinfo.setPassword(hash.toString());
            boolean save = super.save(userinfo);
            if(!save){
                return false;
            }else {
                RoleUser entiy=new RoleUser(Constast.NORMAL_USER,userinfo.getUserId());
                return roleUserService.save(entiy);
            }
        }
        return false;
    }
}
