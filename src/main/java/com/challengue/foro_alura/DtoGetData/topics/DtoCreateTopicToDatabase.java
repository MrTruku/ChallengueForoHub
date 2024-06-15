package com.challengue.foro_alura.DtoGetData.topics;

import com.challengue.foro_alura.models.Course;
import com.challengue.foro_alura.models.Status;
import com.challengue.foro_alura.models.User;

public record DtoCreateTopicToDatabase (
        String title,
        String message,
        User user,
        Course course,
        Status status
)
{
}
