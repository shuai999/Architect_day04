package com.jackchen.architect_day04;

import android.util.Log;

/**
 * Created by Administrator on 2018/3/16.
 */

public class TestBean3 {

    /* 这个是一般的称呼*/
    private String name = "Darren" ;  // 属性 -> 是string类型  name -> 是名称  Darren -> 是值
    /* 在反射中，属性是Field , 构造方法是Constructor , 方法是Method*/


    public TestBean3(String name){  //这个是构造方法
        this.name = name ;
    }

    private void sysName(){
        Log.e("TAG" , "name -> " + name) ;
    }
}
