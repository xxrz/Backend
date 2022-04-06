package com.JAVASE;

//实现runnable接口
public class TestThread3 implements Runnable{
    //2. 重写run方法
    @Override
    public void run(){
        //线程体
        for(int i = 0;i < 20;i++){
            System.out.println("run:"+i);
        }
    }

    public static void main(String[] arg){
        //main线程，主线程

        //创建runnable接口的实现类对象
        TestThread3 testThread3 = new TestThread3();
        //创建线程对象，通过线程对象来开启我们的线程，代理
        Thread thread = new Thread(testThread3);
        thread.start();

//        new Thread(testThread3).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("main:"+i);
        }
    }
}
