/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenerecryptography;

/**
 *
 * @author stianreistadrogeberg
 */
public class Cryptography {
    private char[] a;
    private char[][] vigenere;
    
    public Cryptography() {
        initVigenere();
    }
    
    private void initVigenere() {
        a = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        vigenere = new char[a.length][a.length];
        vigenere[0] = a;
        
        for(int i = 1; i < a.length; i++) {
            char firstChar = vigenere[i - 1][0];
            
            // Move all one position
            for(int j = 0; j < a.length - 1; j++) {
                vigenere[i][j] = vigenere[i - 1][j + 1];
            }
            // Insert the first character on the last position
            vigenere[i][vigenere.length - 1] = firstChar;
        }
    }
    
    public String encrypt(String plaintext, String key) {
        String ciphertext = "";
        int ctr = 0;
        for(int i = 0; i < plaintext.length(); i++) {
            char temp = plaintext.charAt(i);
            
            // position for the encrypted character
            int position = 0;
            
            for(int j = 0; j < vigenere.length; j++) {
                if(temp == vigenere[0][j]) {
                    position = j;
                    break;
                }
            }
            
            // search the key-row
            for (char[] row : vigenere) {
                char tempk = key.charAt(ctr);
                if (tempk == row[0]) {
                    ciphertext += row[position];
                    ctr++;
                    if(ctr > key.length() - 1)
                        ctr = 0;
                    break;
                }
            }
        }
        return ciphertext.toUpperCase();
    }
    
    public String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();
        
        int ctr = 0;
        
        for(int i = 0; i < ciphertext.length(); i++) {
            char tempK = key.charAt(ctr++);
            char temp = ciphertext.charAt(i);
            
            // sjekke i nøkkelraden
            for (char[] vigenere1 : vigenere) {
                if (vigenere1[0] == tempK) {
                    // fant nøkkelbokstav
                    // søke bortover i denne rader
                    for (int col = 0; col < vigenere.length; col++) {
                        if (vigenere1[col] == temp) {
                            plaintext.append(vigenere[0][col]);
                            //ctr++;
                            if(ctr > key.length() - 1)
                                ctr = 0;
                            break;
                        }
                    }
                }
            }
        }
        return plaintext.toString().toUpperCase();
    }
}
