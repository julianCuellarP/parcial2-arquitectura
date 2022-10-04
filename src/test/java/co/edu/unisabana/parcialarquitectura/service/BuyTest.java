package co.edu.unisabana.parcialarquitectura.service;
import co.edu.unisabana.parcialarquitectura.repository.Database;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
class BuyTest {


  private final Database save = new Database();
  private final Buy service = new Buy(save);


  @Test
  public void Given_buyerCode_equals_vendorCode_When_MakePurchase_Then_throw_Exception() {
    assertThrows(IllegalSaleException.class,()->service.MakePurchase(2, 2, "Books"),"No es permitido realizar la venta al mismo vendedor y comprador" );
  }

  @Test
  public void Given_result_equals_1_When_MakePurchase_Then_succes(){
  int result = save.SavePurchase(2, "Book");
  assertEquals(1,result);
  }
  @Test
  public void Given_buyerCode_equals_0_When_MakePurchase_Then_fail() {
    int result = save.SavePurchase(0, "Book");
    assertEquals(0,result);
  }
}