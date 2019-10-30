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
 * </p>
 *
 * @author 郑枫
 * @since 2019-10-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 投票主题id
     */
    @TableId(value = "sid", type = IdType.AUTO)
    private Integer sid;

    private String title;

    /**
     * 投票类型 0:单选,1:多选
     */
    private Integer type;


}
