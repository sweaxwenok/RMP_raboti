public class Device {
    String brand;

    public Device(String brand) {
        this.brand = brand;
    }

    public void turnOn() {
        System.out.println(brand + " включен.");
    }

    public void turnOff() {
        System.out.println(brand + " выключен.");
    }
}