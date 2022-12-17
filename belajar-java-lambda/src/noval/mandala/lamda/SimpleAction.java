package noval.mandala.lamda;

// menggunakan anotasi @FunctionalInterface
@FunctionalInterface
public interface SimpleAction {

    // wajib memiliki hanya 1 method

    // tanpa parameter
    // String action();

    // dengan parameter
    String action(String name);
}
