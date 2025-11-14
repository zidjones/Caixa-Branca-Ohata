```
EXCEL COM PLANO DE TESTE ANEXADO
CAMINHO: https://github.com/zidjones/Caixa-Branca-Ohata/blob/main/PLANO_DE_TESTE_CAIXA_BRANCA.xlsx

FLUXOGRAMA DE CAIXA BRANCA ANEXADO
CAMINHO: https://github.com/zidjones/Caixa-Branca-Ohata/blob/main/FLUXOGRAMA_CAIXA_BRANCA.pdf
CÓDIGO COMENTADO COM OS NÓS
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



COMPLEXIDADE CICLOMÁTICA COM CALCULOS

M = E - N + 2P

M=E−N+2P

M=17−16+2(1)M = 13 - 13 + 2(1)

M=17−16+2(1)

M=1+2M = 3

M=3

A complexidade ciclomática calculada é 3, o que significa que existem três caminhos independentes no código:

Um caminho onde a conexão (connection) dá errado e condição if (rs.next()) é errada.
1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 10 → 11 → 12 → 15 → 16
Um caminho onde a conexão (connection) dá certo e condição if (rs.next()) é correta.
1 → 2 → 3 → 4 → 6 → 7 → 8 → 9 → 10 → 11 → 12 → 13 → 14 → 16
Um caminho onde a conexão (connection) dá certo e condição if (rs.next()) é errada.
1 → 2 → 3 → 4 → 6 → 7 → 8 → 9 → 10 → 11 → 12 → 15 → 16
CAMINHOS INDEPENDENTES

Método conectarBD()

Caminho 1: (1 → 2 → 3 → 4 → 6).
Caminho 2: (1 → 2 → 3 → 4 → 5 → 6).

Método verificarUsuario():

Caminho 1: nesse caminho o conectarBD() é chamado e a execução da SQL é bem-sucedida com rs.next() true (7 → 8 → 9 → 10 → 11 → 12 → 13 → 14 → 16).

Caminho 2: nesse caminho o rs.next() é false (7 → 8 → 9 → 10 → 11 → 12 → 15 → 16).

Caminho 3: nesse caminho ocorre uma exceção durante a execução do try (8 → 9 → 10 → 11 → 15 → 16).

Caminho 4: aqui é execução com falha na conexão (7 → 8 com conn nulo levando a retorno imediato).

no método verificarUsuario() é 4 a complexidade ciclomática, indicando que existem 4 caminhos independentes que precisam ser testados.

no método conectarBD() é 2 a complexidade ciclomática, indicando 2 caminhos principais.

```
