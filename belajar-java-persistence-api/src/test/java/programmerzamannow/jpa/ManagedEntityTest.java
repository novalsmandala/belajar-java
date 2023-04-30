package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.LockModeType;
import org.hibernate.sql.results.graph.basic.BasicResultGraphNode;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.Brand;
import programmerzamannow.jpa.util.JpaUtil;

import java.time.LocalDateTime;

public class ManagedEntityTest {

    @Test
    void managedEntity() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = new Brand();
        brand.setId("oppo");
        brand.setName("Oppo");

        entityManager.persist(brand);

        brand.setName("Oppo F1");

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void findManagedEntity() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = entityManager.find(Brand.class, "oppo");
        brand.setName("Oppo Indonesia");

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void detachManagedEntity() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = entityManager.find(Brand.class, "oppo");
        entityManager.detach(brand);
        brand.setName("Oppo America");

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void findManagedEntityAfterTransaction() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = entityManager.find(Brand.class, "oppo");

        transaction.commit();
        brand.setName("Oppo Russian");
        entityManager.close();
        entityManagerFactory.close();
    }
}
