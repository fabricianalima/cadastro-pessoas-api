package one.digitalinovationone.personalapi.repository;

import one.digitalinovationone.personalapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
