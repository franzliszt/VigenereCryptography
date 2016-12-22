/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenerecryptography;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author stianreistadrogeberg
 */
public class VigenereCryptography extends Application {
    private final double height = 500.0;
    private final double width = 600.0;
   
    @Override
    public void start(Stage stage) throws IOException {
        GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("VigenereView.fxml"));
        
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource("vigenereStyle.css").toExternalForm());
        
        stage.setTitle("Vigenere Cryptography");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
    }      
    
    public static void main(String[] args) {
        launch(args);
    }
}
