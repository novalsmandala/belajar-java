package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.LockModeType;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.Brand;
import programmerzamannow.jpa.util.JpaUtil;

import java.time.LocalDateTime;

public class LockingTest {

    @Test
    void optimisticLocking() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = new Brand();
        brand.setId("nokia");
        brand.setName("Nokia");
        brand.setDescription("HP Nokia");
        brand.setCreatedAt(LocalDateTime.now());
        brand.setUpdatedAt(LocalDateTime.now());
        entityManager.persist(brand);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void optimisticLockingDemo1() throws InterruptedException {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = entityManager.find(Brand.class, "nokia");
        brand.setName("Nokia demo 1 updated");
        brand.setUpdatedAt(LocalDateTime.now());

        Thread.sleep(10 * 1000);
        entityManager.merge(brand);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void optimisticLockingDemo2() throws InterruptedException {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = entityManager.find(Brand.class, "nokia");
        brand.setName("Nokia demo 2 updated");
        brand.setUpdatedAt(LocalDateTime.now());

        entityManager.merge(brand);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void pessimisticLockingDemo1() throws InterruptedException {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = entityManager.find(Brand.class, "nokia", LockModeType.PESSIMISTIC_WRITE);
        brand.setName("Nokia 1 updated");
        brand.setUpdatedAt(LocalDateTime.now());

        Thread.sleep(10*1000);
        entityManager.merge(brand);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void pessimisticLockingDemo2() throws InterruptedException {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = entityManager.find(Brand.class, "nokia", LockModeType.PESSIMISTIC_WRITE);
        brand.setName("Nokia 2 updated");
        brand.setUpdatedAt(LocalDateTime.now());

        entityManager.merge(brand);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
