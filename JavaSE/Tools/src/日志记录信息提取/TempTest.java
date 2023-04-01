package 日志记录信息提取;

public class TempTest {
    public static void main(String[] args) {
        String s = "?12.4.31.43.43 -- fsfsdfdsf?[24.423.4.23.423.4] -- fasfsdf";
        System.out.println(s.substring(s.indexOf("?")+1,s.indexOf(" --")));
        if (s.indexOf(")") != -1 && s.indexOf("(") != -1) {
            System.out.printf(s.substring(s.indexOf(")") + 1, s.indexOf("(")));
        }else {
            System.out.println("meiyou");
        }
    }
}
