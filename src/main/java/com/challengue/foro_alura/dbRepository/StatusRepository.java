package com.challengue.foro_alura.dbRepository;

import com.challengue.foro_alura.models.Course;
import com.challengue.foro_alura.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
