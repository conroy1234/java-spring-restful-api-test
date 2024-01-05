package uk.co.huntersix.spring.rest.referencedata;

import org.springframework.stereotype.Service;
import uk.co.huntersix.spring.rest.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonDataService {
    public static final List<Person> PERSON_DATA = Arrays.asList(
        new Person("Mary", "Smith"),
        new Person("Conroy", "Smith"),
        new Person("Brian", "Archer"),
        new Person("Collin", "Brown")
    );

    public Person findPerson(String lastName, String firstName) {
        return PERSON_DATA.stream()
            .filter(p -> p.getFirstName().equalsIgnoreCase(firstName)
                && p.getLastName().equalsIgnoreCase(lastName))
            .collect(Collectors.toList()).get(0);
    }

    public List<Person> findPersonsBySurname(String lastName){

        List<Person> persons = PERSON_DATA.stream()
                .filter(p ->p.getLastName().equals(lastName))
                .collect(Collectors.toList());
        return persons;
    }

    public List<Person> addPerson(Person person) {

        List<Person> persons = new ArrayList<>();
        for (Person p : PERSON_DATA) {
            persons.add(p);
        }
        if (person.isPersonExist(person,persons)) {
        person.setId(Long.valueOf(persons.size() + 1));
        persons.add(person);
    }
        return persons;
    }

}
