package com.global.abcinc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.abcinc.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

}
