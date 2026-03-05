package service;

import model.*;
import exception.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipService {

  private final Dealership dealership;

  public DealershipService(Dealership dealership) {
    this.dealership = dealership;
  }

  public void addVehicle(Vehicle vehicle) {
    if (vehicle == null)
      throw new InvalidInputException("Vehicle null");
    dealership.getInventory().add(vehicle);
  }

  public void addCustomer(Customer customer) {
    dealership.getCustomers().add(customer);
  }

  public void sellVehicle(Customer customer, Vehicle vehicle) {
    if (!vehicle.isAvailable())
      throw new NegativeValueException("Xe đã hết hàng");

    double payAmount = vehicle.getFinalPrice() * (1 - customer.getLevel().getDiscountRate());

    if (!customer.canAfford(payAmount))
      throw new NegativeValueException("Khách không đủ tiền");

    customer.deductBalance(payAmount);
    customer.addPurchase(vehicle);
    vehicle.sellOne();
    dealership.addRevenue(payAmount);
  }

  public List<Vehicle> suggestAlternatives(Vehicle ref, int max) {
    List<Vehicle> result = new ArrayList<>();
    for (Vehicle vehicle : dealership.getInventory()) {
      if (vehicle != ref && vehicle.getClass() == ref.getClass() && vehicle.isAvailable()) {
        result.add(vehicle);
      }
      if (result.size() == max) {
        break;
      }
    }
    return result;
  }
}
