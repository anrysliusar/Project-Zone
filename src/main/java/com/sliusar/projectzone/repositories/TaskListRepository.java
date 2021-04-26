package com.sliusar.projectzone.repositories;

import com.sliusar.projectzone.models.Task;
import com.sliusar.projectzone.models.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, Integer> {
}
