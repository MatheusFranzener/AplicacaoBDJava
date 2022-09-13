package PreparedStatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaUpdate {
    public static void main(String[] args) throws SQLException {
        Contato contato = new Contato(2, "Leonardo", "leonardo@gmail.com", "999999999", 17);

        String sql = "update contatos set " +
                "nome = '" + contato.getNome() + "', " +
                "email = '" + contato.getEmail() + "', " +
                "telefone = '" + contato.getTelefone() + "', " +
                "idade = '" + contato.getIdade() + "' " +
                "where id = " + contato.getId();

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectaBD();

        Statement statement = connection.createStatement();
        statement.execute(sql);

        connection.close();
    }
}
