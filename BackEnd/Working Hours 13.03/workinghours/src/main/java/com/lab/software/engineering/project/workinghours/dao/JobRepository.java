package com.lab.software.engineering.project.workinghours.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.software.engineering.project.workinghours.entity.Break;
import com.lab.software.engineering.project.workinghours.entity.Job;


public interface JobRepository extends JpaRepository<Job, Long> {

}
