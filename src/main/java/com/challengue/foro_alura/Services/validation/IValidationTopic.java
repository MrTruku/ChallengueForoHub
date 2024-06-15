package com.challengue.foro_alura.Services.validation;

import com.challengue.foro_alura.DtoGetData.topics.DtoCreateTopicToDatabase;
import com.challengue.foro_alura.DtoResponses.topics.DtoResponseGetDataTopic;

public interface IValidationTopic {

    public void checkValidation(DtoCreateTopicToDatabase dataTopic);
}
