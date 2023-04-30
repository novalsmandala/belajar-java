package programmerzamannow.jpa;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.Brand;
import programmerzamannow.jpa.entity.Product;
import programmerzamannow.jpa.entity.SimpleBrand;
import programmerzamannow.jpa.util.JpaUtil;

import java.util.List;

public class CriteriaTest {
    @Test
    void criteriaSelect() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> criteriaQuery = builder.createQuery(Brand.class);
        Root<Brand> root = criteriaQuery.from(Brand.class);
        criteriaQuery.select(root);

        TypedQuery<Brand> query = entityManager.createQuery(criteriaQuery);
        List<Brand> resultList = query.getResultList();

        for (Brand brand : resultList) {
            System.out.println(brand.getId() + " : " + brand.getName());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void criteriaQueryNonEntity() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        Root<Brand> root = criteria.from(Brand.class);
        criteria.select(builder.array(root.get("id"), root.get("name")));

        TypedQuery<Object[]> query = entityManager.createQuery(criteria);
        List<Object[]> resultList = query.getResultList();

        for (Object[] objects : resultList) {
            System.out.println("id: " + objects[0]);
            System.out.println("name: " + objects[1]);
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void criteriaQueryNonEntityConstructor() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SimpleBrand> criteriaQuery = builder.createQuery(SimpleBrand.class);
        Root<Brand> root = criteriaQuery.from(Brand.class);
        criteriaQuery.select(builder.construct(SimpleBrand.class, root.get("id"), root.get("name")));

        TypedQuery<SimpleBrand> query = entityManager.createQuery(criteriaQuery);
        List<SimpleBrand> resultList = query.getResultList();

        for (SimpleBrand simpleBrand : resultList) {
            System.out.println(simpleBrand.getId() + " : " + simpleBrand.getName());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void criteriaWhereClause() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> criteria = builder.createQuery(Brand.class);
        Root<Brand> root = criteria.from(Brand.class);

        criteria.where(
                builder.equal(root.get("name"), "Xiaomi"),
                builder.isNotNull(root.get("createdAt"))
        );

        TypedQuery<Brand> query = entityManager.createQuery(criteria);
        List<Brand> resultList = query.getResultList();
        for (Brand brand : resultList) {
            System.out.println(brand.getId() + " " + brand.getName());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void criteriaWhereClauseUsingOrOperator() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> criteria = builder.createQuery(Brand.class);
        Root<Brand> root = criteria.from(Brand.class);

        criteria.where(
                builder.or(
                        builder.equal(root.get("name"), "Xiaomi"),
                        builder.equal(root.get("name"), "Oppo Updated")
                )
        );

        TypedQuery<Brand> query = entityManager.createQuery(criteria);
        List<Brand> resultList = query.getResultList();
        for (Brand brand : resultList) {
            System.out.println(brand.getId() + " " + brand.getName());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void criteriaJoinClause() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
        Root<Product> root = criteria.from(Product.class);
        Join<Product, Brand> brand = root.join("brand");

        criteria.select(root);
        criteria.where(builder.equal(brand.get("name"), "Xiaomi"));

        TypedQuery<Product> query = entityManager.createQuery(criteria);
        List<Product> resultList = query.getResultList();

        for (Product product : resultList) {
            System.out.println(product.getId() + " : " + product.getName());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void criteriaParameter() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
        Root<Product> root = criteria.from(Product.class);
        Join<Product, Brand> brand = root.join("brand");

        ParameterExpression<String> nameParameter = builder.parameter(String.class);

        criteria.select(root);
        criteria.where(builder.equal(brand.get("name"), nameParameter));

        TypedQuery<Product> query = entityManager.createQuery(criteria);
        query.setParameter(nameParameter, "samsung");
        List<Product> resultList = query.getResultList();

        for (Product product : resultList) {
            System.out.println(product.getId() + " : " + product.getName());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void criteriaAggregateQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        Root<Product> p = criteria.from(Product.class);
        Join<Product, Brand> brand = p.join("brand");

        criteria.select(builder.array(
            brand.get("id"), builder.min(p.get("price")),
                builder.max(p.get("price")), builder.avg(p.get("price"))
        ));

        criteria.groupBy(p.get("id"));
        criteria.having(builder.greaterThan(builder.min(p.get("price")), 500_000));

        TypedQuery<Object[]> query = entityManager.createQuery(criteria);
        List<Object[]> resultList = query.getResultList();

        for (Object[] objects : resultList) {
            System.out.println("Brand : " + objects[0]);
            System.out.println("MIN : " + objects[1]);
            System.out.println("MAX : " + objects[2]);
            System.out.println("Average : " + objects[3]);
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void criteriaNonQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Brand> criteriaUpdate = builder.createCriteriaUpdate(Brand.class);
        Root<Brand> root = criteriaUpdate.from(Brand.class);

        criteriaUpdate.set(root.get("name"), "Xiaomi Updated");
        criteriaUpdate.where(builder.equal(root.get("id"), "xiaomi"));

        Query query = entityManager.createQuery(criteriaUpdate);
        int impactRecords = query.executeUpdate();

        System.out.println("Success update " + impactRecords + " records");

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
