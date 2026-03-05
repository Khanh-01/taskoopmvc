import controller.DealershipController;
import model.Dealership;
import service.DealershipService;
import view.DealershipView;

public class Main {
  public static void main(String[] args) {
    Dealership dealership = new Dealership("Xe");
    DealershipService dealershipService = new DealershipService(dealership);
    DealershipController dealershipController = new DealershipController(dealershipService);
    DealershipView dealershipView = new DealershipView(dealershipController, dealership);
    dealershipView.start();
  }
}

