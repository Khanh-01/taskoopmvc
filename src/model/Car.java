package model;

public class Car extends Vehicle {
  private static final double VAT = 0.10;
  private static final double SPECIAL_TAX = 0.50;

  public Car(String id, String brand, double basePrice, int year, int quantity) {
    super(id, brand, basePrice, year, quantity);
  }

  @Override
  public double getFinalPrice() {
    return basePrice * (1 + VAT + SPECIAL_TAX);
  }
}
