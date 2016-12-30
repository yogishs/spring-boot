/**
 * 
 */
package com.awpl.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awpl.model.Country;

/**
 * @author Yogish Shenoy
 *
 */
public interface CountryRepository extends JpaRepository<Country, Long>
{
}