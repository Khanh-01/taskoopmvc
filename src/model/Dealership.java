package model;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
  private String name;
  private List<Vehicle> inventory = new ArrayList<>();
  private List<Customer> customers = new ArrayList<>();
  private double totalRevenue;

  public Dealership(String name) {
    this.name = name;
  }

  public List<Vehicle> getInventory() {
    return inventory;
  }

  public List<Customer> getCustomers() {
    return customers;
  }

  public double getTotalRevenue() {
    return totalRevenue;
  }

  public void addRevenue(double amount) {
    totalRevenue += amount;
  }
}
