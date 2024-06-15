package com.challengue.foro_alura.DtoGetData.topics;

import com.challengue.foro_alura.models.Topic;
import com.challengue.foro_alura.models.User;

public record DtoCreateResponseToDatabase(
        String message,
        Topic topic,
        User author,
        String solution
) {
}
