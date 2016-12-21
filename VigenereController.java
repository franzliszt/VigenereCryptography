/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenerecryptography;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author stianreistadrogeberg
 */
public class VigenereController {
    private final Cryptography c;
    private boolean encMode;
    
    @FXML public TextField inputString;
    @FXML public TextField encryptionKey;
    @FXML public Button encrypt;
    @FXML public Button mode;
    @FXML public Label outputResult;
    
    
    public VigenereController() {
        encMode = true;
        c = new Cryptography();
    }

    @FXML
    public void toggleMode() {
        encMode = !encMode;
        resetFields();
        
        if(encMode) {
            encrypt.setText("Encrypt");
            mode.setText("Encryption");
        } else {
            mode.setText("Decryption");
            encrypt.setText("Decrypt");
        }
    }
    
    private void resetFields() {
        inputString.setText("");
        encryptionKey.setText("");
    }
    
    @FXML
    public void encryptionMode() {
        String userInput = inputString.getText();
        boolean ok = checkInput(userInput);
        
        if(encMode && ok) {
            String cipherText = c.encrypt(userInput, getKey());
            outputResult.setText(cipherText);
        } 
        if(!encMode && ok) {
            String plaintext = c.decrypt(inputString.getText(), getKey());
            outputResult.setText(plaintext);
        }
    }
    
    private boolean checkInput(String input) {
        return input.matches("[a-zA-Z]+");
    }
    
    private String getKey() {
        return encryptionKey.getText();
    }
    
}
