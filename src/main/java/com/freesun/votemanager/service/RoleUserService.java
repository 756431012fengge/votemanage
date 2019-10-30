package com.freesun.votemanager.service;

import com.freesun.votemanager.pojo.Role;
import com.freesun.votemanager.pojo.RoleUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 郑枫
 * @since 2019-10-25
 */
public interface RoleUserService extends IService<RoleUser> {

    List<String> getRoleByUid(Integer uid);
}
