package com.mak.ht.repository;

import com.mak.ht.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TasksRepository extends JpaRepository<Tasks, Long> {

}
