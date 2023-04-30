package programmerzamannow.jpa;

import jakarta.persistence.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.*;
import programmerzamannow.jpa.util.JpaUtil;
import java.util.List;

public class JpaQueryLanguageTest {

    @Test
    void select() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        TypedQuery<Brand> selectBFromBrandB = entityManager.createQuery("select b from Brand b", Brand.class);
        List<Brand> resultList = selectBFromBrandB.getResultList();

        resultList.forEach(brand -> {
            System.out.println(brand.getId() + " : " + brand.getName());
        });


        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void whereClause() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        TypedQuery<Member> query = entityManager.createQuery(
                "select m from Member m where m.name.firstName = :firstName" +
                    " and m.name.lastName = :lastName", Member.class
        );

        query.setParameter("firstName", "Noval");
        query.setParameter("lastName", "Mandala");

        List<Member> resultList = query.getResultList();

        for (Member member : resultList) {
            System.out.println("fullName: " + member.getFullName());
        }

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void joinClause() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        TypedQuery<Product> query = entityManager.createQuery(
                "select p from Product p join p.brand b where b.name = :brand", Product.class
        );

        query.setParameter("brand", "Samsung");

        List<Product> resultList = query.getResultList();

        for (Product product : resultList) {
            System.out.println("Name: " + product.getName());
        }

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void joinFetchClause() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        TypedQuery<User> query = entityManager
                .createQuery("select u from User u join fetch u.likes p where p.name = :product", User.class);
        query.setParameter("product", "Samsung Note");
        List<User> resultList = query.getResultList();
        resultList.forEach(result -> System.out.println(result.getName()));
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void orderByClause() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        TypedQuery<Brand> query = entityManager
                .createQuery("select b from Brand b order by b.name asc", Brand.class);

        List<Brand> resultList = query.getResultList();
        resultList.forEach(result -> System.out.println(result.getName()));
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void insertRandomBrand() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        for (int i = 0; i < 100; i++) {
            Brand brand = new Brand();
            brand.setId(String.valueOf(i));
            brand.setName("Brand " + i);
            entityManager.persist(brand);
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void limitOffset() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        TypedQuery<Brand> query = entityManager
                .createQuery("select b from Brand b order by b.id desc", Brand.class);

        query.setFirstResult(10);
        query.setMaxResults(10);

        List<Brand> resultList = query.getResultList();

        for (Brand brand : resultList) {
            System.out.println(brand.getId() + " : " + brand.getName());
        }

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void namedQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        TypedQuery<Brand> selectBFromBrandB = entityManager.createNamedQuery("Brand.findAllByName", Brand.class);
        selectBFromBrandB.setParameter("name", "Xiaomi");
        List<Brand> resultList = selectBFromBrandB.getResultList();

        resultList.forEach(brand -> {
            System.out.println(brand.getId() + " : " + brand.getName());
        });


        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void selectSomeField() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        TypedQuery<Object[]> query = entityManager
                .createQuery("select b.id, b.name from Brand b where b.name = :name", Object[].class);
        query.setParameter("name", "Xiaomi");
        List<Object[]> resultList = query.getResultList();

        for (Object[] objects : resultList) {
            System.out.println(objects[0] + " : " + objects[1]);
        }

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void selectSomeFieldWithConstructorExpression() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        TypedQuery<SimpleBrand> query = entityManager.createQuery(
                "select new programmerzamannow.jpa.entity.SimpleBrand(b.id, b.name) " +
                        "from Brand b where b.name = :name", SimpleBrand.class);
        query.setParameter("name", "Xiaomi");
        List<SimpleBrand> resultList = query.getResultList();
        for (SimpleBrand simpleBrand : resultList) {
            System.out.println(simpleBrand.getName());
        }
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void aggregateQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        TypedQuery<Object[]> query = entityManager
                .createQuery("select min(p.price), max(p.price), avg(p.price) from Product p", Object[].class);

        Object[] singleResult = query.getSingleResult();

        System.out.println("MIN: " + singleResult[0]);
        System.out.println("MAX: " + singleResult[1]);
        System.out.println("AVG: " +  singleResult[2]);   ;

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void aggregateQueryGroupBy() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        TypedQuery<Object[]> query = entityManager
                .createQuery("select b.id, min(p.price), max(p.price), avg(price)" +
                        " from Product p join p.brand b group by b.id having min(p.price) > :min",
                        Object[].class);

        query.setParameter("min", 500_000L);

        List<Object[]> result = query.getResultList();

        for (Object[] objects : result) {
            System.out.println("Brand: " + objects[0]);
            System.out.println("MIN: " + objects[1]);
            System.out.println("MAX: " + objects[2]);
            System.out.println("AVG: " +  objects[3]);
        }

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void createNativeQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Query nativeQuery = entityManager
                .createNativeQuery("select * from brands where brands.created_at is not null", Brand.class);

        List<Brand> resultList = nativeQuery.getResultList();

        for (Brand brand : resultList) {
            System.out.println(brand.getId());
            System.out.println(brand.getName());
        }

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void createNamedNativeQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Query nativeQuery = entityManager
                .createNamedQuery("Brand.native.findAll", Brand.class);

        List<Brand> resultList = nativeQuery.getResultList();

        for (Brand brand : resultList) {
            System.out.println(brand.getId());
            System.out.println(brand.getName());
        }

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void nonQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query query = entityManager.createQuery("update Brand b set b.name = :name where b.id = :id");

        query.setParameter("name", "Oppo Updated");
        query.setParameter("id", "oppo");

        int impactRecord = query.executeUpdate();
        System.out.println("Success update " + impactRecord + " record");

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}
