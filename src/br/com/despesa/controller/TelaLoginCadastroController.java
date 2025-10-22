package br.com.despesa.controller;

import java.io.IOException;

import br.com.despesa.dao.UsuarioDAO;
import br.com.despesa.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaLoginCadastroController {

    @FXML
    private Button botaoCadastro;

    @FXML
    private Button botaoEntrar;

    @FXML
    private TextField campoEmailUsuario;

    @FXML
    private TextField campoNomeUsuario;

    @FXML
    private PasswordField campoSenhaUsuario;

    @FXML
    void entrarNoSistema(ActionEvent event) throws IOException {
        String nome = campoNomeUsuario.getText();
        String email = campoEmailUsuario.getText();
        String senha = campoSenhaUsuario.getText();

        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.autenticar(nome, email, senha);

        if (usuario != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login bem-sucedido");
            alert.setHeaderText(null);
            alert.setContentText("Bem-vindo, " + usuario.getNome() + "!");
            alert.showAndWait();

            // Redirecionar para a tela principal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/despesa/view/TelaPrincipal.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) botaoEntrar.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Sistema de Despesas");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro de login");
            alert.setHeaderText(null);
            alert.setContentText("Nome, email ou senha incorretos!");
            alert.showAndWait();
        }
    }

    @FXML
    void irParaCadastro(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/despesa/view/TelaCadastro.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) botaoCadastro.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Cadastro de Usuário");
    }
}