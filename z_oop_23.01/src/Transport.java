abstract class Transport {
    abstract void move();
}

class Car extends Transport {
    void move() {
        System.out.println("Машина едет");
    }
}

class Bike extends Transport {
    void move() {
        System.out.println("Велосипед едет");
    }
}