package ThreadProcess;

/**
 * Created by wissy on 2015/12/1.
 */
public class MoreThread extends  Thread{
    /**
     * 定义一个线程
     * 1.继承自Thread类
     * 2.重写run方法(线程体)
     * 3.启动线程用start方法
     *
     * 线程的5种状态
     *  1.新建
     *  2.可运行状态
     *  3.运行中
     *  4.阻塞
     *  5.死亡
     *
     *  线程的生命周期
     *  1.调用Thread类的构造器创建一个对象,线程进入新建状态
     *  2.线程对象调用start方法,线程进入可运行状态
     *  3.线程获得cpu执行资源,线程进入运行状态
     *  4.线程运行时发生阻塞,线程进入阻塞状态
     *      阻塞结束后,进入可运行状态
     *  5.线程体执行结束,线程进入死亡状态
     *  */
    private boolean a=true;

    public void setA(boolean a) {
        this.a = a;
    }

    private int aa=0;
    @Override
    public void run() {
        while(a){aa+=1;
            System.out.println(aa);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
