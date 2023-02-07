# Project to show case some JPA features
## Version 2023
1. Intellij JPA Buddy Plugin
2. JPA Structure
3. JPA Palette (from the JPA Buddy Plugin)
4. JPA Annotations
5. Lifecycle Callbacks: PreUpdate, PrePersist, PostLoad.
6. persistence.xml paste in the following:
```xml
<properties>
    <property name="eclipselink.canonicalmodel.subpackage" value="xx345y657"/>
    <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
    <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/startcode"/>
    <property name="javax.persistence.jdbc.user" value="dev"/>
    <property name="javax.persistence.jdbc.password" value="ax2"/>
    <property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>
</properties> 
```
   - jdbc.url could be `jdbc:mysql://localhost:3306/startcode?serverTimezone=UTC` but this will set the timezone to UTC and thereby not use the timezone of the server. The dates will be stored minus 1 hour. 
7. 
