package hello;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends GraphRepository<Person> {

    Person findByName(String name);

    Iterable<Person> findByTeammatesName(String name);

}