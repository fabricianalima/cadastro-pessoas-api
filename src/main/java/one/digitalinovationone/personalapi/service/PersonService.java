package one.digitalinovationone.personalapi.service;

import one.digitalinovationone.personalapi.dto.MessageResponseDTO;
import one.digitalinovationone.personalapi.dto.PersonDTO;
import one.digitalinovationone.personalapi.entity.Person;
import one.digitalinovationone.personalapi.dto.mapper.PersonMapper;
import one.digitalinovationone.personalapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
}