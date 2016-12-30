/**
 * 
 */
package com.awpl.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awpl.model.Occupation;

/**
 * @author Yogish Shenoy
 *
 */
public interface OccupationRepository extends JpaRepository<Occupation, Long>
{
}