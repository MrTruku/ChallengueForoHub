package com.challengue.foro_alura.dbRepository;

import com.challengue.foro_alura.models.Course;
import com.challengue.foro_alura.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
