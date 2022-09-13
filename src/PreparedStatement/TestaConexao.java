package PreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {
        Contato contato = new Contato("Vytor", "augutso@gmail.com", "999999999", 18);

        String sql = "insert into contatos (nome, email, telefone, idade) values (?,?,?,?) ";

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectaBD();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, contato.getNome());
        statement.setString(2, contato.getEmail());
        statement.setString(3, contato.getTelefone());
        statement.setInt(4, contato.getIdade());

        statement.execute();
        connection.close();
    }
}
