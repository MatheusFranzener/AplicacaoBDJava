package Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaSelect {
    public static void main(String[] args) throws SQLException {
        select("2");
    }

    public static Contato select(Object id) throws SQLException {
        String sql = "select * from contatos where id = " + id;

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectaBD();


        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        Contato contato;

        if (resultSet != null) {
            if (resultSet.next()) {
                contato = new Contato(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("email"),
                        resultSet.getString("telefone"),
                        resultSet.getInt("idade")
                );
                System.out.println("contato:" + contato);
                return contato;
            }
        }
        connection.close();
        throw new RuntimeException("Deu ruim!");
    }
}
