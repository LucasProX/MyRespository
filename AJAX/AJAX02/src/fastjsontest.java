import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class fastjsontest {
    public static void main(String[] args) {
        Student student = new Student("zs",01,99);
        Student student2 = new Student("ls",02,60);
        Student student3 = new Student("ww",03,0);
        List<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student2);
        list.add(student3);
        String jsonstr = JSON.toJSONString(list);
        System.out.println(jsonstr);
    }
}
