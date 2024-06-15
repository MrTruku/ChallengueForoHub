package com.challengue.foro_alura.DtoGetData.topics;

public record DtoUpdateResponse(
        String message,
        int idTopic,
        int idAuthor,
         String solution) {
}
