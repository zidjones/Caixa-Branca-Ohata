```
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User { // n1
    public Connection conectarBD(){ //n1
        Connection conn = null; //n2 
        try{ //n3
            Class.forName("com.mysql.Driver.Manager").newInstance(); //n3
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123"; //n3
            conn = DriverManager.getConnection(url); //n3
        }catch (Exception e) { } //n4
        return conn; //n5
    }

    public String nome="";
    public boolean result = false;

    public boolean verificarUsuario(String login, String senha){ //n6
        String sql = ""; //n7
        Connection conn = conectarBD(); //n8
        //INSTRUÇÃO SQL
        sql += "select nome from usuarios "; //n9
        sql += "where login = " + "'" + login + "'"; //n9
        sql += " and senha = " + "'" + senha + "'"; //n9
        try{ //n10
            Statement st = conn.createStatement(); //n10
            ResultSet rs = st.executeQuery(sql); //n10
            if(rs.next()){ //n11
                result = true; // n11
                nome = rs.getString("nome"); //n 11
            }
        }catch (Exception e) { } //n12
        return result; //n13
    }
}
//fim da class
```
