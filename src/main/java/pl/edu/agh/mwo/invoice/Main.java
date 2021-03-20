package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import pl.edu.agh.mwo.invoice.product.OtherProduct;

public class Main {

	public static void main(String[] args) {
        Invoice firstInvoice = new Invoice();
        firstInvoice.addProduct(new OtherProduct("product_1", new BigDecimal("11.11")), 1);
        firstInvoice.addProduct(new OtherProduct("product_2", new BigDecimal("11.22")), 1);

        Invoice secondInv = new Invoice();
        secondInv.addProduct(new OtherProduct("duplication", new BigDecimal("1.11")), 1);
        secondInv.addProduct(new OtherProduct("duplication", new BigDecimal("1.11")), 1);
        secondInv.addProduct(new OtherProduct("notDupli", new BigDecimal("2.22")), 1);
        secondInv.addProduct(new OtherProduct("duplication", new BigDecimal("1.11")), 1);
    }

public static void printInv(Invoice invoice) {
    System.out.println("**************************************************************"
            + "*********");
    System.out.println("<<<< Invoice No. " + invoice.getNumber() + ">>>>");
    System.out.println("- Contents: ");
    invoice.getProducts();
    System.out.println("- Invoice summary: ");
    System.out.println("Gross total = " + invoice.getGrossTotal() + "PLN. Net total = "
            + invoice.getNetTotal() + "PLN. Tax total = " + invoice.getTaxTotal() + "PLN.");
    System.out.println("************************************************************"
            + "***********");
    System.out.println("");
}
}
