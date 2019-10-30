package com.freesun.votemanager.service.impl;

import com.freesun.votemanager.pojo.Role;
import com.freesun.votemanager.pojo.RoleUser;
import com.freesun.votemanager.mapper.RoleUserMapper;
import com.freesun.votemanager.service.RoleUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 郑枫
 * @since 2019-10-25
 */
@Service
public class RoleUserServiceImpl extends ServiceImpl<RoleUserMapper, RoleUser> implements RoleUserService {

    @Override
    public List<String> getRoleByUid(Integer uid) {
        List<Role> list = this.baseMapper.getRoleByUid(uid);
        List<String> list1=new ArrayList<>();
        for (Role role : list) {
            list1.add(role.getRname());
        }
        return list1;
    }
}
