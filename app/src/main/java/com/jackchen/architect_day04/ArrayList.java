package com.jackchen.architect_day04;

/**
 * Email: 2185134304@qq.com
 * Created by JackChen 2018/3/26 21:45
 * Version 1.0
 * Params:
 * Description:
*/

// T代表任意类型
// 类泛型
public class ArrayList<T> {

    private Object[] items = new Object[10] ;


    // 方法泛型
    public <T> void add(T t){
        items[0] = t ;
    }


}
