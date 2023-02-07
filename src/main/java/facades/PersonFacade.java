package facades;

import entities.Person;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class PersonFacade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    public Person createPerson(Person p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return p;
    }
    public List<Person> getAllPersons(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> tq = em.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> persons = tq.getResultList();
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

    public static void main(String[] args) {
        PersonFacade pf = new PersonFacade();
        Person p = new Person("Jesper", 43, "1968-01-01 00:00:00");
        p.addAddress("Hovedgaden 1");
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
    }
}
