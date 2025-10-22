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

public class TelaCadastroController {

    @FXML
    private TextField CampoEmailCadastro;

    @FXML
    private TextField CampoNomeCadastrar;

    @FXML
    private PasswordField CampoSenhaCadastro;

    @FXML
    private Button botaoCadastrarCadastro;

    @FXML
    void cadastrarUsuario(ActionEvent event) throws IOException {
        String nome = CampoNomeCadastrar.getText();
        String email = CampoEmailCadastro.getText();
        String senha = CampoSenhaCadastro.getText();

        Usuario usuario = new Usuario(0, nome, email, senha);
        UsuarioDAO dao = new UsuarioDAO();

        boolean sucesso = dao.save(usuario);

        Alert alert = new Alert(sucesso ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
        alert.setTitle(sucesso ? "Sucesso" : "Erro");
        alert.setHeaderText(null);
        alert.setContentText(sucesso ? "Usuário cadastrado com sucesso!" : "Erro ao cadastrar usuário.");
        alert.showAndWait();

        if (sucesso) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/despesa/view/TelaLoginCadastro.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) botaoCadastrarCadastro.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Login do Sistema");
        }
    }
}