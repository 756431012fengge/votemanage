package com.freesun.votemanager.mapper;

import com.freesun.votemanager.pojo.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 郑枫
 * @since 2019-10-24
 */
public interface PermissionMapper extends BaseMapper<Permission> {

   List<Permission> getPermissionByUid(Integer uid);
}
