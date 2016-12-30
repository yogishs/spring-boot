package com.awpl.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.awpl.model.Country;
import com.awpl.service.CountryService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/api/country/")
public class CountryController
{
    @Autowired
    CountryService countryService;
    @RequestMapping(method=RequestMethod.GET,path="/")
    List<Country> getCountries()
    {
        return countryService.listCountries();
    }
}