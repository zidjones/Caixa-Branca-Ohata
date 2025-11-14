public class Main {

    public static void main(String[] args) {
        // cria uma instância da classe User
        User usuario = new User();

        // tenta autenticar com login e senha fornecidos
        boolean resultado = usuario.verificarUsuario("root", "12345678");

        // exibe a mensagem final dependendo do resultado da autenticação
        if (resultado) {
            System.out.println("login realizado com sucesso.");
        } else {
            System.out.println("falha no login.");
        }
    }
}
