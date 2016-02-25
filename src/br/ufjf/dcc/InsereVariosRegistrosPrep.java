package br.ufjf.dcc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsereVariosRegistrosPrep {

    public static void main(String[] args) {
        try {
            String urldriver = "jdbc:derby://localhost:1527/lp3-exm";
            Connection conexao = DriverManager.getConnection(urldriver, "fulano", "senha");
            Random rnd = new Random();
            String nome;
            Integer qtd;
            PreparedStatement operacao = conexao.prepareStatement("INSERT INTO produto(nome, qtd) VALUES(?,?)");
            Date antes = new Date();
            
            for (int i = 0; i < 2000; i++) {

                nome = "Produto " + (rnd.nextInt(1000) + 1);
                qtd = rnd.nextInt(100);
                operacao.setString(1, nome);
                operacao.setInt(2, qtd);
                operacao.executeUpdate();
            }
            
            Date depois = new Date();
            System.out.println("Operação bem sucedida! "+( depois.getTime()-antes.getTime())/1000.0+"s");
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(InsereVariosRegistrosPrep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
