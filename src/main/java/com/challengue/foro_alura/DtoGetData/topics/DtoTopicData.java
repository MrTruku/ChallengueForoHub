package com.challengue.foro_alura.DtoGetData.topics;

import com.challengue.foro_alura.models.Course;
import com.challengue.foro_alura.models.Status;
import com.challengue.foro_alura.models.User;

import java.time.LocalDateTime;

public record DtoTopicData (
        String title,
        String message,
        LocalDateTime creationdate,
        Status status,
        User author,
        Course course
)
{
}
