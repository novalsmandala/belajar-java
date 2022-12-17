public class MemanggilConstructorLain {
    String username;
    String address;

    MemanggilConstructorLain(String paramName, String address){
        this.username = paramName;
        this.address = address;
    }

    // memanggil constructor lain
    MemanggilConstructorLain(String paramName){
        // memanggil dari constructor atas
        this(paramName, null);
    }

    MemanggilConstructorLain(){
        this(null);
    }
}
