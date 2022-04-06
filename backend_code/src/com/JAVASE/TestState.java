package com.JAVASE;


public class TestState{

    public static void main(String[] args) throws InterruptedException {
        //利用lambda表达式重写run
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000); //1s
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("////");
        });

        //观察状态
        Thread.State state  =  thread.getState();
        System.out.println(state); //new

        //观察启动后
        thread.start();
        state = thread.getState();
        System.out.println(state); //run

        while(state!= Thread.State.TERMINATED) {//只要线程不终止
            Thread.sleep(100);
            state = thread.getState(); //更新状态
            System.out.println(state); //输出状态
        }

        thread.start();
    }
}
