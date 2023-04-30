package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.Category;
import programmerzamannow.jpa.entity.Customer;
import programmerzamannow.jpa.util.JpaUtil;

public class GeneratedValueTest {

    @Test
    void generateValue() {

        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Category category = new Category();
        category.setName("Gadget");
        category.setDescription("Gadget termurah");
        entityManager.persist(category);

        Assertions.assertNotNull(category.getId());

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
