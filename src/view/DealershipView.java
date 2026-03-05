package view;

import controller.DealershipController;
import model.*;
import exception.*;

import java.util.List;
import java.util.Scanner;

public class DealershipView {

  private final DealershipController controller;
  private final Dealership dealership;
  private final Scanner sc = new Scanner(System.in);

  public DealershipView(DealershipController controller, Dealership dealership) {
    this.controller = controller;
    this.dealership = dealership;
  }

  public void start() {
    int choice;

    do {
      System.out.println(" MENU QUẢN LÝ ĐẠI LÝ ");
      System.out.println("1. Thêm phương tiện");
      System.out.println("2. Xem kho hàng");
      System.out.println("3. Thêm khách hàng");
      System.out.println("4. Xem danh sách khách hàng");
      System.out.println("5. Mua xe");
      System.out.println("6. Xem tổng doanh thu");
      System.out.println("7. Thoát");
      System.out.print("Chọn chức năng: ");

      choice = sc.nextInt();
      sc.nextLine();

      try {
        switch (choice) {

          case 1:
            addVehicle();
            break;

          case 2:
            showInventory();
            break;

          case 3:
            addCustomer();
            break;

          case 4:
            showCustomers();
            break;

          case 5:
            buyVehicle();
            break;

          case 6:
            System.out.printf("Tổng doanh thu hiện tại: %,.0f VND%n", dealership.getTotalRevenue());
            break;

          case 7:
            System.out.println("Đã thoát chương trình!");
            break;

          default:
            System.out.println("INVALID");
        }

      } catch (BaseException e) {
        System.out.println("LỖI: " + e.getMessage());
      }

    } while (choice != 7);
  }

  private void addVehicle() {
    System.out.println("1.Car 2.Motor 3.Bike");
    int type = sc.nextInt();
    sc.nextLine();

    System.out.print("ID: ");
    String id = sc.nextLine();
    System.out.print("Hãng: ");
    String brand = sc.nextLine();
    System.out.print("Giá: ");
    double price = sc.nextDouble();
    System.out.print("Năm: ");
    int year = sc.nextInt();
    System.out.print("SL: ");
    int quantity = sc.nextInt(); sc.nextLine();

    Vehicle vehicle = switch (type) {
      case 1 -> new Car(id, brand, price, year, quantity);
      case 2 -> new MotorBike(id, brand, price, year, quantity);
      case 3 -> new Bike(id, brand, price, year, quantity);
      default -> throw new InvalidInputException("Loại xe sai");
    };

    controller.addVehicle(vehicle);
  }

  private void addCustomer() {
    System.out.print("Tên: ");
    String name = sc.nextLine();
    System.out.print("Số dư: ");
    double b = sc.nextDouble();
    sc.nextLine();

    controller.addCustomer(new Customer("C" + (dealership.getCustomers().size() + 1), name, "", "", b));
  }

  private void showInventory() {
    for (Vehicle vehicle : dealership.getInventory())
      System.out.println(vehicle.getInfo());
  }

  private void showCustomers() {
    for (int i = 0; i < dealership.getCustomers().size(); i++)
      System.out.println((i + 1) + ". " + dealership.getCustomers().get(i));
  }

  private void buyVehicle() {
    showCustomers();
    int customerIndext = sc.nextInt() - 1;
    showInventory();
    int vehicleIndext = sc.nextInt() - 1;
    sc.nextLine();

    controller.buyVehicle(dealership.getCustomers().get(customerIndext), dealership.getInventory().get(vehicleIndext));
  }
}
