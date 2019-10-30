package com.freesun.votemanager.mapper;

import com.freesun.votemanager.pojo.Options;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 郑枫
 * @since 2019-10-25
 */
public interface OptionsMapper extends BaseMapper<Options> {

    List<Map<String,Object>> getUserSeizeBySid(Integer sid);

    Integer saveItem(Map<String,Object> map);

    List<Map<String,Object>> voteExesit(Map<String,Object> map);

    List<Map<String,Object>> getOptionsInfo(Integer sid);
}
