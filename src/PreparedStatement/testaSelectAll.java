package PreparedStatement;

import PreparedStatement.Conexao;
import PreparedStatement.Contato;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testaSelectAll {
    public static void main(String[] args) throws SQLException {
        String sql = "select * from contatos";

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectaBD();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet != null && resultSet.next()) {
            Contato contato = new Contato(
                    resultSet.getInt("id"),
                    resultSet.getString("nome"),
                    resultSet.getString("email"),
                    resultSet.getString("telefone"),
                    resultSet.getInt("idade")
            );
            System.out.println("contato:" + contato);
        }
        connection.close();
    }
}
