package controller;

import model.*;
import service.DealershipService;

import java.util.List;

public class DealershipController {

  private final DealershipService service;

  public DealershipController(DealershipService service) {
    this.service = service;
  }

  public void addVehicle(Vehicle vehicle) {
    service.addVehicle(vehicle);
  }

  public void addCustomer(Customer customer) {
    service.addCustomer(customer);
  }

  public void buyVehicle(Customer customer, Vehicle vehicle) {
    service.sellVehicle(customer, vehicle);
  }

  public List<Vehicle> suggest(Vehicle vehicle, int max) {
    return service.suggestAlternatives(vehicle, max);
  }
}

