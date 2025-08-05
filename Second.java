/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.secondtask;

/**
 *
 * @author PC
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Second {

    static class Customer {
        String name;
        int number;

        public Customer(String name, int number) {
            this.name = name;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Customer #" + number + " - " + name;
        }
    }

    public static void main(String[] args) {
        Queue<Customer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int customerNumber = 1;
        int choice;

        do {
            System.out.println("\n--- Bank Queue Menu ---");
            System.out.println("1. Add customer to queue");
            System.out.println("2. Serve next customer");
            System.out.println("3. View queue");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    Customer newCustomer = new Customer(name, customerNumber++);
                    queue.add(newCustomer);
                    System.out.println("Added: " + newCustomer);
                    displayQueue(queue);
                    break;

                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("No customers in queue.");
                    } else {
                        Customer served = queue.poll();
                        System.out.println("Serving: " + served);
                        displayQueue(queue);
                    }
                    break;

                case 3:
                    displayQueue(queue);
                    break;

                case 4:
                    System.out.println("Exiting. Have a nice day!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        scanner.close();
    }

    public static void displayQueue(Queue<Customer> queue) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Current queue:");
            for (Customer c : queue) {
                System.out.println("- " + c);
            }
        }
    }
}
