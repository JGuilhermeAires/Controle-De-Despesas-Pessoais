package br.com.despesa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
     public Usuario autenticar(String nome, String email, String senha) {
        String sql = "SELECT * FROM usuario WHERE nome = ? AND email = ? AND senha = ?";
        try (Connection conn = ConnectionFactory.createConnectionToSQLServer();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, nome);
            pstm.setString(2, email);
            pstm.setString(3, senha);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                // Usuário encontrado
                return new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; // Usuário não encontrado
    }
}