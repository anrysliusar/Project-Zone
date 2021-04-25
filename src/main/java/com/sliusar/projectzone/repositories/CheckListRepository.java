package com.sliusar.projectzone.repositories;

import com.sliusar.projectzone.models.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckListRepository extends JpaRepository<TaskList, Integer> {
}