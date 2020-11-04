package com.springtest2.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtest2.beans.Job;

public interface JobRepo extends JpaRepository<Job, Long> {
	List<Job> findByEndDateBetween(Date startDate , Date endDate);
	List<Job> findByEndDate(Date endDate);
}
