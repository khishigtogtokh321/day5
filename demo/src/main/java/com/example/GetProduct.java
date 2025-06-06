package com.example;
import java.util.Scanner;
public class GetProduct {
   public Product getProduct() {
        Scanner read = new Scanner(System.in);

        System.out.print("Авж буй хүний нэр: ");
        String fName = read.nextLine();
        if (fName.trim().isEmpty()) {
            throw new IllegalArgumentException("Хэрэглэгчийн нэр хоосон байж болохгүй.");
        }

        System.out.print("Барааны нэр: ");
        String pName = read.nextLine();
        if (pName.trim().isEmpty()) {
            throw new IllegalArgumentException("Барааны нэр хоосон байж болохгүй.");
        }

        System.out.print("Барааны код: ");
        String code = read.nextLine();
        if (code.trim().isEmpty()) {
            throw new IllegalArgumentException("Барааны код хоосон байж болохгүй.");
        }

        System.out.print("Тоо ширхэг: ");
        double quantity = read.nextDouble();
        if (quantity < 0) {
            throw new IllegalArgumentException("Тоо ширхэг сөрөг байж болохгүй.");
        }

        System.out.print("Барааны үнэ: ");
        double price = read.nextDouble();
        if (price < 0) {
            throw new IllegalArgumentException("Үнэ сөрөг байж болохгүй.");
        }

        return new Product(fName, pName, code, quantity, price);
    }
}
