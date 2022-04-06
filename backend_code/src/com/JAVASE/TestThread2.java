package com.JAVASE;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//实现多线程同步下载图片
public class TestThread2 extends Thread{
    private String url;
    private String name; //保存文件名

    public TestThread2(String url,String name){
        this.url = url;
        this.name = name;
    }

    //下载图片线程的执行体
    @Override
    public void run(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为：" + name);

    }

    public static void main(String[] args) {
        TestThread2 testThread1 = new TestThread2("https://bkimg.cdn.bcebos.com/pic/a8014c086e061d95fa492c5e79f40ad162d9ca4d?x-bce-process=image/resize,m_lfit,w_220,limit_1", "./pic1.png");
        TestThread2 testThread2 = new TestThread2("https://bkimg.cdn.bcebos.com/pic/a8014c086e061d95fa492c5e79f40ad162d9ca4d?x-bce-process=image/resize,m_lfit,w_640,limit_1", "./pic2.png");
        TestThread2 testThread3 = new TestThread2("https://bkimg.cdn.bcebos.com/pic/a8014c086e061d95fa492c5e79f40ad162d9ca4d?x-bce-process=image/resize,m_lfit,w_220,limit_1", "./pic3.png");

        //下载结果不是按顺序执行，同时进行的
        testThread1.start();
        testThread2.start();
        testThread3.start();
    }
}

//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url, String name){
        try {
            //把url返回到一个file
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}

