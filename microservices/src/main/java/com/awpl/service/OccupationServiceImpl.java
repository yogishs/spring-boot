package com.awpl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.awpl.data.OccupationRepository;
import com.awpl.model.Occupation;

@Service
@Transactional
public class OccupationServiceImpl implements OccupationService
{
	@Autowired
	private OccupationRepository occupationRepository;
	@Override
	public List<Occupation> listAll()
	{
		return occupationRepository.findAll();
	}
	/**
	 * @return the occupationRepository
	 */
	public OccupationRepository getOccupationRepository()
	{
		return occupationRepository;
	}
	/**
	 * @param occupationRepository the occupationRepository to set
	 */
	public void setOccupationRepository(OccupationRepository occupationRepository)
	{
		this.occupationRepository = occupationRepository;
	}

}
