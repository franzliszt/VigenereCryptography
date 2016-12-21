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
    private Cryptography c;
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
        
        if(encMode) {
            encrypt.setText("Encrypt");
            mode.setText("Encryption");
        } else {
            mode.setText("Decryption");
            encrypt.setText("Decrypt");
        }
    }
    
    @FXML
    public void encryptionMode() {
        if(encMode) {
            String cipherText = c.encrypt(inputString.getText(), getKey());
            outputResult.setText(cipherText);
        } else {
            String plaintext = c.decrypt(inputString.getText(), getKey());
            outputResult.setText(plaintext);
        }
    }
    
    private String getKey() {
        return encryptionKey.getText();
    }
    
}
