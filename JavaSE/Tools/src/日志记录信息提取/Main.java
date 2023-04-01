package 日志记录信息提取;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> sourceList = new ArrayList<String>();
        File file = new File("D:\\WorkSpace\\Java\\IDEA\\IDEAProjects\\JavaSE\\Tools\\access2.log");
        String encoding = "utf-8";
        String line = null;
        String equip = null;
        String time = null;
        try//-----------------------------------------------------------对于文件中的数据(每条数据为一行)以字符串的形式存在List中
        {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, encoding);
            BufferedReader br = new BufferedReader(isr);

            //创建一个String类型的Set集合，进行放入，因为Set集合无法放入重复数据，所以set.size()的数值就是不重复的ip
            List<String> ipset = new ArrayList<>();
            List<String> equipset = new ArrayList<>();
            List<String> timeset = new ArrayList<>();

            List<String> iplist = new ArrayList<>();


            int i = 0;
            while(  (line=(br.readLine()))!=null)
            {
                String equipline = line;
                String timeline = line;
                //对读出的每一行进行按照特定符号分割,截取每一行的ip
                String ip = line.substring(0,line.indexOf(" -"));

                //对读出的每一行进行按照特定符号分割,截取每一行的访问设备
                if(equipline.indexOf("(") != -1 && equipline.indexOf(")") != -1 && equipline.indexOf("(") < equipline.indexOf(")")) {
                    equip = equipline.substring(equipline.indexOf("(") + 1, equipline.indexOf(")"));
                }else{
                    equip = "no";
                }

                //对读出的每一行进行按照特定符号分割,截取每一行的访问时间
                if(timeline.indexOf("[") != -1 && timeline.indexOf("]") != -1 ) {
                    time = timeline.substring(timeline.indexOf("[") + 1, timeline.indexOf("]"));
                }else {
                    time = "no";
                }

                //将ip放入set集合
                //ipset.add(ip);

                //将equip放入set集合
                //equipset.add(equip);

                //将time放入set集合
                //timeset.add(time);

                //写入数据库
                insertDate(ip,time,equip);


                //将ip放入list集合统计总共多少ip
                //iplist.add(ip);
                //sourceList.add(line);
            }
            //遍历所有的ip
            /*Iterator it = ipset.iterator();
            while (it.hasNext()){
                System.out.println(it.next());
            }*/

            //遍历所有的equip
            /*Iterator it2 = equipset.iterator();
            while (it2.hasNext()){
                System.out.println(it2.next());
            }*/

            //遍历所有的time
            /*Iterator it3 = timeset.iterator();
            while (it3.hasNext()){
                System.out.println(it3.next());
            }*/

            //获取set集合中的ip数量
            //System.out.println(ipset.size()); //10696
            //获取list集合中的ip数量(应该远大于set集合中的)
            //System.out.println(iplist.size());//287594
            br.close();
            isr.close();
            fis.close();
        }
        catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }




    }
    public static void insertDate(String ip,String equip,String time){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lucas","root","521477");
            String sql = "insert into user values(?,?,?)";
            ps = con.prepareStatement(sql);

            ps.setString(1,ip);
            ps.setString(2,time);
            ps.setString(3,equip);
            ps.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}