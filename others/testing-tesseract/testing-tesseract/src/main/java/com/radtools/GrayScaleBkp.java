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
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.GrayFilter;

public class GrayScaleBkp {
	public static String fileName = "RCL4.jpg";
	public static String INPUT_IMAGE_PATH = ImageCracker.IMAGE_ROOT_PATH + fileName;

	BufferedImage image;
	int width;
	int height;
	static List<String> ipImageFileNames = new ArrayList<>();
	List<String> opImageFileNames = new ArrayList<>();
	String outputFileName = "grayscale-%s.png";
	int counterRed = 0, counterGreen = 0, counterBlue = 0;
	public GrayScaleBkp() {
	}

	public static BufferedImage desaturate(BufferedImage source) {
		ImageFilter filter = new GrayFilter(true, 80);
		ImageProducer producer = new FilteredImageSource(source.getSource(), filter);
		Image grayImg = Toolkit.getDefaultToolkit().createImage(producer);

		BufferedImage image = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_ARGB);
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
//		System.out.println("r:" + r + " g:" + r + " b:" + b);
		// y = (int) ((0.29f *255) + (0.57f * 255) + (0.1f * 255));
		// y = (r+g+b)/5;

		// y = (int) (Math.round(1 * r + 1* g + 0.1* b));//GOOOD
		// y = (int) (Math.round(0.0000000001 * r + 0.9* g + 0.08* b));

		// y = (int) ((r * 0.00) + (g * 0.39) + (b * 1.5));
//		y = (int) ((r * 1) + (g * 1) + (b * 1.5)); //perfect
//		y = (int) ((r * 0.00) + (g * 0.1) + (b * 1)); // perfect
//		y = (int) ((r * 0.00) + (g * 0.1) + (b * 1)); // perfect
//		y = (int) ((r * 0.00) + (g * 0.39) + (b * 2)); // perfect
//		System.out.println(y);
		y = (int) ((r * 1) + (g * 1) + (b * 1));//demo1
//		y = (int) ((r * 1) + (g * 1) + (b * 1.5)); //demo2
//		y = (int) ((r * 0.00) + (g * 0.39) + (b * 1)); //demo3
//		y = (int) ((r * 0.7775) + (g * 1.09) + (b * 1.09));
		
		y = (int) ((r * 0.2) + (g * 0.39) + (b * 1.5)); //demo4
		
		if (y > 255) {
			y = 255;
		}
		return new Color(y, y, y);
	}

	static public void main(String args[]) throws Exception {
		GrayScaleBkp obj = new GrayScaleBkp();
		ipImageFileNames.add("RCL1.jpg");
//		ipImageFileNames.add("RCL8.jpg");
//		ipImageFileNames.add("RCL9.jpg");
//		ipImageFileNames.add("RCL4.jpg");
//		ipImageFileNames.add("RCL5.jpg");
//		ipImageFileNames.add("RCL6.jpg");
		obj.prepareGrayscale(GrayScaleBkp.ipImageFileNames);
		System.out.println("Completed");
	}
	
	public void prepareGrayscale(List<String> ipImageFileNames) {
		for (String fileName : ipImageFileNames) {
			File input = new File(ImageCracker.IMAGE_ROOT_PATH + fileName);
			prepareGrayscale(input);
		}
	}
	
	public void prepareGrayscale(Object inputObj){
		File ouptut = null;
		try {
			if (inputObj instanceof File) {
				image = ImageIO.read((File) inputObj);
			} else if (inputObj instanceof URL) {
				image = ImageIO.read((URL) inputObj);
			}
			ouptut = new File(ImageCracker.IMAGE_ROOT_PATH+"Original.png");
			ImageIO.write(image, "png", ouptut);
		} catch (IOException e) {
			System.out.println("Exception : " + e);
		}
		width = image.getWidth();
		height = image.getHeight();

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Color color = new Color(image.getRGB(j, i));
//				counterRed = counterRed + color.getRed();
//				counterGreen = counterGreen + color.getGreen();
//				counterBlue = counterBlue + color.getBlue();
				Color newColor = toGray(color);
				image.setRGB(j, i, newColor.getRGB());
			}
		}
//		System.out.println(counterRed + " :counterRed " + counterGreen + " :counterGreen " + counterBlue + ":counterBlue");
		ouptut = new File(ImageCracker.IMAGE_ROOT_PATH+"grayscale.png");
				//+ String.format(outputFileName, fileName.substring(0, fileName.indexOf('.'))));
		//opImageFileNames.add(String.format(outputFileName, fileName.substring(0, fileName.indexOf('.'))));
		try {
			ImageIO.write(image, "png", ouptut);
		} catch (IOException e) {
			System.out.println("Exception : " + e);
		}
	}
}