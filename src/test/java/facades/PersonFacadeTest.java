package facades;

import entities.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PersonFacadeTest {
    PersonFacade facade = new PersonFacade();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createPerson() {
    }

    @Test
    void getAllPersons() {
    }

    @Test
    void getPerson() {
    }

    @Test
    void updatePerson() {
    }

    @Test
    void deletePerson() {
    }

    @Test
    void getAllPeople() {
    }

    @Test
    void getPersonById() {
    }

    @Test
    void getPersonByPhone() {
        System.out.println("get person by phone");
        String expected = "John";
        String actual = facade.getPersonByPhone("12345679").getName();
        assertEquals(expected, actual);
    }

    @Test
    void getPeopleByCar() {
    }

    @Test
    void getPeopleAboveAvgAge() {
        System.out.println("get people above avg age");
        String expected = "Jamez";
        Set<Person> actual = facade.getPeopleAboveAvgAge();
        actual.forEach(person -> {
            assertTrue(person.getName().equals(expected));
        });

    }

    @Test
    void getPeopleByBirthday() {
    }

    @Test
    void main() {
    }

    @Test
    void testCreatePerson() {
    }

    @Test
    void testGetAllPersons() {
    }

    @Test
    void testGetPerson() {
    }

    @Test
    void testUpdatePerson() {
    }

    @Test
    void testDeletePerson() {
    }

    @Test
    void testGetAllPeople() {
    }

    @Test
    void testGetPersonById() {
    }

    @Test
    void testGetPersonByPhone() {
    }

    @Test
    void testGetPeopleByCar() {
    }

    @Test
    void testGetPeopleAboveAvgAge() {
    }

    @Test
    void testGetPeopleByBirthday() {
    }

    @Test
    void addCarToPerson() {
    }
}