package noval.mandala.test.repository;

import noval.mandala.test.data.Person;

public interface PersonRepository {

    Person selectById(String id);

    void insert(Person name);
}
