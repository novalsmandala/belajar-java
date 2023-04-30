package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.Customer;
import programmerzamannow.jpa.entity.CustomerType;
import programmerzamannow.jpa.util.JpaUtil;

public class EnumTest {

    @Test
    void testEnum() {

        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Customer customer = new Customer();
        customer.setId("4");
        customer.setName("Budi");
        customer.setPrimaryEmail("Budi@example.com");
        customer.setAge((byte)30);
        customer.setMarried(true);
        customer.setType(CustomerType.PREMIUM);
        entityManager.persist(customer);

        Assertions.assertNotNull(customer.getId());

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
