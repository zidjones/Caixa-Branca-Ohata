# Caixa-Branca-Ohata
package login; /*N1*/

import java.sql.Connection; /*N1*/
import java.sql.DriverManager; /*N1*/
import java.sql.ResultSet; /*N1*/
import java.sql.Statement; /*N1*/

public class User { /*N2*/
    
    public Connection conectarBD() { /*N3*/
        Connection conn = null; /*N4*/
        try { /*N5*/
            Class.forName("com.mysql.Driver.Manager").newInstance(); /*N5*/
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123"; /*N5*/
            conn = DriverManager.getConnection(url); /*N5*/
        } catch (Exception e) { } /*N6*/
        return conn; /*N7*/
    } /*N7*/

    public String nome = ""; /*N8*/
    public boolean result = false; /*N9*/

    public boolean verificarUsuario(String login, String senha) { /*N10*/
        String sql = ""; /*N11*/
        Connection conn = conectarBD(); /*N12*/
        
        sql = "select nome from usuarios "; /*N13*/
        sql += "where login = '" + login + "'"; /*N13*/
        sql += " and senha = '" + senha + "'"; /*N13*/
        
        try { /*N14*/
            Statement st = conn.createStatement(); /*N15*/
            ResultSet rs = st.executeQuery(sql); /*N15*/
            
            if (rs.next()) { /*N16*/
                result = true; /*N17*/
                nome = rs.getString("nome"); /*N17*/
            } else { /*N18*/
                result = false; /*N19*/
            }
        } catch (Exception e) { } /*N20*/
        
        return result; /*N21*/
    } /*N21*/
} /*N22*/
