package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.OtherProduct;
import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
   	private Map<Product, Integer> products = new HashMap<Product, Integer>();
	private static int totalInvoiceNo = 0;
    private int number = 0;
    
	public Invoice() {
        this.number = totalInvoiceNo++;
    }
	
    public void addProduct(Product product) {
    	if (product == null) {
            throw new IllegalArgumentException();
        }
        if (products.containsKey(product)) {
            products.put(product, (products.get(product) + 1));
        } else {
            products.put(product, 1);
        }
    }
    public void addProduct(Product product, Integer quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException();
        }
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + quantity);
        } else {
        products.put(product, quantity);
        }
    }

    public BigDecimal getNetTotal() {
        BigDecimal totalNet = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalNet = totalNet.add(product.getPrice().multiply(quantity));
        }
        return totalNet;
    }

    public BigDecimal getTaxTotal() {
        return getGrossTotal().subtract(getNetTotal());
    }

    public BigDecimal getGrossTotal() {
        BigDecimal totalGross = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
        }
        return totalGross;
    }

	public int getNumber() {
		return this.number;
	}
	
	public String getProducts() {
		StringBuilder sb = new StringBuilder();
		sb.append("Invoice No.: " + this.number + "\n");
		for (Product product : products.keySet()) {
            sb.append(product.getName() + " " + product.getPrice() + " PLN"
                    + "     quantity: " + (products.get(product)));
        }
		sb.append("Amount of products: " + products.size());
		return sb.toString();
    }
	
	 public int getAmountofProducts() {
	        return products.size();
	    }
	
	public int getProductQuantity(Product product) {

        int quantity = 0;
        for (Product product1: products.keySet()) {
            quantity = products.get(product);
        }
        return quantity;
    }
	
}

