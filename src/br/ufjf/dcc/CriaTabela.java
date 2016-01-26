package br.ufjf.dcc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CriaTabela {

    public static void main(String[] args) {
        try {
            String urldriver = "jdbc:derby://localhost:1527/lp3-exm";
            Connection conexao = DriverManager.getConnection(urldriver, "fulano", "senha");

            Statement operacao = conexao.createStatement();
            operacao.executeUpdate("CREATE TABLE produto("
                    + "nome VARCHAR(50), "
                    + "qtd INTEGER, "
                    + "atualizado TIMESTAMP"
                    + ")");
            
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(CriaTabela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
