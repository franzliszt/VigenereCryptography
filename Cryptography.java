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
            for (char[] vigenere1 : vigenere) {
                char tempk = key.charAt(ctr);
                if (tempk == vigenere1[0]) {
                    ciphertext += vigenere1[position];
                    ctr++;
                    if(ctr > 2)
                        ctr = 0;
                    break;
                }
            }
        }
        return ciphertext.toUpperCase();
    }
    
    public String decrypt(String ciphertext, String key) {
        return null;
    }
}
