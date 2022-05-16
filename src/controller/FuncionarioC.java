/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import conexao.ConectaBD;
import dao.FuncionarioDAO;

import java.sql.*;

import static view.FuncionarioV.imprime;

/**
 *
 * @author Paola Zanella
 */
public class FuncionarioC {

    public static void iniciar() throws SQLException {
        Connection connection = ConectaBD.createConnectionMySQL();
        if (connection != null) {
            System.out.println("Conexão realizada com sucesso");
            connection.close();
        }

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        imprime(funcionarioDAO);
    }
}
