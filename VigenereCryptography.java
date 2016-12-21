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
//    private static char[] a;
//    private static char[][] vigenere;
    private final double height = 500.0;
    private final double width = 600.0;
   
    @Override
    public void start(Stage stage) throws IOException {
        GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("VigenereView.fxml"));
        
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource("vigenereStyle.css").toExternalForm());
        
        stage.setTitle("Vigenere Cryptography");
        stage.setScene(scene);
        stage.show();
        
    }        
    public static void main(String[] args) {        
        launch(args);
    }
    
//    private static void initVigenere() {
//        a = "abcdefghijklmnopqrstuvwxyz".toCharArray();
//        vigenere = new char[a.length][a.length];
//        vigenere[0] = a;
//        
//        for(int i = 1; i < a.length; i++) {
//            char firstChar = vigenere[i - 1][0];
//            
//            // Move all one position
//            for(int j = 0; j < a.length - 1; j++) {
//                vigenere[i][j] = vigenere[i - 1][j + 1];
//            }
//            // Insert the first character on the last position
//            vigenere[i][vigenere.length - 1] = firstChar;
//        }
//    }
    
//    private static String encrypt(String plaintext, String key) {
//        String ciphertext = ""; // avmax
//        int ctr = 0;
//        for(int i = 0; i < plaintext.length(); i++) {
//            char temp = plaintext.charAt(i);
//            
//            // position for the encrypted character
//            int position = 0;
//            
//            for(int j = 0; j < vigenere.length; j++) {
//                if(temp == vigenere[0][j]) {
//                    position = j;
//                    break;
//                }
//            }
//            
//            // search the key-row
//            for (char[] vigenere1 : vigenere) {
//                char tempk = key.charAt(ctr);
//                if (tempk == vigenere1[0]) {
//                    ciphertext += vigenere1[position];
//                    ctr++;
//                    if(ctr > 2)
//                        ctr = 0;
//                    break;
//                }
//            }
//        }
//        return ciphertext;
//    }
}
