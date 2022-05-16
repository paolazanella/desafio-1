/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import dao.FuncionarioDAO;
import java.util.Iterator;

/**
 *
 * @author Paola Zanella
 */
public class FuncionarioV {

    public static void imprime(FuncionarioDAO funcionarioDAO) {
        for (model.Funcionario f : funcionarioDAO.getFuncionarios()) {
            System.out.println("Funcionario: " + f.getNome());

        }
    }
}
