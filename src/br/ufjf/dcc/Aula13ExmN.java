package br.ufjf.dcc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Aula13ExmN {

    public static void main(String[] args) {
        try {
            String urldriver = "jdbc:derby://localhost:1527/lp3-exm";
            Connection conexao = DriverManager.getConnection(urldriver, "fulano", "senha");
            if(conexao.isValid(500)){
                System.out.println("Conectado corretamente!");
                System.out.println(conexao.getMetaData().getDatabaseProductName());
            }
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(Aula13ExmN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
