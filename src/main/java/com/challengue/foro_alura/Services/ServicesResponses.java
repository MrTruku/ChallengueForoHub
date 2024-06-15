package com.challengue.foro_alura.Services;

import com.challengue.foro_alura.DtoGetData.topics.DtoCreateResponse;
import com.challengue.foro_alura.DtoGetData.topics.DtoCreateResponseToDatabase;
import com.challengue.foro_alura.DtoGetData.topics.DtoUpdateResponse;
import com.challengue.foro_alura.DtoResponses.topics.DtoResponseDeleteResponse;
import com.challengue.foro_alura.DtoResponses.topics.DtoResponseInfoResponse;
import com.challengue.foro_alura.DtoResponses.topics.DtoResponsesInfoOfResponsesTopic;
import com.challengue.foro_alura.databaseRepositories.ResponsesRepository;
import com.challengue.foro_alura.databaseRepositories.TopicRepository;
import com.challengue.foro_alura.databaseRepositories.UserRepository;
import com.challengue.foro_alura.models.Course;
import com.challengue.foro_alura.models.Responses;
import com.challengue.foro_alura.models.Topic;
import com.challengue.foro_alura.models.User;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesResponses
{
    @Autowired
    ResponsesRepository responsesRepository;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    UserRepository userRepository;

    public DtoResponseInfoResponse getResponseById(int responseId)
    {
        Optional<Responses> responseGetter = responsesRepository.findById(Long.valueOf(responseId));

        if(responseGetter.isEmpty())
        {
            throw new ValidationException("La respuesta no existe, por favor verifica si el código es correcto.");
        }

        Responses response = responseGetter.get();

        DtoResponseInfoResponse dtoResponseInfoResponse = new DtoResponseInfoResponse(response.getCode(),
                response.getTopic().getCode(),
                response.getMessage(),
                response.getSolution(),
                response.getCreationdate(),
                response.getAuthor().getUsername());

        return dtoResponseInfoResponse;
    }

    public DtoResponsesInfoOfResponsesTopic createResponse(DtoCreateResponse dtoCreateResponse)
    {
        //Find the objects with the IDs
        Optional<User> userGetter = userRepository.findById(Long.valueOf(dtoCreateResponse.idAuthor()));
        Optional<Topic> topicGetter = topicRepository.findById(Long.valueOf(dtoCreateResponse.idTopic()));

        if(userGetter.isEmpty())
        {
            throw new ValidationException("El código del usuario no existe, por favor compruébalo");
        }

        if(topicGetter.isEmpty())
        {
            throw new ValidationException("El código del usuario no existe, por favor compruébalo");
        }

        DtoCreateResponseToDatabase dtoCreateResponseToDatabase = new DtoCreateResponseToDatabase(
                dtoCreateResponse.message(),
                topicGetter.get(),
                userGetter.get(),
                dtoCreateResponse.solution()
        );

        Responses response = new Responses(dtoCreateResponseToDatabase);

        responsesRepository.save(response);

        return fillData(topicGetter.get(), response);
    }

    public DtoResponsesInfoOfResponsesTopic updateResponse(Long idResponse, DtoUpdateResponse dtoUpdateResponse)
    {
        //Find the objects with the IDs
        Optional<User> userGetter = userRepository.findById(Long.valueOf(dtoUpdateResponse.idAuthor()));
        Optional<Topic> topicGetter = topicRepository.findById(Long.valueOf(dtoUpdateResponse.idTopic()));

        if(userGetter.isEmpty())
        {
            throw new ValidationException("El código del usuario no existe, por favor compruébalo");
        }

        if(topicGetter.isEmpty())
        {
            throw new ValidationException("El código del usuario no existe, por favor compruébalo");
        }

        Responses response = responsesRepository.findById(idResponse).get();

        response.setMessage(dtoUpdateResponse.message());
        response.setSolution(dtoUpdateResponse.solution());
        response.setAuthor(userGetter.get());
        response.setTopic(topicGetter.get());

        return fillData(topicGetter.get(), response);
    }

    public DtoResponseDeleteResponse deleteResponse(Long id)
    {
        try
        {
            DtoResponseDeleteResponse dtoResponseDeleteResponse = new DtoResponseDeleteResponse(200,
                    "La respuesta fue eliminada correctamente.");

            responsesRepository.deleteById(id);

            return dtoResponseDeleteResponse;
        }
        catch (Exception e)
        {
            throw new ValidationException("Ocurrió un error al eliminar una respuesta.");
        }
    }

    public List<DtoResponsesInfoOfResponsesTopic> getResponsesByTopic(int topicId)
    {
        Optional<Topic> topicGetter = topicRepository.findById(Long.valueOf(topicId));
        List<DtoResponsesInfoOfResponsesTopic> listResponses = new ArrayList<>();

        if(topicGetter.isEmpty())
        {
            throw new ValidationException("El código del usuario no existe, por favor compruébalo");
        }

        Topic topic = topicGetter.get();

        List<Responses> responsesList =  responsesRepository.findByTopicId(topicId);

        for(Responses r: responsesList)
        {
            DtoResponsesInfoOfResponsesTopic dtoResponsesInfoOfResponsesTopic = fillData(topic, r);

            listResponses.add(dtoResponsesInfoOfResponsesTopic);
        }

        return listResponses;
    }

    public DtoResponsesInfoOfResponsesTopic fillData(Topic topic, Responses response)
    {
        DtoResponsesInfoOfResponsesTopic dtoResponsesInfoOfResponsesTopic = new DtoResponsesInfoOfResponsesTopic(
                topic.getCode(),
                topic.getMessage(),
                response.getCode(),
                response.getMessage(),
                response.getSolution(),
                response.getCreationdate(),
                response.getAuthor().getUsername()
                );

        return dtoResponsesInfoOfResponsesTopic;
    }
}