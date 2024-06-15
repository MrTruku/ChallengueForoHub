package com.challengue.foro_alura.dbRepository;

import com.challengue.foro_alura.models.Course;
import com.challengue.foro_alura.models.Responses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long>
{
}
