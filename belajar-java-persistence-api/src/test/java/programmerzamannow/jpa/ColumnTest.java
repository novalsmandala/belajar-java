package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.Customer;
import programmerzamannow.jpa.entity.CustomerType;
import programmerzamannow.jpa.util.JpaUtil;

public class ColumnTest {

    @Test
    void column() {

        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("Noval");
        customer.setPrimaryEmail("novalmandala625@gmail.com");
        entityManager.persist(customer);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void transientTest() {

        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = new Customer();
        customer.setId("5");
        customer.setName("Noval");
        customer.setFullName("Noval Surya Mandala");
        customer.setAge((byte)20);
        customer.setMarried(false);
        customer.setType(CustomerType.VIP);
        customer.setPrimaryEmail("novalmandala625@gmail.com");
        entityManager.persist(customer);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
