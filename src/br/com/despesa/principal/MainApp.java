package br.com.despesa.principal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Carrega a tela de login como primeira tela
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/despesa/view/TelaLoginCadastro.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Login do Sistema de Despesas");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}