public class ThreadTest {
    public static void main(String[] args) {
        Thread th = new Thread(new Cat());
        Thread th2 = new Thread(new Dog());
        th.setName("01");
        th2.setName("02");
        th.start();
        th2.start();
    }
}
class Dog implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println(i + "Dog");
        }
    }
}
class Cat implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println(i + "Cat");
        }
    }
}