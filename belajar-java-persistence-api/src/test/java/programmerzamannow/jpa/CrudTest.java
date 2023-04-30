package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import programmerzamannow.jpa.entity.Customer;
import programmerzamannow.jpa.util.JpaUtil;

public class CrudTest {

    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setUp() {
        entityManagerFactory = JpaUtil.getEntityManagerFactory();
    }

    @Test
    void insert() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("Noval");

        entityManager.persist(customer);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void find() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = entityManager.find(Customer.class, "1");
        Assertions.assertNotNull(customer);
        Assertions.assertEquals("1", customer.getId());
        Assertions.assertEquals("Noval", customer.getName());

        entityManager.persist(customer);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void update() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = entityManager.find(Customer.class, "1");
        Assertions.assertNotNull(customer);

        customer.setName("Noval Mandala");

        entityManager.merge(customer);

        customer = entityManager.find(Customer.class, "1");
        Assertions.assertNotNull(customer);

        Assertions.assertEquals("1", customer.getId());
        Assertions.assertEquals("Noval Mandala", customer.getName());

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void delete() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = entityManager.find(Customer.class, "1");
        Assertions.assertNotNull(customer);

        entityManager.remove(customer);

        customer = entityManager.find(Customer.class, "1");
        Assertions.assertNull(customer);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
