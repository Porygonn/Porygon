package br.com.porygon.dao;

import java.sql.*;

public class CidadeDAO {
    private final String url = "jdbc:mysql://localhost:3306/porygon?useTimezone=true&serverTimezone=UTC";
    private final String username = "porygon";
    private final String password = "pesquisador";

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Connection to database failed: " + e.getMessage());
        }
        return connection;
    }

    //     Realiza a inserção dos dados lidos no banco
    public void salvarCidade(String sigla, String cidade) {
        Connection con = null;
        int generatedId = -1;

        try {
            con = getConnection();
            String insert_sql = "INSERT INTO cidade (sigla, nome) VALUES (?, ?) on duplicate key update nome = VALUES(nome)";
            PreparedStatement pst = con.prepareStatement(insert_sql);
            pst.setString(1, sigla);
            pst.setString(2, cidade);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir nova cidade!", e);
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar conexão", e);
            }
        }
    }
}