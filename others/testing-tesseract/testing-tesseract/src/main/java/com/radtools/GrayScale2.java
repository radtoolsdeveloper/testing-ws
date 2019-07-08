//package com.radtools;
//
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.Imgproc;
//
//public class GrayScale2 {
//	public static void main(String args[]) throws Exception {
//		//System.out.println(System.getProperty("java.library.path"));
//		// To load OpenCV core library
//		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//		String input = ImageCracker.IMAGE_ROOT_PATH + "RCL5.jpg";
//
//		// To Read the image
//		Mat source = Imgcodecs.imread(input);
//
//		// Creating the empty destination matrix
//		Mat destination = new Mat();
//
//		// Converting the image to gray scale and
//		// saving it in the dst matrix
//		Imgproc.cvtColor(source, destination, Imgproc.COLOR_RGB2GRAY, 0);
//		
//		// Writing the image
//		Imgcodecs.imwrite(ImageCracker.IMAGE_ROOT_PATH + "grayscale.png", destination);
//		System.out.println("The image is successfully to Grayscale");
//	}
//}