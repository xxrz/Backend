package com.JAVASE;

import java.util.concurrent.*;

//实现多线程同步下载图片
//多了返回值
//可以加异常
public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name; //保存文件名

    public TestCallable(String url,String name){
        this.url = url;
        this.name = name;
    }

    //下载图片线程的执行体
    @Override
    public Boolean call(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable testThread1 = new TestCallable("https://bkimg.cdn.bcebos.com/pic/a8014c086e061d95fa492c5e79f40ad162d9ca4d?x-bce-process=image/resize,m_lfit,w_220,limit_1", "./pic1.png");
        TestCallable testThread2 = new TestCallable("https://bkimg.cdn.bcebos.com/pic/a8014c086e061d95fa492c5e79f40ad162d9ca4d?x-bce-process=image/resize,m_lfit,w_640,limit_1", "./pic2.png");
        TestCallable testThread3 = new TestCallable("https://bkimg.cdn.bcebos.com/pic/a8014c086e061d95fa492c5e79f40ad162d9ca4d?x-bce-process=image/resize,m_lfit,w_220,limit_1", "./pic3.png");

        //1.创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //2.提交执行
        Future<Boolean> r1 = ser.submit(testThread1);
        Future<Boolean> r2 = ser.submit(testThread2);
        Future<Boolean> r3 = ser.submit(testThread3);

        //3. 获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        //4.关闭服务
        ser.shutdown();

    }
}
