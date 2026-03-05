package model;

public class MotorBike extends Vehicle {
  public MotorBike(String id, String brand, double basePrice, int year, int quantity) {
    super(id, brand, basePrice, year, quantity);
  }

  @Override
  public double getFinalPrice() {
    return basePrice * 1.15;
  }
}
