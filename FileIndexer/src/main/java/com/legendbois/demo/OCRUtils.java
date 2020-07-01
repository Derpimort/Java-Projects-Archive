package com.legendbois.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class OCRUtils {
	
	private Tesseract tesseract;
	private FileRepository fileRepo;
	
	public OCRUtils(FileRepository fileRepo) {
		this.tesseract = new Tesseract();
		this.tesseract.setDatapath("Tess4J/tessdata/");
		this.tesseract.setLanguage("eng");
		this.fileRepo = fileRepo;
	}
	

	public boolean iterateDir(String directory) {
		try (Stream<Path> paths = Files.walk(Paths.get(directory))) {
		      paths.forEach(path -> OCR(path));
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		return true;
	}
	
	public boolean isImage(Path path) {
		String mimetype;
		try {
			mimetype = Files.probeContentType(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		//mimetype should be something like "image/png"

		if (mimetype != null && mimetype.split("/")[0].equals("image")) {
		    return true;
		}
		return false;
	}
	
	public void OCR(Path filename) {
		if (isImage(filename)) {
			try {
				System.out.println(filename);
				String text = tesseract.doOCR(filename.toFile());
				int maxLength = (text.length() < 500)?text.length():500;
				text = text.substring(0, maxLength);
				FileModel fm = new FileModel();
				fm.setFname(filename.getFileName().toString());
				fm.setPath(filename.toString());
				fm.setContent(text);
				//System.out.println(text);
				this.fileRepo.save(fm);
			} catch (TesseractException e) {
				e.printStackTrace();
			} 
			
		}
		
	}
}
