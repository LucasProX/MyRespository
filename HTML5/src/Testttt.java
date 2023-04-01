import java.util.Scanner;

public class Testttt {
    public static void main(String[] args) {
        Thread thread = new Test1();
        thread.start();

    }
}
class Test1 extends Thread{
    @Override
    public void run() {
        System.out.printf("请输入一个人名进行系统检测:");
        Scanner s = new Scanner(System.in);

        if (s.next().equals("谭亚婷")){
            Runnable t2 = new Test2();
                t2.run();
            System.out.println("这是四川最笨的大学生");
        }
    }
}
class Test2 extends Thread{

    @Override
    public void run() {
        System.out.println("检测中.......");
    }
}
