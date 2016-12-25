/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenerecryptography;

/**
 *
 * @author Stian Reistad Røgeberg
 */
public class Cryptography {
    private char[] alphabet;
    private char[][] vigenere;
    
    public Cryptography() {
        initAlphabet();
        initMatrix();
    }
    
    private void initAlphabet() {
        char a = 'A';
        int temp = 26 + (int) a;
        alphabet = new char[26];
        int next = 0;
        
        while (a < temp) {
            alphabet[next++] = (char) a++;
        }
    }
    
    private void initMatrix() {
        int length = alphabet.length;
        vigenere = new char[length][length];
        vigenere[0] = alphabet;
        
        for (int i = 1; i < alphabet.length; i++) {
            char firstChar = vigenere[i - 1][0];
            
            // Move all one position
            for (int j = 0; j < alphabet.length - 1; j++) {
                vigenere[i][j] = vigenere[i - 1][j + 1];
            }
            // Insert the first character on the last position
            vigenere[i][vigenere.length - 1] = firstChar;
        }
    }
    
    public String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();
        
        // Counter for key index.
        int ctr = 0;
        
        for (int i = 0; i < plaintext.length(); i++) {
            char temp = plaintext.charAt(i);
            
            // Searching the first row to find plaintext position.
            for (int col = 0; col < vigenere.length; col++) {
                // Found position for plaintext character.
                if (temp == vigenere[0][col]) {
                    char tempK = key.charAt(ctr++);
                    // Searching rows for key character.
                    for (char[] row : vigenere) {
                        // Found key character row.
                        if (tempK == row[0]) {
                            ciphertext.append(row[col]);
                            // Reset key counter.
                            if (ctr > key.length() - 1)
                                ctr = 0;
                            break;
                        }
                    }
                }
            }
        }
        return ciphertext.toString();
    }
    
    public String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();
        
        // Counter for key index.
        int ctr = 0;
        
        for (int i = 0; i < ciphertext.length(); i++) {
            char tempK = key.charAt(ctr++);
            char temp = ciphertext.charAt(i);
            
            // Search row for key.
            for (char[] row : vigenere) {
                // Found key character.
                if (row[0] == tempK) {
                    for (int col = 0; col < vigenere.length; col++) {
                        // Found encrypted character posistion.
                        if (row[col] == temp) {
                            plaintext.append(vigenere[0][col]);
                            // Reset key counter
                            if(ctr > key.length() - 1)
                                ctr = 0;
                            break;
                        }
                    }
                }
            }
        }
        return plaintext.toString();
    }
}
