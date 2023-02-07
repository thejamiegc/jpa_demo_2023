package entities;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "birth_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // not needed, but it's good to be explicit.
    private LocalDateTime birthDate;

    @Column(name = "age")
    @Transient // not persisted because it is derived from birthDate.
    private Integer age;

    @ElementCollection
    @Column(name = "address")
    @CollectionTable(name = "person_addresses", joinColumns = @JoinColumn(name = "owner_id"))
    private Set<String> addresses = new HashSet<>();

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public Person(String name, Integer age, String birthDate) {
        this.name = name;
        this.age = age;
        setBirthDate(birthDate);
    }

    public Set<String> getAddresses() {
        return addresses;
    }

    public void addAddress(String address) {
        this.addresses.add(address);
    }

    public void removeAddress(String address) {
        for (String a : this.addresses)
            if (a == address)
                this.addresses.remove(a);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge( ) {
        java.time.Duration duration = java.time.Duration.between(birthDate, LocalDateTime.now());
        this.age = (int) duration.toDays() / 365;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime bd = LocalDateTime.parse(birthDate, formatter);
        this.birthDate = bd;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "age = " + age + ")";
    }
}