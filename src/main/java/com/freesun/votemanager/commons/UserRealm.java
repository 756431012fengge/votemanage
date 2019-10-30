package com.freesun.votemanager.commons;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.freesun.votemanager.pojo.Userinfo;
import com.freesun.votemanager.service.PermissionService;
import com.freesun.votemanager.service.RoleUserService;
import com.freesun.votemanager.service.UserinfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    @Lazy
    private UserinfoService userinfoService;
    @Autowired
    @Lazy
    private RoleUserService roleUserService;

    @Autowired
    @Lazy
    private PermissionService permissionService;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /*
     *   认证方法
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户名
        String username = token.getPrincipal().toString();
        QueryWrapper<Userinfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        Userinfo userinfo = userinfoService.getOne(queryWrapper);
        if(null!=userinfo){
            //查询用户角色
            List<String> roles = roleUserService.getRoleByUid(userinfo.getUserId());
            //查询用户权限
            List<String> permissions = permissionService.getPermissionByUid(userinfo.getUserId());
            //创建自定义传参对象
            ActiverUser activerUser=new ActiverUser();
            activerUser.setUserinfo(userinfo);
            activerUser.setRoles(roles);
            activerUser.setPermissons(permissions);

            //加盐
            ByteSource credentialsSalt=ByteSource.Util.bytes(userinfo.getRealename());
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activerUser,userinfo.getPassword(),credentialsSalt,this.getName());
            return info;
        }
        return null;
    }

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取传入对象
        ActiverUser activerUser = (ActiverUser) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<String> roles = activerUser.getRoles();
        List<String> permissons = activerUser.getPermissons();
        if(null!=roles&&roles.size()>0){
            info.addRoles(roles);
        }
        if(null!=permissons&&permissons.size()>0){
            info.addStringPermissions(permissons);
        }
        return info;
    }


}
