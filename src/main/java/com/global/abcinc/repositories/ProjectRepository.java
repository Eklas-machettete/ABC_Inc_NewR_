package com.global.abcinc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.abcinc.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>  {

}
