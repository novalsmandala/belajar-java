package noval.mandala.database.repository;

import noval.mandala.database.ConnectionUtil;
import noval.mandala.database.entity.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository {

    @Override
    public void insert(Comment comment) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()) {

            String sql = "INSERT INTO comment(email, comment) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);) {

                preparedStatement.setString(1, comment.getEmail());
                preparedStatement.setString(2, comment.getComment());

                preparedStatement.executeUpdate();

                try (ResultSet resultSetId = preparedStatement.getGeneratedKeys()) {
                    if (resultSetId.next()) {
                        comment.setId(resultSetId.getInt(1));
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Comment findById(Integer id) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()) {

            String sql = "SELECT * FROM comment WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()){
                    if (resultSet.next()) {
                        return new Comment(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("comment")
                        );
                    } else {
                        return null;
                    }
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Comment> findAll() {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "SELECT * FROM comment";

            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)){
                    List<Comment> commentList = new ArrayList<>();
                    while (resultSet.next()) {
                        commentList.add(new Comment(
                           resultSet.getInt("id"),
                           resultSet.getString("email"),
                           resultSet.getString("comment")
                        ));
                    }
                    return commentList;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Comment> findAllByEmail(String email) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "SELECT * FROM comment WHERE email = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, email);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    List<Comment> commentList = new ArrayList<>();
                     while (resultSet.next()) {
                         commentList.add(new Comment(
                                 resultSet.getInt("id"),
                                 resultSet.getString("email"),
                                 resultSet.getString("comment")
                         ));
                     }
                     return commentList;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
