package com.JAVASE;

//发现问题：多个线程不安全
public class TestSleep implements Runnable{

    //票数
    private int ticketNums = 10;

    @Override
    public void run(){
        while(true){
            if(ticketNums<=0){
                break;
            }
            //线程不安全，模拟网络延时，放大问题
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums + "票");
            ticketNums--;
        }
    }

    public static void main(String[] args) {
        TestThread5 ticket = new TestThread5();

        new Thread(ticket,"小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛").start();
    }
}
