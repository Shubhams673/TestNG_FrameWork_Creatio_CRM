package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

// All Classes and Common methods related to different utilities like pdf files

public class PDFUtil {

	public static String getText(String filePath) {

		String text = "";

		// To input the PDF file
		try {
			FileInputStream fis = new FileInputStream(filePath);
						
			// Load the PDF file
			PDDocument document = PDDocument.load(fis);
			
			// Copy the text from PDF Document
			PDFTextStripper pdf = new PDFTextStripper();
			
			// Page wise text Reading
			pdf.setStartPage(2);
			pdf.setEndPage(2);
			
			
			// Copy the text
			text = pdf.getText(document);  // This will read, each and every line of the text
		
			
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
		
		

		return text;

	}

}
