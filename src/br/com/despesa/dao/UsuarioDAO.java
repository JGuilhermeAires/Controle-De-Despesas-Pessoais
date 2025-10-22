package br.com.despesa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.despesa.factory.ConnectionFactory;
import br.com.despesa.model.Usuario;

public class UsuarioDAO {
    public boolean save(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?,?,?)";
        try (Connection conn = ConnectionFactory.createConnectionToSQLServer();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getSenha());

            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}