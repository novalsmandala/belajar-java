package programmer.zaman.now.data;

public enum Level {
    STANDARD("Level Standard"),
    PREMIUM("Level Premium"),
    VIP("Level VIP"); // titik koma jika dibawah masih ada method

    private String description;
    Level(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
