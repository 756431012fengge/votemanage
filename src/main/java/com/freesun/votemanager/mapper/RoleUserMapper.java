package com.freesun.votemanager.mapper;

import com.freesun.votemanager.pojo.Role;
import com.freesun.votemanager.pojo.RoleUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 郑枫
 * @since 2019-10-25
 */
public interface RoleUserMapper extends BaseMapper<RoleUser> {

    List<Role> getRoleByUid(Integer uid);
}
