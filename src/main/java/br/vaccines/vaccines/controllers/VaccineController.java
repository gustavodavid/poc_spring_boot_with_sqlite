package br.vaccines.vaccines.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.vaccines.vaccines.models.Vaccine;
import br.vaccines.vaccines.repository.VaccineRepository;

@Controller
public class VaccineController {
	
	@Autowired
	private VaccineRepository vaccineRepository;
	
	@RequestMapping(value="/addVaccine", method=RequestMethod.GET)
	public String form() {
		return "vaccine/formVaccine";
	}
	
	@RequestMapping(value="/addVaccine", method=RequestMethod.POST)
	public String form(Vaccine vaccine) {
		
		try{
			vaccineRepository.save(vaccine);
			return "redirect:/vaccines";
		} catch (Exception e) {			
			return "redirect:/addVaccine";
		}
	}
	
	@RequestMapping("/vaccines")
	public ModelAndView listVaccines() {
		ModelAndView modelAndView = new ModelAndView("index");
		Iterable <Vaccine> vaccines = vaccineRepository.findAll();
		modelAndView.addObject("vaccines", vaccines);
		return modelAndView;
	}
	
	@RequestMapping("/deleteVaccine")
	public String deleteVaccine(long id) {
		Vaccine vaccine = vaccineRepository.findById(id);
		vaccineRepository.delete(vaccine);
		return "redirect:/vaccines";
	}
	
}
