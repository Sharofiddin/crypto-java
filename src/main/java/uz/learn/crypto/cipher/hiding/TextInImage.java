package uz.learn.crypto.cipher.hiding;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class TextInImage {

	public static void main(String[] args) throws Exception {
		InputStream initialImage = TextInImage.class.getResourceAsStream("/lena.bmp");
		BufferedImage img = ImageIO.read(initialImage);
		int height = img.getHeight();
		int width = img.getWidth();
		Scanner sc = new Scanner(System.in);
//		String encDec = sc.next();
		String text = sc.next();
		sc.close();
		BufferedImage resImage = new BufferedImage(width, height,BufferedImage.TYPE_INT_BGR);
		int pos = 0;
		for (int h = 1; h < height; h++) {
			for (int w = 1; w < width; w++) {
				int rgb = img.getRGB(w, h);
				int red = (rgb >> 16) & 0x000000FF;
				int green = (rgb >> 8) & 0x000000FF;
				int blue = (rgb) & 0x000000FF;
//				if (pos < text.length()) {
//					char letter = text.charAt(pos++);
//					blue = (blue + letter) % 256;
//				}
				int resValue = -16777216;
                resValue += (blue & 0xff);
				resValue +=  ((green & 0xff) << 8);
				resValue += ((red & 0xff) << 16);
				resImage.setRGB(w, h, resValue);
			}
		}
		
		File out = new File("./encrypted.bmp");
		out.createNewFile();
		ImageIO.write(resImage, "bmp", out);
	}
}
