import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaSelect {
    public static void main(String[] args) throws SQLException {
        int id = 2;
        String sql = "select * from contatos where id = " + id;

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectaBD();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet != null && resultSet.next()) {
            Contato contato = new Contato(
                    resultSet.getInt("id"),
                    resultSet.getString("nome"),
                    resultSet.getString("email"),
                    resultSet.getString("endereco"),
                    resultSet.getInt("idade")
            );
            System.out.println("contato:" + contato);
        }
        connection.close();
    }
}
