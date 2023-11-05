package uz.learn.crypto.cipher.substitution;

import java.util.Scanner;

public class VigenereCipher {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 'e' to encrypt 'd' to decrypt:");
		String encDec = input.next();
		System.out.println("Enter key:");
		String key = input.next().toUpperCase();
		System.out.println("Enter text");
		String text = input.next().toUpperCase();
		input.close();
		StringBuilder sb = new StringBuilder();
		boolean isEnc = encDec.startsWith("E") || encDec.startsWith("e");
		for (int i = 0; i < text.length();) {
			for (int j = 0; j < key.length() && i < text.length(); j++, i++) {
				int alphOrder = text.charAt(i) - 'A';
				int keyAlpOrder = key.charAt(j) - 'A';
				if (isEnc) {
					sb.append(Character.toString('A' + (alphOrder + keyAlpOrder) % 26));
				} else {
					sb.append(Character.toString('A' + (26 + alphOrder - keyAlpOrder) % 26));
				}
			}
		}
		if (isEnc) {
			System.out.println("Encrypted text = " + sb.toString());
		} else {
			System.out.println("Decrypted text = " + sb.toString());
			
		}
	}
}
