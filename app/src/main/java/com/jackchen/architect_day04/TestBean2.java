package com.jackchen.architect_day04;

import android.util.Log;

/**
 * Created by Administrator on 2018/3/16.
 */

public class TestBean2 {

    /* 这个是一般的称呼*/
    private String name = "Darren" ;  // 属性 -> 是string类型  name -> 是名称  Darren -> 是值
    /* 在反射中，属性是Field , 构造方法是Constructor , 方法是Method*/


    public TestBean2(String name){  //这个是构造方法
        this.name = name ;
    }

    public String getName(){  //这个是方法  getName -> 是方法名字  String -> 是返回类型
        return name ;
    }

    private void sysName(){
        Log.e("TAG" , "name -> " + name) ;
    }
}
