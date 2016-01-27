package br.ufjf.dcc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtualizaRegistro {

    public static void main(String[] args) {
        try {
            String urldriver = "jdbc:derby://localhost:1527/lp3-exm";
            Connection conexao = DriverManager.getConnection(urldriver, "fulano", "senha");
            Scanner entrada = new Scanner(System.in);
            System.out.println("Digite o nome do produto: ");
            String nome = entrada.nextLine();
            System.out.println("Digite uma quantidade a alterar: ");
            Integer qtd = entrada.nextInt();
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate("UPDATE produto SET qtd = qtd + "
                    + qtd
                    +" WHERE nome = '"
                    + nome
                    + "' ");
            System.out.println("Operação bem sucedida!");
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(AtualizaRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
