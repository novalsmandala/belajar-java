package noval.mandala.database.entity;

public class Comment {

    private Integer Id;

    private String email;

    private String comment;

    public Comment() {
    }

    public Comment(String email, String comment) {
        this.email = email;
        this.comment = comment;
    }

    public Comment(Integer id, String email, String comment) {
        Id = id;
        this.email = email;
        this.comment = comment;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
