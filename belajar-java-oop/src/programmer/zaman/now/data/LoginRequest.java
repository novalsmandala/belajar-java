package programmer.zaman.now.data;

public record LoginRequest(String username, String password) implements HelloWorld{
    public LoginRequest{
        System.out.println("Membuat object login request");
    }

    public LoginRequest(String username){
        this(username, null);
    }

    public LoginRequest(){
        this(null, null);
    }

    @Override
    public void sayHello() {

    }

    @Override
    public void sayHello(String name) {

    }

}
