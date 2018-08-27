package com.jackchen.architect_day04;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Email: 2185134304@qq.com
 * Created by JackChen 2018/3/14 17:35
 * Version 1.0
 * Params:
 * Description:
*/
// Target：表示作用在谁身上，也就是把@ViewById放的位置，是下边3个中的一个
// FIELD：表示属性，就表示放在MainActivity中的private String name上边
// METHOD：表示方法，就表示放在MainActiivty中的checkNet()方法上边
// TYPE：表示类，就表示放在MainActivity的类名上边

// Retention：表示什么时候起作用
// RUNTIME：表示运行时起作用（程序运行的时候）
// CLASS：表示编译时（打包的时候）
// SOURCE：编程阶段
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewById {   //@interface 表示注解

    int value() ;// 这个代表的是@ViewById(R.id.tv1) 中的 R.id.tv1

}
