package com.radtools;

import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * Hello world!
 *
 */
public class ImageCracker {
	public static String IMAGE_ROOT_PATH = "F:/warehouse/FMS-code-repo/FmsGgk-Org/newrepos3/FmsCarrierRcl/FmsCarrierRcl/src/main/java/com/radtools/";
	public static String OUTPUT_IMAGE_PATH = IMAGE_ROOT_PATH + "grayscale.png";

	public static void main1(String[] args) {
		System.out.println("GrayScale image is being created....");
		GrayScale obj = new GrayScale();
		//GrayScale3 obj = new GrayScale3();
		System.out.println("Created GrayScale image....");
		System.out.println("Using tessaract reading image contents as follows \n");
		List<String> imageFileNames = new ArrayList<>();
		
//		imageFileNames.add("W-IAL1.png");
//		imageFileNames.add("W-RCL1.png");
//		imageFileNames.add("W-RCL2.png");
//		imageFileNames.add("W-RCL3.png");
//		imageFileNames.add("W-EVL1.png");
//		imageFileNames.add("W-EVL2.png");
		imageFileNames.add("grayscale.png");
		for (String fileName : imageFileNames) {
			System.out.println("Image contents of "+fileName+" : " + ImageCracker.crackImage(IMAGE_ROOT_PATH + fileName));
		}
	}
	
	public static void main(String[] args) {
		System.out.println("GrayScale image is being created....");
		GrayScaleBkp obj = new GrayScaleBkp();
		for (String fileName : obj.opImageFileNames) {
			System.out.println("Image contents of " + fileName + " : " + ImageCracker.crackImage(IMAGE_ROOT_PATH + fileName));
		}
	}

	public static void main_app(Object inputObj) {
		//GrayScaleBkp.fileName = fileName;
		GrayScaleBkp ojb = new GrayScaleBkp();
//		try {
			ojb.prepareGrayscale(inputObj);
			ImageCracker.IMAGE_ROOT_PATH = "F:/warehouse/FMS-code-repo/FmsGgk-Org/newrepos3/FmsCarrierRcl/FmsCarrierRcl/src/main/java/com/radtools/";
			//ImageCracker.OUTPUT_IMAGE_PATH = ImageCracker.IMAGE_ROOT_PATH + "grayscale.png";
			System.out.println("Image contents of " + " : " + ImageCracker.crackImage(ImageCracker.OUTPUT_IMAGE_PATH));
//		} catch (MalformedURLException e) {
//			System.out.println(e);
//		}
	}
	
	public static String crackImage(String filePath) {
		File imageFile = new File(filePath);
		ITesseract instance = new Tesseract();
		try {
			instance.setDatapath(IMAGE_ROOT_PATH);
			instance.setLanguage("eng");

			String result = instance.doOCR(imageFile);
			return result;
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
			return "Error while reading image";
		}
	}
	
	public static void shootWebElement(WebElement element, WebDriver webDriver) throws IOException {
		File take = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		Point p = element.getLocation();
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();
		BufferedImage img = ImageIO.read(take);
		try {
			BufferedImage dest = img.getSubimage(p.getX(), p.getY() / 2, width, height);
			ImageIO.write(dest, "png", take);
			File f1 = new File(ImageCracker.IMAGE_ROOT_PATH + "Original2.png");
			FileUtils.copyFile(take, f1);
		} catch (RasterFormatException ignoRasterFormatException) {
			System.out.println("Ignore Exception");
		}

	}
}
