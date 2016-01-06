/**
 * Created by wissy on 2015/12/16.
 */
public class tet {
    public static void main(String[] args) {
//        int a=4;
//        System.out.println((a >> 1 >>4| 10<<a));
        // Using break as a civilized form of goto.
        boolean t = true;
        first:
        {
            second:
            {
                third:
                {
                    System.out.println("Before the break.");
                    if (t) break second; // break out of second block
                    System.out.println("This won't execute");
                }
                System.out.println("This won'texecute");
            }
            System.out.println("This is after secondblock.");
        }
    }
}
