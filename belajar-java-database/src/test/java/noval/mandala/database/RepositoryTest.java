package noval.mandala.database;

import noval.mandala.database.entity.Comment;
import noval.mandala.database.repository.CommentRepository;
import noval.mandala.database.repository.CommentRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RepositoryTest {

    private CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
        commentRepository = new CommentRepositoryImpl();
    }

    @Test
    void testInsert() {

        Comment comment = new Comment("nov@email.com", "Hi my name is Noval");
        commentRepository.insert(comment);

        Assertions.assertNotNull(comment.getId());
        System.out.println(comment.getId());
    }

    @Test
    void testFindById() {
        Comment comment = commentRepository.findById(3218);

        Assertions.assertNotNull(comment);
        System.out.println(comment.getId());
        System.out.println(comment.getEmail());
        System.out.println(comment.getComment()); 

        Comment commentNotFound = commentRepository.findById(9999);
        Assertions.assertNull(commentNotFound);
    }

    @Test
    void testFindAll() {
        List<Comment> commentList = commentRepository.findAll();

        System.out.println(commentList.size());
    }

    @Test
    void testFindAllByEmail() {
        List<Comment> comments = commentRepository.findAllByEmail("nov@email.com");

        System.out.println(comments.size());
}
}
