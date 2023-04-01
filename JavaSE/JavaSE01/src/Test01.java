public class Test01 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Game());
        t1.start();
    }
}
class Game implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 9999; i++) {
            System.out.println(i + "次循环");
        }
    }
}
