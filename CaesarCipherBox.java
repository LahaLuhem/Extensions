/**
 * Representation of a simple encryption and decryption algorithm, tht uses the Caesar Cipher Box concept
 * @author LahaLuhem
 * @version 1.0
 */
class CaesarCipherBox {
  
  public static String encrypt (String text, int shift) {
    String cipher = "";
    for (int index = 0; index < text.length(); index++) {
      int encrypted = (int)text.charAt (index);  
        if (encrypted != (int)' ') {          
            if (encrypted + shift >= 97) {
                if ( (encrypted >= 97) && (encrypted + shift <= 122) ) {
                  cipher += (char)(encrypted + shift);
                }
                else if ( (encrypted >= 97) && (encrypted + shift > 122) ) {
                  cipher += (char)(encrypted + shift-26);
                }
                else {
                  cipher += (char)(encrypted + shift-6-26);
                }
            }
            else if ( (encrypted + shift < 97) && (encrypted + shift > 90) ) {
              cipher += (char)(encrypted + shift-26);
            }
            else {
              cipher += (char)(encrypted + shift);
            }
        }
        else {
          cipher += ' ';
        }
    }
    return cipher;
  }
  
  public static String decrypt (String text, int shift) {
    String decipher = "";
    for (int index = 0; index < text.length(); index++) {
      int decrypted = (int)text.charAt (index);  
        if (decrypted != (int)' ') {          
            if (decrypted-shift <= 90) {
                if ( (decrypted <= 90) && (decrypted-shift >= 65) ) {
                  decipher += (char)(decrypted-shift);
                }
                else {                    
                  decipher += (char)(decrypted-shift + 26);
                }
            }
            else if (decrypted-shift < 97) {
              decipher += (char)(decrypted-shift + 26);
            }
            else {
              decipher += (char)(decrypted-shift);
            }
        }
        else {
          decipher += ' ';
        }
    }
    return decipher;
  }
}