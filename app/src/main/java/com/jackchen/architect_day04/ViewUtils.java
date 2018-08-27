package com.jackchen.architect_day04;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Email: 2185134304@qq.com
 * Created by JackChen 2018/3/14 17:36
 * Version 1.0
 * Params:
 * Description:    反射
*/
public class ViewUtils {

    public static void inject(Activity activity){
        // 1. 获取所有的属性
        Field[] fields = activity.getClass().getDeclaredFields();
        // 2. 过滤关于 ViewById的属性
        for (Field field : fields) {
            ViewById viewById = field.getAnnotation(ViewById.class);
            if (viewById != null){
                // 3. findViewById
                View view = activity.findViewById(viewById.value());
                // 4. 反射注入  如果一些属性是private的，就必须设置这个，否则会抛异常
                field.setAccessible(true);

                try {
                    // activity表示 属性所在的类，view表示的是 属性的值
                    field.set(activity , view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }


            }

        }


    }
}
