package com.freesun.votemanager.util;


import com.freesun.votemanager.commons.Constast;
import jdk.internal.dynalink.beans.StaticClass;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class ResultObj {
    private Integer code;

    private String  msg;

    private  Map<String,Object> map=new HashMap<>();

    public static ResultObj success() {
        ResultObj result = new ResultObj();
        result.setCode(Constast.SUCCESS);
        result.setMsg("处理成功!");
        return result;
    }
    public static ResultObj fail() {
        ResultObj result = new ResultObj();
        result.setCode(Constast.FAILE);
        result.setMsg("处理失败!");
        return result;
    }

    public ResultObj add(String key,Object value) {
        this.getMap().put(key, value);
        return this;
    }


}
