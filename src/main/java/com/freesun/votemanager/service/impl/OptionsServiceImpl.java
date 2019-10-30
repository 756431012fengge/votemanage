package com.freesun.votemanager.service.impl;

import com.freesun.votemanager.pojo.Options;
import com.freesun.votemanager.mapper.OptionsMapper;
import com.freesun.votemanager.service.OptionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 郑枫
 * @since 2019-10-25
 */
@Service
public class OptionsServiceImpl extends ServiceImpl<OptionsMapper, Options> implements OptionsService {

  public  List<Map<String,Object>> getUserSeizeBySid(Integer sid){

        return this.baseMapper.getUserSeizeBySid(sid);
    }

    @Override
    public boolean saveItem(Map<String, Object> map) {
        Integer integer = this.baseMapper.saveItem(map);
        if(integer>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean voteExesit(Map<String, Object> map) {
        List<Map<String, Object>> maps = this.baseMapper.voteExesit(map);
        if(null!=maps&&maps.size()>0)
            return true;
        else
            return false;
    }

    @Override
    public List<Map<String, Object>> getOptionsInfo(Integer sid) {

        return this.baseMapper.getOptionsInfo(sid);
    }
}
