package ku.shop;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("a product (.+) with price (.+) exists and have (.+) pieces")
    public void a_product_with_price_exists_have_pieces(String name, double price, int quantity) {
        catalog.addProduct(name, price, quantity);
    }

    @When("I buy (.+) with quantity (.+)")
    public void i_buy_with_quantity(String name, int quantity) {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quantity);
    }

    @Then("Product (.+) left (.+) pieces")
    public void product_left_pieces(String name, int quantity) {
        Product prod = catalog.getProduct(name);
        assertEquals(quantity, prod.getQuantity());
    }

    @Then("total should be (.+)")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }



}

