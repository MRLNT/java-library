package services.person;

import java.util.List;

import models.Orang;

public interface PersonService {
    //CRUD
    void createPerson(Orang orang);
    List<Orang> getAllPerson();
    Orang getPersonById(Integer id);
    void deletePerson(Integer id);
}