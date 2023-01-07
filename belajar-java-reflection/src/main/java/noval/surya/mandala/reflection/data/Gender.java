package noval.surya.mandala.reflection.data;

public enum Gender {

    MALE("Male"),
    FEMALE("Female");

    private String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
