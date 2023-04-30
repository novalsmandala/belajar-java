package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.Category;
import programmerzamannow.jpa.entity.Customer;
import programmerzamannow.jpa.util.JpaUtil;

public class DataTypeTest {

    @Test
    void dataType() {

        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Customer customer = new Customer();
        customer.setId("3");
        customer.setName("Gadget");
        customer.setPrimaryEmail("noval@example.com");
        customer.setAge((byte)20);
        customer.setMarried(true);
        entityManager.persist(customer);

        Assertions.assertNotNull(customer.getId());

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
