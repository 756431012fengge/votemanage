package com.freesun.votemanager.service;

import com.freesun.votemanager.pojo.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 郑枫
 * @since 2019-10-24
 */
public interface PermissionService extends IService<Permission> {

    List<String> getPermissionByUid(Integer uid);
}
