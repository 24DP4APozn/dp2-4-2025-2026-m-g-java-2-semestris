package rvt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrderHistoryMain {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("data/orders.csv");
        Scanner scanner = new Scanner(file);

        double totalSum = 0;

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");

            int orderId = Integer.valueOf(parts[0]);
            String customer = parts[1];
            String product = parts[2];
            int quantity = Integer.valueOf(parts[3]);
            double price = Double.valueOf(parts[4]);

            double orderSum = quantity * price;
            totalSum = totalSum + orderSum;

            System.out.printf(
                    "Pasūtījums #%d: %s pasūtīja %d x %s (%.2f EUR) -> Kopā: %.2f EUR%n",
                    orderId, customer, quantity, product, price, orderSum
            );
        }

        System.out.println();
        System.out.printf("Kopējā pasūtījumu summa: %.2f EUR%n", totalSum);

        scanner.close();
    }
}