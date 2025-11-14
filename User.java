import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {  // mantém o nome da classe como User

    // configurações de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/test";  // url de conexão
    private static final String USUARIO = "root";  // nome do usuário no banco
    private static final String SENHA = "12345678";  // senha do banco de dados

    // método responsável por estabelecer a conexão com o banco de dados
    public Connection conectarBD() throws Exception {
        try {
            // carrega o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // cria e retorna a conexão com o banco
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception e) {
            // se ocorrer erro ao conectar, lança uma exceção
            throw new Exception("Erro ao tentar estabelecer conexão com o banco de dados", e);
        }
    }

    // método para verificar se as credenciais do usuário estão corretas
    public boolean verificarUsuario(String login, String senha) {
        String query = "SELECT nome FROM usuarios WHERE login = ? AND senha = ?";  // consulta SQL com placeholders
        boolean usuarioValido = false;  // flag para verificar se o usuário foi encontrado

        try (Connection conexao = conectarBD(); PreparedStatement ps = conexao.prepareStatement(query)) {
            // define os parâmetros da consulta
            ps.setString(1, login);
            ps.setString(2, senha);

            // executa a consulta e armazena o resultado
            ResultSet rs = ps.executeQuery();

            // verifica se o usuário foi encontrado no banco
            if (rs.next()) {
                String nomeUsuario = rs.getString("nome");
                System.out.println("usuário autenticado: " + nomeUsuario);  // exibe o nome do usuário
                usuarioValido = true;  // marca como usuário válido
            } else {
                System.out.println("usuário ou senha inválidos.");  // se o usuário não for encontrado
            }
        } catch (Exception e) {
            // caso ocorra erro durante a execução, imprime a mensagem de erro
            System.out.println("erro ao verificar usuário: " + e.getMessage());
        }

        // retorna se o usuário foi autenticado
        return usuarioValido;
    }
}
