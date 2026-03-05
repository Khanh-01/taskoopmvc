package model;

public abstract class Vehicle {
  protected String id;
  protected String brand;
  protected double basePrice;
  protected int year;
  protected int quantity;

  public Vehicle(String id, String brand, double basePrice, int year, int quantity) {
    this.id = id;
    this.brand = brand;
    this.basePrice = basePrice;
    this.year = year;
    this.quantity = quantity;
  }

  public String getId() {
    return id;
  }

  public String getBrand() {
    return brand;
  }

  public double getBasePrice() {
    return basePrice;
  }

  public int getYear() {
    return year;
  }

  public int getQuantity() {
    return quantity;
  }

  public boolean isAvailable() {
    return quantity > 0;
  }

  public void sellOne() {
    if (quantity > 0) quantity--;
  }

  public abstract double getFinalPrice();

  public String getInfo() {
    return id + " - " + brand + " (" + year + ") - Giá: " + String.format("%,.0f", getFinalPrice()) + " VND - Tồn: " + quantity;
  }

  @Override
  public String toString() {
    return getInfo();
  }
}
