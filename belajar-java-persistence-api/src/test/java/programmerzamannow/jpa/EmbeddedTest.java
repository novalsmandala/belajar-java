package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.Department;
import programmerzamannow.jpa.entity.DepartmentId;
import programmerzamannow.jpa.entity.Member;
import programmerzamannow.jpa.entity.Name;
import programmerzamannow.jpa.util.JpaUtil;

public class EmbeddedTest {

    @Test
    void embedded() {

        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Name name = new Name();
        name.setTitle("Mr");
        name.setFirstName("Noval");
        name.setMiddleName("Surya");
        name.setLastName("Mandala");

        Member member = new Member();
        member.setEmail("noval@example.con");
        member.setName(name);

        entityManager.persist(member);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void embeddedId() {

        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        DepartmentId departmentId = new DepartmentId();
        departmentId.setCompanyId("pzn");
        departmentId.setDepartmentId("tech");

        Department department = new Department();
        department.setName("Teknologu");
        department.setDepartmentId(departmentId);

        entityManager.persist(department);

        Department resultDepartment = entityManager.find(Department.class, departmentId);
        Assertions.assertEquals(department.getName(), resultDepartment.getName());

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
