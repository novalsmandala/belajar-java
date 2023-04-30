package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.Category;
import programmerzamannow.jpa.entity.Image;
import programmerzamannow.jpa.util.JpaUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Calendar;

public class LargeObjectTest {

    @Test
    void largeObject() throws IOException {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Image image = new Image();
        image.setName("Apple Wallpaper");
        image.setDescription("Desc Apple Wallpaper");
        Path path = new File(getClass().getResource("/images/image.jpg").getFile()).toPath();
        byte[] bytes = Files.readAllBytes(path);
        image.setImage(bytes);

        entityManager.persist(image);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void createFileImage() throws IOException {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Image image = entityManager.find(Image.class, "1");
        byte[] result = image.getImage();

        Path path = Path.of("output.jpg");
        try (OutputStream outputStream = Files.newOutputStream(path)) {
            outputStream.write(result);
            Assertions.assertTrue(Files.exists(path));
        } catch (IOException e) {
            Assertions.fail(e);
        }

        entityManager.close();
        entityManagerFactory.close();
    }

}
