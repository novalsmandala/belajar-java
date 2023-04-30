package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.hibernate.engine.spi.Managed;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.*;
import programmerzamannow.jpa.util.JpaUtil;

import java.time.LocalDateTime;

public class InheritanceTest {

    @Test
    void singleTableInheritance() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Employee employee = new Employee();
        employee.setId("noval");
        employee.setName("Noval Mandala");
        entityManager.persist(employee);

        Manager manager = new Manager();
        manager.setId("joko");
        manager.setName("Joko Kendil");
        manager.setTotalEmployee(10);
        entityManager.persist(manager);

        VicePresident vicePresident = new VicePresident();
        vicePresident.setId("eko");
        vicePresident.setName("Eko Khannedy");
        vicePresident.setTotalManager(5);
        entityManager.persist(vicePresident);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void singleTableFind() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Manager manager = entityManager.find(Manager.class, "joko");
        Assertions.assertNotNull(manager);
        Assertions.assertEquals("Joko Kendil", manager.getName());

        VicePresident vicePresident = entityManager.find(VicePresident.class, "eko");
        Assertions.assertNotNull(vicePresident);
        Assertions.assertEquals("Eko Khannedy", vicePresident.getName());

        Employee employee = entityManager.find(Employee.class, "noval");
        Assertions.assertNotNull(employee);
        Assertions.assertEquals("Noval Mandala", employee.getName());

//        polymorphism
        employee = entityManager.find(Employee.class, "eko");
        VicePresident vp = (VicePresident) employee;
        employee = entityManager.find(Employee.class, "joko");
        Manager mng = (Manager) employee;

        Assertions.assertNotNull(vp);
        Assertions.assertNotNull(mng);

        Assertions.assertEquals("Eko Khannedy", vp.getName());
        Assertions.assertEquals("Joko Kendil", mng.getName());
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void joinedTableInsert() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        PaymentGopay paymentGopay = new PaymentGopay();
        paymentGopay.setId("gopay1");
        paymentGopay.setGopayId("909099449");
        paymentGopay.setAmount(500_000L);
        entityManager.persist(paymentGopay);

        PaymentCreditCard paymentCreditCard = new PaymentCreditCard();
        paymentCreditCard.setId("cc1");
        paymentCreditCard.setMaskedCard("445-5555");
        paymentCreditCard.setBank("BCA");
        paymentCreditCard.setAmount(1_000_000L);
        entityManager.persist(paymentCreditCard);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void joinedTableFind() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        PaymentGopay paymentGopay = entityManager.find(PaymentGopay.class, "gopay1");
        PaymentCreditCard paymentCreditCard = entityManager.find(PaymentCreditCard.class, "cc1");

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void joinedTableFindParent() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Payment payment = entityManager.find(Payment.class, "gopay1");
//        PaymentCreditCard paymentCreditCard = entityManager.find(PaymentCreditCard.class, "cc1");

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void tablePerClassInsert() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Transaction transaction = new Transaction();
        transaction.setId("t1");
        transaction.setBalance(1_000_000L);
        transaction.setCreatedAt(LocalDateTime.now());
        entityManager.persist(transaction);

        TransactionDebit transactionDebit = new TransactionDebit();
        transactionDebit.setId("t2");
        transactionDebit.setCreatedAt(LocalDateTime.now());
        transactionDebit.setBalance(2_000_000L);
        transactionDebit.setDebitAmount(1_000_000L);
        entityManager.persist(transactionDebit);

        TransactionCredit transactionCredit = new TransactionCredit();
        transactionCredit.setId("t3");
        transactionCredit.setCreatedAt(LocalDateTime.now());
        transactionCredit.setBalance(1_000_000L);
        transactionCredit.setCreditAmount(1_000_000L);
        entityManager.persist(transactionCredit);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void tablePerClassFind() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TransactionDebit transactionDebit = entityManager.find(TransactionDebit.class, "t2");
        TransactionCredit transactionCredit = entityManager.find(TransactionCredit.class, "t3");

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void tablePerClassFindParent() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Transaction transaction = entityManager.find(Transaction.class, "t1");

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void mappedSuperClass() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = new Brand();
        brand.setId("xiaomi");
        brand.setName("Xiaomi");
        brand.setDescription("Xiaomi Global");
        brand.setCreatedAt(LocalDateTime.now());
        brand.setUpdatedAt(LocalDateTime.now());
        entityManager.persist(brand);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
