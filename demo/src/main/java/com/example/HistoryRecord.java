package com.example;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoryRecord {
    public enum ActionType { ADD, GET }
    
    private ActionType actionType;
    private LocalDateTime dateTime;
    private String userName;
    private String productName;
    private String productCode;
    private double quantity;

    // Статик жагсаалт түүхүүдийг хадгалах
    private static List<HistoryRecord> historyRecords = new ArrayList<>();

    public HistoryRecord(ActionType actionType, LocalDateTime dateTime, String userName,
                         String productName, String productCode, double quantity) {
        this.actionType = actionType;
        this.dateTime = dateTime;
        this.userName = userName;
        this.productName = productName;
        this.productCode = productCode;
        this.quantity = quantity;
    }
    public static List<HistoryRecord> getAllRecords() {
    return historyRecords;
}


    public static void addRecord(HistoryRecord record) {
        historyRecords.add(record);
    }

    public static void listHistory() {
        System.out.println("\nҮйлдлийн түүх:");
        for (HistoryRecord record : historyRecords) {
            System.out.println(record);
        }
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %s кодтой %s бараа %.1f ширхэг, хэрэглэгч: %s",
            dateTime, actionType == ActionType.ADD ? "Нэмсэн" : "Авсан", productCode, productName, quantity, userName);
    }
}