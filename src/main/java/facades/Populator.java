package facades;

import entities.Person;
import entities.Phone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Populator {
    public void populate() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Person p1 = new Person("John", "2020-01-01 00:00");
            Person p2 = new Person("Iska", "1998-01-02 00:00");
            Person p3 = new Person("Jamez", "1998-01-01 00:00");
            Phone ph1 = new Phone("12345679", "Home");
            Phone ph2 = new Phone("99999999", "Work");
            Phone ph3 = new Phone("66666666", "Home");
            p1.addPhone(ph1);
            p2.addPhone(ph2);
            p3.addPhone(ph3);
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    public static void main(String[] args) {
        Populator pop = new Populator();
        pop.populate();
    }
}
