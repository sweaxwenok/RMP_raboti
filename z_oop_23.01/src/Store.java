import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products;

    public Store(){
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(String name){
        products.removeIf(product -> product.getName().equalsIgnoreCase(name));
    }

    public List<Product> findProduct(String name){
        List<Product> foundProducts = new ArrayList<>();
        for(Product product: products){
            if(product.getName().equalsIgnoreCase(name)){
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public void displayAllProducts(){
        for(Product product: products){
            System.out.println(product.toString());
        }
    }
}