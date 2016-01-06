package ThreadProcess;

/**
 * Created by wissy on 2015/12/1.
 */
public class MoreThread2 implements Runnable {

    int a=45;
    @Override
    public void run() {
        for (int i = 0; i <15 ; i++) {
            a += 1;
            System.out.println(a);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
