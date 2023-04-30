package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.Category;
import programmerzamannow.jpa.entity.Customer;
import programmerzamannow.jpa.util.JpaUtil;

import java.time.LocalDateTime;
import java.util.Calendar;

public class DateTest {

    @Test
    void dateAndTime() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Category category = new Category();
        category.setName("Fruit");
        category.setDescription("Best Fruit");
        category.setCreatedAt(Calendar.getInstance());
        category.setUpdatedAt(LocalDateTime.now());
        entityManager.persist(category);

        transaction.begin();
        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
