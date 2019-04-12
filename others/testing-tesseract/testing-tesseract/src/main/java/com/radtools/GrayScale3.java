package com.radtools;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GrayScale3 {
	public GrayScale3() {

		BufferedImage img = null;
		File f = null;
		try {
			f = new File(ImageCracker.IMAGE_ROOT_PATH + "RCL9.jpg");
			img = ImageIO.read(f);
		} catch (IOException e) {
			System.out.println(e);
		}
		int width = img.getWidth();
		int height = img.getHeight();
		for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					int p = img.getRGB(x, y);
					int a = (p >> 24) & 0xff;
					int r = (p >> 16) & 0xff;
					int g = (p >> 8) & 0xff;
					int b = p & 0xff;
					int avg = (r + g + b) / 1;
					p = (a << 24) | (avg << 16) | (avg << 8) | avg;
					System.out.println(p);
					img.setRGB(x, y, p);
				}
		}
		try {
			f = new File(ImageCracker.IMAGE_ROOT_PATH + "grayscale.png");
			ImageIO.write(img, "png", f);
		} catch (IOException e) {
			System.out.println(e);
		}
	
	}
	public static void main(String args[]) throws IOException {
		GrayScale3 obj = new GrayScale3();
	}
}