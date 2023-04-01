import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {

    public static void main(String[] args) {
        FileInputStream fis = null;
        File file = new File("C:/Users/lucas/Desktop/998.txt");
        try {
            fis = new FileInputStream("C:/Users/lucas/Desktop/998.txt");
            byte[] bytes = new byte[20];
            int readCount = 0;
            while((readCount = fis.read(bytes)) != -1){
                System.out.print(new String(bytes,0,readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
