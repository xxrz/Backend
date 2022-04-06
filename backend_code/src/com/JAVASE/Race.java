package com.JAVASE;

public class Race implements Runnable{
    //胜利者
    private static String winner;

    @Override
    public void run(){
        //模拟赛道
        for (int i = 0; i <= 100; i++) {
            //模拟兔子休息
            if(Thread.currentThread().getName().equals("兔子") && i%20==0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //判断比赛是否结束
            boolean flag = gameOver(i);

            //比赛结束就停止程序
            if(flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"-->跑了" + i + "步");
        }
    }

    //查看游戏是否结束
    private boolean gameOver(int steps){
        if(winner!=null) {
            return true;
        }
        if(steps>=100) {
            winner = Thread.currentThread().getName();
            System.out.println("winner is " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
