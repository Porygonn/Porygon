package br.com.porygon.dao;

import java.sql.*;

public class ConfiguracaoDAO {
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

    // Add your methods to interact with the database here

    public String recuperarAtributos(String nome){
        Connection con = null;
        try {
            con = getConnection();
            String select_sql = "select * from atr_configuracao where nome = (?)";
            PreparedStatement pst;
            pst = con.prepareStatement(select_sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            String valor = null;
            while(rs.next()) {
                valor = rs.getString("valor");
            }
            return valor;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao resgatar atributo!", e);
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

    public void adicionarAtributo(String nome, double valor){
        Connection con = null;
        try {
            con = getConnection();
            String insert_sql = "insert into atr_configuracao (nome, valor) values (?, ?) on duplicate key update valor = values(valor)";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            pst.setString(1, nome);
            pst.setObject(2, valor);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir novo atributo!", e);
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