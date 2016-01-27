package br.ufjf.dcc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultaRegistros {

    public static void main(String[] args) {
        try {
            String urldriver = "jdbc:derby://localhost:1527/lp3-exm";
            Connection conexao = DriverManager.getConnection(urldriver, "fulano", "senha");
            
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT nome, qtd FROM produto WHERE qtd BETWEEN 10 AND 20");
            while(resultado.next()){
                System.out.print(resultado.getString("nome")+": ");
                System.out.println(resultado.getInt("qtd"));
            }
            
            System.out.println("Operação bem sucedida!");
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaRegistros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
