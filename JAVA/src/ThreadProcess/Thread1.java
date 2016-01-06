package ThreadProcess;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wissy on 2015/12/1.
 */
public class Thread1 {
    /**
     * 进程与线程
     * 1.进程是操作系统分配的空间,进程又线程组成
     * 2.进程所占内存空间独立,线程公用进程的内存空间
     * 3.进程之间信息交换耗费资源大,线程之间信息共享开销低
     *
     * 创建线程的两种方式
     * 一.继承Thread类
     *      1继承Thread类
     *      2.覆盖父类的run方法(线程体)
     *      3.数据部共享
     * 二.实现Runnable接口
     *      1.实现Runnable接口
     *      2.覆盖Runnable接口中的run方法
     *      3.利用Thread(Runnable)构造器创建线程
     *      4.可以共享数据(Runnable接口实现的对象)
     *      5.可以有父类
     */


    public static void main(String[] args) throws InterruptedException {
        // Thread.sleep(300000);
        System.out.println(Thread.currentThread().getName());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("G yyyy年MM月dd HH:mm:ss E z");
        String time = simpleDateFormat.format(new Date());
        System.out.println(time);


        MoreThread thread = new MoreThread();
        thread.start();


        for (int i = 0; i < 100000; i++) {
            if (i == 100) {
                thread.setA(false);
                break;
            }
            Thread.sleep(10);
        }

    }
}
