package com.freesun.votemanager.vo;

import com.freesun.votemanager.pojo.VoteInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=false)
@ToString
public class VoteInfoVo extends VoteInfo {

    private static final long serialVersionUID = 1L;

    private Integer pageNum=1;

    private Integer pageSize=2;


}
