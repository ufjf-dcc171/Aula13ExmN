package br.ufjf.dcc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApagaRegistros {

    public static void main(String[] args) {
        try {
            String urldriver = "jdbc:derby://localhost:1527/lp3-exm";
            Connection conexao = DriverManager.getConnection(urldriver, "fulano", "senha");
            
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate("DELETE FROM produto WHERE qtd < 10");
            System.out.println(operacao.getUpdateCount()+" registros excluídos!");
            System.out.println("Operação bem sucedida!");
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ApagaRegistros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
