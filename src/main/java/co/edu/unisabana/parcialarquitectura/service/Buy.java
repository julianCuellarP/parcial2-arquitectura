package co.edu.unisabana.parcialarquitectura.service;
import co.edu.unisabana.parcialarquitectura.repository.Database;

public class Buy implements Purchase{

  private Database database;

  public Buy(Database database) {
    this.database = database;
  }
  @Override
  public String MakePurchase(int vendorCode, int buyerCode, String item) {
    int result = database.SavePurchase(buyerCode, item);
    if (buyerCode == vendorCode) {
      throw new IllegalSaleException(vendorCode, buyerCode);
    }
    if (result == 1) {
      return "Product sold";
    } else {
      return "The sale was not possible";
    }
  }
}
