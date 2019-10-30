package com.freesun.votemanager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 *
 SELECT * FROM permission p
 INNER JOIN role_permission rp
 INNER JOIN role_user ru
 ON (p.pid=rp.pid AND ru.rid=rp.rid)
 WHERE ru.uid=1
 * </p>
 *
 * @author 郑枫
 * @since 2019-10-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString
public class Userinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String username;

    private String password;

    /**
     * 0代表是,1代表不是
     */
    private String realename;

    /**
     * 0代表在线,1代表不在
     */
    private Integer isOnline;


}
