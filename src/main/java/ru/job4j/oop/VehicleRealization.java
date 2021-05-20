package ru.job4j.oop;

public class VehicleRealization {
    public static void main(String[] args) {
        Vehicle icarus = new Bus("Икарус", 100);
        Vehicle paz = new Bus("ПАЗ", 42);
        Vehicle gazelle = new Bus("Газель", 18);
        Vehicle freightTrain = new Train("Грузовой поезд", 0);
        Vehicle passengerTrain = new Train("Пассажирский поезд", 818);
        Vehicle boeing = new Plane("Боинг", 452);
        Vehicle tu154 = new Plane("ТУ-154", 180);
        Vehicle sessna = new Plane("Сессна", 2);
        Vehicle[] vehicles = new Vehicle[] {icarus, paz, gazelle,
                freightTrain, passengerTrain,
                boeing, tu154, sessna};
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getName());
            vehicle.move();
            vehicle.capacity();
            System.out.println("==========");
        }
    }
}
