package Statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {
        Contato contato = new Contato("Matheus Hohmann", "math@gmail.com", "999999999", 18);

        String sql = "insert into contatos (nome, email, telefone, idade) values " +
                "('" + contato.getNome() + "', '" + contato.getEmail() + "', '" + contato.getIdade() +
                "', '" + contato.getIdade() + "')"; // inserir dados no mysql

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectaBD();

        Statement statement = connection.createStatement();
        statement.execute(sql);

        connection.close();
    }
}
