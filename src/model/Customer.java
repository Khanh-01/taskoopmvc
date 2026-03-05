package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  public enum CustomerLevel {
    REGULAR(0.00),
    SILVER(0.05),
    GOLD(0.10),
    PLATINUM(0.15);

    private final double discountRate;

    CustomerLevel(double rate) {
      this.discountRate = rate;
    }

    public double getDiscountRate() {
      return discountRate;
    }
  }

  private static final int THRESHOLD_SILVER = 2;
  private static final int THRESHOLD_GOLD = 5;
  private static final int THRESHOLD_PLATINUM = 10;

  private String id;
  private String name;
  private String phone;
  private String address;
  private double balance;

  private CustomerLevel level = CustomerLevel.REGULAR;
  private List<Vehicle> purchaseHistory = new ArrayList<>();
  private int totalPurchased = 0;

  public Customer(String id, String name, String phone, String address, double balance) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.address = address;
    this.balance = Math.max(0, balance);
  }

  public String getName() {
    return name;
  }

  public double getBalance() {
    return balance;
  }

  public CustomerLevel getLevel() {
    return level;
  }

  public boolean canAfford(double amount) {
    return balance >= amount;
  }

  public void deductBalance(double amount) {
    balance -= amount;
  }

  public void addPurchase(Vehicle vehicle) {
    purchaseHistory.add(vehicle);
    totalPurchased++;
    updateLevel();
  }

  private void updateLevel() {
    if (totalPurchased >= THRESHOLD_PLATINUM)
      level = CustomerLevel.PLATINUM;
    else if (totalPurchased >= THRESHOLD_GOLD)
      level = CustomerLevel.GOLD;
    else if (totalPurchased >= THRESHOLD_SILVER)
      level = CustomerLevel.SILVER;
    else
      level = CustomerLevel.REGULAR;
  }

  @Override
  public String toString() {
    return name + " | Số dư: " + String.format("%,.0f", balance) + " | Cấp độ: " + level;
  }
}
