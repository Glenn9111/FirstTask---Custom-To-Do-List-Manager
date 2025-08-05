# FirstTask---Custom-To-Do-List-Manager
Test Subject


import java.util.Scanner;

public class ToDoManager {

    // Node class
    static class TaskNode {
        String title;
        TaskNode next;

        public TaskNode(String title) {
            this.title = title;
            this.next = null;
        }
    }

    // Linked List class
    static class ToDoList {
        private TaskNode head;

        public void addTask(String title) {
            TaskNode newNode = new TaskNode(title);
            if (head == null) {
                head = newNode;
            } else {
                TaskNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            System.out.println("Task added!");
        }

        public void deleteTask(String title) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            if (head.title.equals(title)) {
                head = head.next;
                System.out.println("Task deleted!");
                return;
            }

            TaskNode current = head;
            while (current.next != null && !current.next.title.equals(title)) {
                current = current.next;
            }

            if (current.next == null) {
                System.out.println("Task not found.");
            } else {
                current.next = current.next.next;
                System.out.println("Task deleted!");
            }
        }

        public void printTasks() {
            if (head == null) {
                System.out.println("No tasks found.");
                return;
            }

            System.out.println("Your Tasks:");
            TaskNode current = head;
            while (current != null) {
                System.out.println("- " + current.title);
                current = current.next;
            }
        }

        public boolean contains(String title) {
            TaskNode current = head;
            while (current != null) {
                if (current.title.equals(title)) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }

    // Main logic with menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList list = new ToDoList();
        int choice;

        do {
            System.out.println("\n1. Add task");
            System.out.println("2. Delete task");
            System.out.println("3. View all tasks");
            System.out.println("4. Search task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String title;
            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    title = scanner.nextLine();
                    list.addTask(title);
                    break;
                case 2:
                    System.out.print("Enter task title to delete: ");
                    title = scanner.nextLine();
                    list.deleteTask(title);
                    break;
                case 3:
                    list.printTasks();
                    break;
                case 4:
                    System.out.print("Enter task title to search: ");
                    title = scanner.nextLine();
                    if (list.contains(title)) {
                        System.out.println("Task found!");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
