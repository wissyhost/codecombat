package ThreadProcess;

/**
 * Created by wissy on 2015/12/1.
 */
public class Thread2 {
    public static void main(String[] args) {
        MoreThread2 moreThread2= new MoreThread2();
        Thread thread1=new Thread(moreThread2,"11");
        Thread thread2=new Thread(moreThread2,"22");


            thread1.start();
            thread2.start();

    }
}
