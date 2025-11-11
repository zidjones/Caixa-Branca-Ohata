# Caixa-Branca-Ohata
package login; /*1*/

import java.sql.Connection; /*1*/
import java.sql.DriverManager; /*1*/
import java.sql.ResultSet; /*1*/
import java.sql.Statement; /*1*/

public class User { /*2*/
    
    public Connection conectarBD() { /*3*/
        Connection conn = null; /*4*/
        try { /*5*/
            Class.forName("com.mysql.Driver.Manager").newInstance(); /*5*/
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123"; /*5*/
            conn = DriverManager.getConnection(url); /*5*/
        } catch (Exception e) { } /*6*/
        return conn; /*7*/
    } /*7*/

    public String nome = ""; /*8*/
    public boolean result = false; /*9*/

    public boolean verificarUsuario(String login, String senha) { /*10*/
        String sql = ""; /*11*/
        Connection conn = conectarBD(); /*12*/
        
        sql = "select nome from usuarios "; /*13*/
        sql += "where login = '" + login + "'"; /*13*/
        sql += " and senha = '" + senha + "'"; /*13*/
        
        try { /*14*/
            Statement st = conn.createStatement(); /*15*/
            ResultSet rs = st.executeQuery(sql); /*16*/
            
            if (rs.next()) { /*17*/
                result = true; /*18*/
                nome = rs.getString("nome"); /*18*/
            } else { /*19*/
                result = false; /*19*/
            }
        } catch (Exception e) { } /*20*/
        
        return result; /*21*/    
    } /*21*/    
} /*22*/
