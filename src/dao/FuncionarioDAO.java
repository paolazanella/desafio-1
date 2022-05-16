/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import reserva.*;
import dao.*;
import com.mysql.cj.MessageBuilder;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Funcionario;

/**
 *
 * @author Paola Zanella
 */
//(Create, Retrieve, Update, Delete - ou - Criar, Consultar, Altverar, Deletar)//
public class FuncionarioDAO {
// para salvar//
    public void save(Funcionario funcionario) {
        String QUERY = "INSERT INTO funcionario ( nome, email, cpf, telefone, senha, ativo, admin)"
                + " VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getEmail());
            preparedStatement.setString(3, funcionario.getCpf());
            preparedStatement.setString(4, funcionario.getTelefone());
            preparedStatement.setString(5, funcionario.getSenha());
            preparedStatement.setInt(6, funcionario.getAtivo());
            preparedStatement.setInt(7, funcionario.getAdmin());

            preparedStatement.execute();
            System.out.println("Funcionario salvo com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public List<Funcionario> getFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        String QUERY;
        QUERY = "SELECT * FROM funcionario  WHERE ativo != 0 ";
        ///QUERY = "SELECT * FROM funcionario  WHERE ativo != 0 AND admin =1";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        @SuppressWarnings("UnusedAssignment")
        ResultSet resultSet;
        resultSet = null;

        try {
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(QUERY);

            resultSet = preparedStatement.executeQuery(QUERY);

            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setId(resultSet.getInt("id"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setEmail(resultSet.getString("email"));
                funcionario.setCpf(resultSet.getString("cpf"));
                funcionario.setTelefone(resultSet.getString("telefone"));
                funcionario.setSenha(resultSet.getString("senha"));
                funcionario.setAtivo(resultSet.getInt("ativo"));
                funcionario.setAdmin(resultSet.getInt("admin"));

                funcionarios.add(funcionario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return funcionarios;
    }

    public void update(Funcionario funcionario) {
        String QUERY = "UPDATE funcionario set nome = ?, email = ?, cpf = ?, telefone = ?, senha = ?, ativo = ?, admin = ? WHERE id = ?";
        // String QUERY = "UPDATE funcionario SET  ( nome, email, cpf, telefone, senha, ativo, admin)"
        //        + " VALUES ( ?, ?, ?, ?, ?, ?, ?) WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getEmail());
            preparedStatement.setString(3, funcionario.getCpf());
            preparedStatement.setString(4, funcionario.getTelefone());
            preparedStatement.setString(5, funcionario.getSenha());
            preparedStatement.setInt(6, funcionario.getAtivo());
            preparedStatement.setInt(7, funcionario.getAdmin());
            preparedStatement.setInt(8, funcionario.getId());

            preparedStatement.execute();
            System.out.println("Funcionario alterado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void delete(Funcionario funcionario) {
        String QUERY = "DELETE FROM funcionario WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        System.out.println(QUERY);
        try {
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, funcionario.getId());

            preparedStatement.execute();
            System.out.println(QUERY);
            System.out.println("Deletado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void adiciona(Funcionario funcionario) {

        String QUERY = "INSERT INTO funcionario ( nome, email, cpf, telefone, senha, ativo, admin)"
                + " VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getEmail());
            preparedStatement.setString(3, funcionario.getCpf());
            preparedStatement.setString(4, funcionario.getTelefone());
            preparedStatement.setString(5, funcionario.getSenha());
            preparedStatement.setInt(6, funcionario.getAtivo());
            preparedStatement.setInt(7, funcionario.getAdmin());

            preparedStatement.execute();
            System.out.println("Funcionario salvo com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    public ResultSet logar(Funcionario funcionario) {

        String QUERY = "select * from funcionario Where nome=? and senha =? and admin=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getSenha());
            preparedStatement.setInt(3, funcionario.getAdmin());

            ResultSet rs = preparedStatement.executeQuery();
            return rs;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "LoginDAO" + erro);
            return null;
        }

    }

}
