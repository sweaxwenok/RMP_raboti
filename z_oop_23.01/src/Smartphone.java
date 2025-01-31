public class Smartphone extends Device {
    public Smartphone(String brand) {
        super(brand);
    }

    public void takePhoto() {
        System.out.println("Телефон " + brand + " сделал фотографию.");
    }
}