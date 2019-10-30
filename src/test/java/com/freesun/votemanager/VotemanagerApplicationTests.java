package com.freesun.votemanager;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.freesun.votemanager.mapper.OptionsMapper;
import com.freesun.votemanager.mapper.VoteInfoMapper;
import com.freesun.votemanager.pojo.Userinfo;
import com.freesun.votemanager.pojo.VoteInfo;
import com.freesun.votemanager.service.UserinfoService;


import com.freesun.votemanager.service.VoteInfoService;
import com.freesun.votemanager.vo.VoteInfoVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
class VotemanagerApplicationTests {

    @Autowired
    UserinfoService userinfoService;

    @Autowired
    VoteInfoMapper voteInfoMapper;

    @Autowired
    VoteInfoService voteInfoService;

    @Autowired
    OptionsMapper optionsMapper;

    @Test
    void contextLoads() {
       String source="111111";
        Md5Hash hash= new Md5Hash(source);
        System.out.println("hash.toString() = " + hash.toString());

        Md5Hash hash2= new Md5Hash(source,"张麻子");
        System.out.println("hash2.toString() = " + hash2.toString());

        Md5Hash hash3= new Md5Hash(source,"测试账户",2);
        System.out.println("hash3.toString() = " + hash3.toString());
    }

    @Value(value = "${shiro.hash-algorithm-name}")
    private String a;

    @Test
    void test(){
       /* List<Map<String,Object>> list = voteInfoMapper.getVoteList();
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }*/

       /* IPage<VoteInfo> page=new Page<VoteInfo>(1,2);
        QueryWrapper<VoteInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.like(StringUtils.isEmpty("aa"),"s.title","意向");
        IPage<VoteInfo> page2= voteInfoMapper.selectPage(page,queryWrapper);
        List<VoteInfo> list = page2.getRecords();
        long pages = page2.getPages();
        System.out.println("pages = " + pages);
        System.out.println("page2.getTotal() = " + page2.getTotal());
        for (VoteInfo voteInfo : list) {
            System.out.println("voteInfo = " + voteInfo);
        }
*/


        /*VoteInfoVo voteInfo=new VoteInfoVo();
        voteInfo.setPageNum(1);
        voteInfo.setLimit(1);
        List<VoteInfo> voteList = voteInfoService.getVoteList(voteInfo);*/
    }

    @Test
    void test2(){
        Map<String, Object> map=new HashMap<>();
        map.put("pageNum",1);
        map.put("pageSize",2);
        map.put("title","意向");
        Page<VoteInfo> page = PageHelper.startPage(map);
        List<VoteInfo> voteList = voteInfoMapper.getVoteList(map);

        List<VoteInfo> result = page.getResult();
        for (VoteInfo voteInfo : result) {
            System.out.println("voteInfo = " + voteInfo);
        }
    }

    @Test
    void test3(){
        List<Map<String, Object>> list = optionsMapper.getUserSeizeBySid(1);
        for (Map<String, Object> map : list) {
            System.out.println("map = " + map);
        }
    }
}
