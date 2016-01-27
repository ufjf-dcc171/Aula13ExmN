package br.ufjf.dcc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsereRegistro {

    public static void main(String[] args) {
        try {
            String urldriver = "jdbc:derby://localhost:1527/lp3-exm";
            Connection conexao = DriverManager.getConnection(urldriver, "fulano", "senha");
            Scanner entrada = new Scanner(System.in);
            System.out.println("Digite o nome do produto: ");
            String nome = entrada.nextLine();
            System.out.println("Digite uma quantidade: ");
            Integer qtd = entrada.nextInt();
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate("INSERT INTO produto(nome, qtd, atualizado) VALUES('"
                    + nome
                    + "',"
                    + qtd 
                    + ", CURRENT_TIMESTAMP)");
            System.out.println("Operação bem sucedida!");
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(InsereRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
