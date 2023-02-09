package facades;

import entities.Car;
import entities.Person;

import java.util.Set;

public interface ISelector {
    Set<Person> getAllPeople();
    Person getPersonById(Long id);
    Person getPersonByPhone(String phoneNumber);
    Set<Person> getPeopleByCar(Car car);
    Set<Person> getPeopleAboveAvgAge();
    Set<Person> getPeopleByBirthday();
}
