package com.awpl.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.awpl.model.Country;
import com.awpl.model.Occupation;
import com.awpl.service.CountryService;
import com.awpl.service.OccupationService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/api/occupation/")
public class OccupationController
{
    @Autowired
    OccupationService occupationService;
    @RequestMapping(method=RequestMethod.GET,path="/")
    List<Occupation> list()
    {
        return occupationService.listAll();
    }
	/**
	 * @return the occupationService
	 */
	public OccupationService getOccupationService()
	{
		return occupationService;
	}
	/**
	 * @param occupationService the occupationService to set
	 */
	public void setOccupationService(OccupationService occupationService)
	{
		this.occupationService = occupationService;
	}
}