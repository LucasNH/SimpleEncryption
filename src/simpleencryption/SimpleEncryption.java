/*
 * Author: Lucas Noritomi-Hartwig
 * Date created: February 21, 2020
 * Date last edited: February 21, 2020
 * Program title: SimpleEncryption.java
 * This program will encrypt a plain text message using the simple encryption
 * algorithm to create the cipher text. The user must enter the rotation amount
 * that the algorithm moves the letters. This amount should be a value from 1 to 25.
 * This program is also able to decipher a cipher text phrase to its original plain text message.
 */
package simpleencryption;

import javax.swing.JOptionPane;

public class SimpleEncryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Prompting user for input string
        String input = JOptionPane.showInputDialog("This program will encrypt or"
                + " decrypt a phrase using the\nsimple encryption method of"
                + " rotating the letters.\n\nPlease enter a phrase");

        // Prompting user for rotation input
        String strRotation = JOptionPane.showInputDialog("Enter the rotation"
                + " amount(1 - 25)");
        int rotation = Integer.parseInt(strRotation);

        // Catching invalid rotation input
        if (!(rotation >= 1 && rotation <= 25)) {
            JOptionPane.showMessageDialog(null, "Please enter a valid rotation");
            System.exit(0);
        }

        // Prompting user for either encryption or decryption operation
        String strOperation = JOptionPane.showInputDialog("1 - Encryption\n2 -"
                + " Decryption");
        int operation = Integer.parseInt(strOperation);

        // Converting input to uppercase
        input = input.toUpperCase();

        // Output
        String output = "";
        switch (operation) {
            case 1: // Output encryption operation
                for (int i = 0; i < input.length(); i++) {
                    int character = (int) input.charAt(i);
                    if (character + rotation > 90) { // Allowing shifts past Z to return to A
                        character = character + rotation - 26;
                    } else if (character != 32) { // Checking for spaces
                        character = character + rotation;
                    }
                    output = output + Character.toString((char) character);
                }   
                System.out.println("The original phrase is: " + input);
                System.out.println("The encrypted phrase is: " + output);
                break;
            case 2: // Output decryption operation
                for (int i = 0; i < input.length(); i++) {
                    int character = (int) input.charAt(i);
                    if (character - rotation < 65 && character != 32) { // Allowing shifts past A to return to Z 
                        character = character - rotation + 26;
                    } else if (character != 32) { // Checking for spaces
                        character = character - rotation;
                    }
                    output = output + Character.toString((char) character);
                }   
                System.out.println("The encrypted phrase is: " + input);
                System.out.println("The original phrase is: " + output);
                break;
            default: // Catching invalid operation input
                JOptionPane.showMessageDialog(null, "Please enter a valid operation");
                System.exit(0);
        }

    }

}
