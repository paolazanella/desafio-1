/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dasafio.pkg1;

import static controller.FuncionarioC.*;
import java.sql.SQLException;
import view.LoginV;

/**
 *
 * @author Paola Zanella
 */
public class Dasafio1 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        iniciar();
        LoginV loginV = new LoginV();
        loginV.setVisible(true);
    }
}
