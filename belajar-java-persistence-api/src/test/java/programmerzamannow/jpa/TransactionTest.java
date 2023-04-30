package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.util.JpaUtil;

public class TransactionTest {

    @Test
    void transaction() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Assertions.assertNotNull(transaction);

        try {
            transaction.begin();

            transaction.commit();
        } catch (Throwable throwable) {
            transaction.rollback();
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
