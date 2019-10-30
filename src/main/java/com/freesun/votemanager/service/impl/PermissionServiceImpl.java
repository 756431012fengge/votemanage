package com.freesun.votemanager.service.impl;

import com.freesun.votemanager.pojo.Permission;
import com.freesun.votemanager.mapper.PermissionMapper;
import com.freesun.votemanager.service.PermissionService;
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
 * @since 2019-10-24
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Override
    public List<String> getPermissionByUid(Integer uid) {
        List<Permission> list = this.baseMapper.getPermissionByUid(uid);
        List<String> list1=new ArrayList<>();
        for (Permission permission : list) {
            list1.add(permission.getPname());
        }
        return list1;
    }
}
