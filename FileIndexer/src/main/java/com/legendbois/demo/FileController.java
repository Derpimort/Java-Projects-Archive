package com.legendbois.demo;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileController {
	
	@Autowired
	private FileRepository fileRepo;
	
	@RequestMapping(path="/")
	public String welcome(@RequestParam(value = "choose", required = false, defaultValue = "test") String choice) {
//		ModelAndView mv = new ModelAndView("welcome.jsp");
//		mv.addObject("name", "Jeff");
//		return mv;
		if (choice.equals("folder")) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JFileChooser f = new JFileChooser();
	        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
	        int fc = f.showOpenDialog(null);
	        if (fc == JFileChooser.APPROVE_OPTION) {
	        	//System.out.println(f.getCurrentDirectory());
		        OCRUtils ocr = new OCRUtils(fileRepo);
		        ocr.iterateDir(f.getSelectedFile().getPath());
	        }
	        
		}
		return "welcome";
	}
	
	@RequestMapping(path="/rows")
	public String rows() {
		return "rows";
	}

	@GetMapping(path="/all")
	@ResponseBody
	public Iterable<FileModel> getAllFiles(){
		return fileRepo.findAll();
	}
	
	
		
}
