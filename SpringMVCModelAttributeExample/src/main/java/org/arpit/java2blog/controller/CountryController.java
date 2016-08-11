package org.arpit.java2blog.controller;

import org.arpit.java2blog.bean.Country;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountryController {

	@ModelAttribute
	public Country getCountry(@RequestParam String countryName, @RequestParam  long population)
	{
		Country country=new Country();
		country.setCountryName(countryName);
		country.setPopulation(population);
		return country;
	}
	@RequestMapping(value = "/addCountry", method = RequestMethod.POST)
	public String addCountry(@ModelAttribute Country country,ModelMap model) {
		model.addAttribute("countryName", country.getCountryName());
		model.addAttribute("population", country.getPopulation());
		return "countryDetails";
	}

	
}
