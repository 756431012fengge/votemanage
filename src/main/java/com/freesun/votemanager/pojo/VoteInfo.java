package com.freesun.votemanager.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class VoteInfo implements Serializable {

    private  Integer sid; //主题ID

    private  String title; //主题

    private Integer optionCount; //选项个数

    private Integer voteCount; //投票总数
}
