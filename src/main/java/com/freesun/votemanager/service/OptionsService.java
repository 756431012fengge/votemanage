package com.freesun.votemanager.service;

import com.freesun.votemanager.pojo.Options;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 郑枫
 * @since 2019-10-25
 */
public interface OptionsService extends IService<Options> {

    List<Map<String,Object>> getUserSeizeBySid(Integer sid);

    boolean saveItem(Map<String,Object> map);

    boolean voteExesit(Map<String,Object> map);

    List<Map<String,Object>> getOptionsInfo(Integer sid);
}
