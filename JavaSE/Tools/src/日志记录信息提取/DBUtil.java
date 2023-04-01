package 日志记录信息提取;

import java.sql.*;

public class DBUtil {
    String url;
    String user;
    String pwd;


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
