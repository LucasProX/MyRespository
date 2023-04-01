public class Test {
    public static void main(String[] args) {
        String s = "2020-02-22-10:33:34-259";
        String[] s1 = s.split("-");
        String[] s2 = s.split("-",2);
        for (int i = 0;i < s2.length;i ++){
            System.out.printf(s2[i]);
        }



    }
}
