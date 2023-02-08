package facades;

import entities.Car;
import entities.Person;
import entities.Phone;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonFacade implements ISelector{
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    public Person createPerson(Person p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            p.getCars().forEach(car -> {
                if(car.getId()==null)
                    em.persist(car);
                else
                    em.merge(car);
            });
            em.persist(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return p;
    }

    public Set<Person> getAllPersons(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> tq = em.createQuery("SELECT p FROM Person p JOIN FETCH p.addresses", Person.class);
        Set<Person> persons = tq.getResultList().stream().collect(Collectors.toSet());
        return persons;
    }

    public Person getPerson(Long id){
        EntityManager em = emf.createEntityManager();
        Person p = em.find(Person.class, id);
        return p;
    }

    public Person updatePerson(Person p){
        EntityManager em = emf.createEntityManager();
        Person found = em.find(Person.class, p.getId());
        if (found == null) {
            throw new IllegalArgumentException("No person with that id");
        }
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return p;
    }

    public Person deletePerson(Long id){
        EntityManager em = emf.createEntityManager();
        Person p = em.find(Person.class, id);
        if (p == null) {
            throw new IllegalArgumentException("No person with that id: " + id + " exists");
        }
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return p;
    }

    @Override
    public Set<Person> getAllPeople() {
        return getAllPersons();
    }

    @Override
    public Person getPersonById(Long id) {
        return getPerson(id);
    }

    @Override
    public Person getPersonByPhone() {
        //return null;
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Set<Person> getPeopleByCar(Car car) {
        //return null;
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Set<Person> getPeopleAboveAvgAge() {
        //return null;
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Set<Person> getPeopleByBirthday() {
        //return null;
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static void main(String[] args) {
        PersonFacade pf = new PersonFacade();
        Person p = new Person("Jesper", "1968-01-01 00:00");
        p.addAddress("Hovedgaden 1");
        Phone phone = new Phone("12345678", "Home");
        p.addPhone(phone);
        p.addCar(new Car("Volvo", "V70", 2000));
        pf.createPerson(p);
//        System.out.println("The person got this new id: " + p.getId());
//        pf.getAllPersons().forEach((person)-> System.out.println(person));
//        System.out.println("GET SINGLE PERSON BY ID:");
//        Person p = pf.getPerson(1L);
//        System.out.println(p);
//        p.setName("Jannie");
//        pf.updatePerson(p);
//        System.out.println("");
//        pf.getAllPersons().forEach((person)-> System.out.println(person));
//        System.out.println("DELETE PERSON WITH ID 1");
//        pf.deletePerson(1L);
        pf.getAllPersons().forEach((person)-> System.out.println(person));
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        TypedQuery<Person> tq = em.createNamedQuery("Person.deleteById", Person.class);
//        tq.setParameter("id", 1L);
//        tq.executeUpdate();
//        em.getTransaction().commit();
//        em.close();
    }
}
