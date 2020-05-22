package com.uca.capas.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;

@Controller
public class MainController {
	@Autowired
	private ContribuyenteService contribuyenteService;
	
	@Autowired
	private ImportanciaService importanciaService;

	@RequestMapping("/inicio")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		Contribuyente contribuyente = new Contribuyente();
		
		mav.addObject("contribuyente", contribuyente);
		mav.addObject("importancias", listImportancias());
		mav.setViewName("index");
		return mav;
	}

	// Show list
	@RequestMapping(value = "/listado")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> listContri = contribuyenteService.findAll();
		
		try {
			listContri = contribuyenteService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("listContri", listContri);
		mav.setViewName("listado");

		return mav;

	}

	@RequestMapping("/insert")
	public ModelAndView insert(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) throws ParseException {
		ModelAndView mav = new ModelAndView();
		Contribuyente estudianteClean = new Contribuyente();
		//date
		long millis=System.currentTimeMillis();  
		Date sdate=new java.sql.Date(millis);  
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		
		
		//System.out.println(udate.toString()); 
		
		if (result.hasErrors()) {
			mav.addObject("contribuyente", contribuyente);
			mav.addObject("importancias", listImportancias());
			mav.setViewName("index");
		}else {
			contribuyente.setFfecha_ingreso(sdate);
			contribuyenteService.save(contribuyente);
			mav.addObject("contribuyente", estudianteClean);
			mav.setViewName("exito");
		}
		
		
		return mav;
		
	}
	
	public List<Importancia> listImportancias(){
		
		Importancia importancia = new Importancia();
		List<Importancia> importancias = null;
		
		
		
		try {
			importancias = importanciaService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return importancias;
	}
	 
}
