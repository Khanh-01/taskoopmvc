package model;

public class Bike extends Vehicle {
  public Bike(String id, String brand, double basePrice, int year, int quantity) {
    super(id, brand, basePrice, year, quantity);
  }

  @Override
  public double getFinalPrice() {
    return basePrice;
  }
}
