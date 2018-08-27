package com.jackchen.architect_day04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Email: 2185134304@qq.com
 * Created by JackChen 2018/3/26 22:07
 * Version 1.0
 * Params:
 * Description:
*/

public class BaseActivity extends AppCompatActivity {


    // ? 通配符，代表任意类型
    // Class只要是继承自BaseActivity的，都可以用startActivity()这个方法
    // extends代表的是 泛型的上限
    public void startActivity(Class<? extends BaseActivity> clazz) {
        Intent intent = new Intent(this , clazz) ;
        startActivity(intent);
    }

    // super代表的是 泛型的下限
    public void startActivity1(Class<? super MainActivity> clazz){
        Intent intent = new Intent(this , clazz) ;
        startActivity(intent);
    }
}
