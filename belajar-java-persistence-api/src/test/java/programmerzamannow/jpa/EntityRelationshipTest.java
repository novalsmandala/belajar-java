package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.*;
import programmerzamannow.jpa.util.JpaUtil;

import java.util.HashSet;

public class EntityRelationshipTest {

    @Test
    void oneToOnePersist() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Credential credential = new Credential();
        credential.setId("mandala");
        credential.setEmail("mandala@example.com");
        credential.setPassword("rahasia");
        entityManager.persist(credential);

        User user = new User();
        user.setId("mandala");
        user.setName("Noval Surya Mandala");
        entityManager.persist(user);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void findOneToOne() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        User mandala = entityManager.find(User.class, "mandala");

        Assertions.assertNotNull(mandala);
        Assertions.assertEquals("mandala@example.com", mandala.getCredential().getEmail());
        Assertions.assertEquals("rahasia", mandala.getCredential().getPassword());

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void oneToOneJoinColumn() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User mandala = entityManager.find(User.class, "mandala");

        Wallet wallet = new Wallet();
        wallet.setUser(mandala);
        wallet.setBalance(1_000_000L);

        entityManager.persist(wallet);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void findOneToOneJoinColumn() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        User mandala = entityManager.find(User.class, "mandala");

        Assertions.assertNotNull(mandala);
        Assertions.assertEquals(1_000_000L, mandala.getWallet().getBalance());

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void oneToManyInsert() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = new Brand();
        brand.setId("samsung");
        brand.setName("samsung");

        entityManager.persist(brand);

        Product product = new Product();
        product.setId("p1");
        product.setBrand(brand);
        product.setName("Samsung Galaxy");
        product.setPrice(3_000_000L);

        entityManager.persist(product);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void findOneToMany(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Brand brand = entityManager.find(Brand.class, "samsung");

        Assertions.assertEquals(1, brand.getProducts().size());

        brand.getProducts().forEach(product -> {
            System.out.println(product.getName());
            System.out.println(product.getPrice());
        });

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void manyToManyInsert() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User mandala = entityManager.find(User.class, "mandala");
        mandala.setLikes(new HashSet<>());

        Product product1 = entityManager.find(Product.class, "p1");
        Product product2 = entityManager.find(Product.class, "p2");

        mandala.getLikes().add(product1);
        mandala.getLikes().add(product2);

        entityManager.merge(mandala);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void findManyToMany(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        User mandala = entityManager.find(User.class, "mandala");

        mandala.getLikes().forEach(product -> {
            System.out.println(product.getName());
        });

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void manyToManyUpdate() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User mandala = entityManager.find(User.class, "mandala");

        Product product = null;
        for (Product item: mandala.getLikes()) {
            product = item;
        }
        mandala.getLikes().remove(product);

        entityManager.merge(mandala);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void fetch() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Product product = entityManager.find(Product.class, "p1");
        String name = product.getBrand().getName();
        System.out.println(name);
        Assertions.assertNotNull(product.getBrand());
//        Brand brand = entityManager.find(Brand.class, "samsung");

        entityManager.close();
        entityManagerFactory.close();
    }

}
