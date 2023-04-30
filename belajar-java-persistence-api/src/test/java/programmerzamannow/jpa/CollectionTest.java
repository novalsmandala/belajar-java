package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.Member;
import programmerzamannow.jpa.entity.Name;
import programmerzamannow.jpa.util.JpaUtil;

import java.util.ArrayList;

public class CollectionTest {

    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Name name = new Name();
        name.setTitle("Mr");
        name.setFirstName("Noval");
        name.setMiddleName("Surya");
        name.setLastName("Mandala");

        Member member = new Member();
        member.setName(name);
        member.setEmail("noval@example.com");
        member.setHobbies(new ArrayList<>());

        member.getHobbies().add("Mancing");
        member.getHobbies().add("Tidur");
        member.getHobbies().add("Catur");

        entityManager.persist(member);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void update() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Member member = entityManager.find(Member.class, 2);
        member.getHobbies().add("Memasak");

        entityManager.merge(member);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void updateSkills() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Member member = entityManager.find(Member.class, 2);
        member.getSkills().put("Java", 40);
        member.getSkills().put("javascript", 10);
        member.getSkills().put("Golang", 2);

        entityManager.merge(member);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
