package com.radtools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.GrayFilter;

public class GrayScale {
	static String fileName = "RCL4.jpg";
	public static final String INPUT_IMAGE_PATH = ImageCracker.IMAGE_ROOT_PATH + fileName;

	BufferedImage image;
	int width;
	int height;

	public GrayScale() {

		try {
			File input = new File(INPUT_IMAGE_PATH);
			image = ImageIO.read(input);
			width = image.getWidth();
			height = image.getHeight();

			for (int i = 0; i < height; i++) {

				for (int j = 0; j < width; j++) {

					Color c = new Color(image.getRGB(j, i));
					// int red = (int)(c.getRed() * 0.299);
					// int green = (int)(c.getGreen() * 0.587);
					// int blue = (int)(c.getBlue() *0.114);
					// int red = (int) (c.getRed() * 0.1);
					// int green = (int) (c.getGreen() * 0.8);
					// int blue = (int) (c.getBlue() * 0.1);

					// int gray = red + green + blue;

//					int gray = (int) (c.getRed() * 0.1) + (int) (c.getGreen() * 0.587) + (int) (c.getBlue() * 0.114);
					// Eg1: Working with IMG_RCL_GREEN

					// gray = (int) (c.getRed() * 0) + (int) (c.getGreen() *
					// 0.39) + (int) (c.getBlue() * 0);
					// Eg2: Working with IMG_RCL_RED

					// System.out.println(red + " : " + green + " : " + blue);

//					Color newColor = toGray(c);

					// int gray = (0.2989 * red) + (0.5870 * green) + (0.1140 *
					// blue);
					// pixelColor = new Color(gray, gray, gray);
					
					Color newColor = toGray(c);
					
					image.setRGB(j, i, newColor.getRGB());
				}
			}

			File ouptut = new File(ImageCracker.IMAGE_ROOT_PATH + "grayscale.png");
			ImageIO.write(image, "png", ouptut);
//			image = ImageIO.read(input);
//			desaturate(image);
//			image = desaturate(image);
//			ImageIO.write(image, "png", ouptut);
			// ImageIO.write(image, fileName.substring(fileName.indexOf('.') +
			// 1, fileName.length()), ouptut);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static BufferedImage desaturate(BufferedImage source) {
		ImageFilter filter = new GrayFilter(true, 80);
		ImageProducer producer = new FilteredImageSource(source.getSource(), filter);
		Image grayImg = Toolkit.getDefaultToolkit().createImage(producer);

		BufferedImage image = new BufferedImage(source.getWidth(), source.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		Graphics g = image.getGraphics();
		g.drawImage(grayImg, 0, 0, null);
		g.dispose();
		return null;
	}

	private static Color toGray(Color color) {
		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();
		int y = (int) (Math.round(0.299 * r + 0.587 * g + 114 * b));
		System.out.println("r:" + r +" g:" + r +" b:" + b);
		//y = (int) ((0.29f *255) + (0.57f * 255) + (0.1f * 255));
		//y = (r+g+b)/5;
		
//		y = (int) (Math.round(1 * r + 1* g + 0.1* b));//GOOOD 
		//y = (int) (Math.round(0.0000000001 * r + 0.9* g + 0.08* b));
		
		//y = (int) ((r * 0.00) + (g * 0.39) + (b * 1.5));
		y = (int) ((r * 1) + (g * 1) + (b * 1.5));	//perfect
		y = (int) ((r * 0.00) + (g * 0.1) + (b * 1));	//perfect
		y = (int) ((r * 0.00) + (g * 0.1) + (b * 1));	//perfect
		y = (int) ((r * 0.00) + (g * 0.39) + (b * 2));	//perfect
		y = (int) ((r * 0.00) + (g * 0.39) + (b * 2));	//perfect
		System.out.println(y);
		if (y > 255) {
			y = 255;
		}
		return new Color(y, y, y);
	}

	static public void main(String args[]) throws Exception {
		GrayScale obj = new GrayScale();
		System.out.println("Completed");
	}
}