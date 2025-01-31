import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<Product1> products;

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product1 product) {
        this.products.add(product);
    }

    public double getTotalCost() {
        double total = 0;
        for(Product1 product: products){
            total += product.getPrice();
        }
        return total;
    }

    public List<Product1> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }
    @Override
    public String toString() {
        return "Заказ клиента " + customer.getName() + " включает в себя продукты: " + products + " cумма: " + getTotalCost();
    }

}