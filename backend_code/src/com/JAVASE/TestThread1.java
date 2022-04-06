package com.JAVASE;
//步骤
//1.自定义的线程类继承Thread类
//2.重写run()方法，编写线程执行体
//3.创建线程对象，调用start()方法启动线程
//总结：线程不一定立即执行，而是并行交替进行，由cpu安排调度

//1. 继承Thread类
public class TestThread1 extends Thread{
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

        //创建线程对象
        TestThread1 testThread1 = new TestThread1();
        //3. 调用start()方法开启线程（交替执行，并行）
        testThread1.start();

        //先run后main（不是并发）
//        testThread1.run();

        for (int i = 0; i < 20; i++) {
            System.out.println("main:"+i);
        }
    }
}
