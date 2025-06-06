package com.example;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        boolean found = false;
        for (Product p : products) {
            if (p.getCode().equals(product.getCode())) {
                p.quantity += product.getQuantity();
                p.price = product.getPrice();  // Шинэ үнэ оруулж болно, эсвэл бусад арга
                found = true;
                break;
            }
        }
        if (!found) {
            products.add(product);
        }
        System.out.println("Амжилттай нэмлээ.");
    }    

    public boolean getProduct(Product product) {
        String code = product.getCode();
        double quantity = product.getQuantity();
    
        for (Product p : products) {
            if (p.code.equals(code)) {
                if (p.quantity >= quantity) {
                    p.quantity -= quantity;
                    System.out.printf("%s кодтой %.1f ширхэг %s бараа нөөцөөс хасагдлаа.\n",
                            p.code, quantity, p.productName);
                    return true;  // Амжилттай авсан
                } else {
                    System.out.println("Хангалттай тоо ширхэг байхгүй байна.");
                    return false;
                }
            }
        }
    
        System.out.println("Бараа олдсонгүй.");
        return false;
    }    

    public void listInventory() {
        System.out.println("\nНөөцийн жагсаалт:");
        for (Product p : products) {
            System.out.printf("- %s (%s): %.1f ширхэг, үнэ: %.2f төгрөг, нэмсэн: %s\n", p.productName, p.code, p.quantity, p.price, p.fromName);        
        }
    }
}
