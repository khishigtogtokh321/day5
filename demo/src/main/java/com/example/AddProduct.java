package com.example;
import java.util.Scanner;
public class AddProduct {
    public Product addProduct() {
        Scanner read = new Scanner(System.in);

        System.out.print("Нэмж буй хүний нэр: ");
        String fName = read.nextLine();
        if (fName.trim().isEmpty()) {
            throw new IllegalArgumentException("Хэрэглэгчийн нэр хоосон байж болохгүй.");
        }

        System.out.print("Барааны нэр: ");
        String pName = read.nextLine();
        if (pName.trim().isEmpty()) {
            throw new IllegalArgumentException("Барааны нэр хоосон байж болохгүй.");
        }

        System.out.print("Барааны код: "); //a12
        String code = read.nextLine();
        if (code.trim().isEmpty()) {
            throw new IllegalArgumentException("Барааны код хоосон байж болохгүй.");
        }

        if (code.length() == 3) {
            char firstChar = code.charAt(0);
            char secondChar = code.charAt(1);
            char thirdChar = code.charAt(2);
            if(!Character.isLetter(firstChar) && Character.isDigit(secondChar) && Character.isDigit(thirdChar)){
                throw new IllegalArgumentException("Барааны код буруу байна.");
            }
        }
        else {
            throw new IllegalArgumentException("Барааны код буруу байна.");
        }

        System.out.print("Тоо ширхэг: "); //max = 50
        double quantity = read.nextDouble();
        if (quantity < 0) {
            throw new IllegalArgumentException("Тоо ширхэг сөрөг байж болохгүй.");
        }
        double MAX = 50.0;
        if (quantity > MAX) {
            throw new IllegalArgumentException("Тоо ширхэг хэтэрсэн.");
        }


        System.out.print("Барааны үнэ: ");
        double price = read.nextDouble();
        if (price < 0) {
            throw new IllegalArgumentException("Үнэ сөрөг байж болохгүй.");
        }

        return new Product(fName, pName, code, quantity, price);
    }
}
