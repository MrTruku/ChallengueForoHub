package com.challengue.foro_alura.DtoGetData.topics;

import com.challengue.foro_alura.models.Topic;
import com.challengue.foro_alura.models.User;

public record DtoCreateResponse (
        String message,
        int idTopic,
        int idAuthor,
        String solution
)
{
}
