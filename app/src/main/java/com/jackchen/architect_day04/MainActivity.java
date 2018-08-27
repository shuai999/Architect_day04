package com.jackchen.architect_day04;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends BaseActivity {


    @ViewById(R.id.tv_1)
    private TextView tv_1 ;

    @ViewById(R.id.tv_2)
    private TextView tv_2 ;

    private int mPage ;


    // 方法泛型
    private <T> T viewById(int viewById){
        return (T) findViewById(viewById);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewUtils.inject(this);

        tv_1.setText("ViewById");
        tv_2.setText("ViewById2");


        new HttpCallBack<BaseResult>() {
            @Override
            public void onSuccess() {

            }
        } ;




        // 因为TestBean构造方法是private类型，无法new，所以就只能通过反射来获取对象
//        TestBean testBean = new TestBean() ;

        // 反射
        try {
            // 通过class字节码创建TestBean对象
            // 很多系统的类，都被系统隐藏了，或者说只有系统可以new，这个时候可以通过反射来创建对象
//            TestBean testBean = TestBean.class.newInstance() ;
//            testBean.sysName();

            /************* 通过构造方法创建对象 *******************/
            // getDeclaredConstructor()：从所有的构造方法里边找   getConstructor() : 从公共构造方法里边找
            // 获取一个参数的构造方法，而且参数是String类型  ，如果是构造方法有多个参数，
            // 那么可以getDeclaredConstructor(String.class,int.class...)
            Constructor constructor = TestBean.class.getDeclaredConstructor(String.class,int.class) ;
            // 设置权限，可以访问任何属性：private、public、protected都可以
            constructor.setAccessible(true);

            // "晴天不改" 调用构造方法传的参数 等同于  new TestBean("晴天不改") ;
            TestBean testBean = (TestBean) constructor.newInstance("晴天不改");
            testBean.sysName();  // TAG: name -> 晴天不改
        } catch (Exception e) {
            e.printStackTrace();
        }



        try {
            // 方法调用

//            TestBean2 testBean2 = new TestBean2("Darren") ;     //  name -> Darren
//            Method method = TestBean2.class.getDeclaredMethod("sysName") ;
//            method.setAccessible(true);
//            method.invoke(testBean2) ;


            AssetManager addAssetPath = AssetManager.class.newInstance() ;
            Method addAssetPathMethod = AssetManager.class.getDeclaredMethod("addAssetPath" , String.class) ;
            addAssetPathMethod.invoke(addAssetPath , "sdcard/dds/red.skin") ;

        }catch (Exception e){

        }


        try {
            TestBean3 testBean3 = new TestBean3("baby") ;
            // 获取属性
            Field field = TestBean3.class.getDeclaredField("name");
            field.setAccessible(true);
            String name = (String) field.get(testBean3);
            Log.e("TAG" , name) ;    //   E/TAG: baby


            Class clazz = Class.forName("android.app.ActivityThread");
            Field sCurrentActivityThreadField = clazz.getDeclaredField("sCurrentActivityThread") ;
            sCurrentActivityThreadField.setAccessible(true);
            Object mCurrentActivityThread = sCurrentActivityThreadField.get(null) ;
            Log.e("TAG" , mCurrentActivityThread.toString()) ;  //  android.app.ActivityThread@5c109d2


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
