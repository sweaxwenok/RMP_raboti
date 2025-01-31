public class Laptop extends Device {
    public Laptop(String brand) {
        super(brand);
    }

    public void opensSettings(){
        System.out.println("Ноутбук " + brand + " открыл приложение настроек.");
    }
}