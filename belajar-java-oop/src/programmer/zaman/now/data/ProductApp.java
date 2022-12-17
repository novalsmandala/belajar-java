package programmer.zaman.now.data;

public class ProductApp {
    public static void main(String[] args) {
        Product product = new Product("Asus", 10_000_000);
        System.out.println(product.name);
        System.out.println(product.price);
        System.out.println(product);
        var product2 = new Product("Asus", 10_000_000);
        System.out.println(product.equals(product2));
        System.out.println(product.hashCode());
        System.out.println(product2.hashCode());
        System.out.println(product.hashCode() == product2.hashCode());
    }
}
