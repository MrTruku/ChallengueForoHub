package com.challengue.foro_alura.Services.validation.topic;

import com.challengue.foro_alura.DtoGetData.topics.DtoCreateTopicToDatabase;
import com.challengue.foro_alura.DtoResponses.topics.DtoResponseGetDataTopic;
import com.challengue.foro_alura.Services.validation.IValidationTopic;
import com.challengue.foro_alura.databaseRepositories.TopicRepository;
import com.challengue.foro_alura.models.Topic;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class validateNoEqualTitleOrMessage implements IValidationTopic
{
    @Autowired
    TopicRepository topicRepository;

    @Override
    public void checkValidation(DtoCreateTopicToDatabase dataTopic)
    {
        Topic topicData = topicRepository.findTopicByTitleOrMessage(dataTopic.title(), dataTopic.message());

        if(topicData != null)
        {
            throw new ValidationException("El tema existe con título o descripción del mensaje.");
        }
    }
}
