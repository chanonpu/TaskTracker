import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();
        if (input.length <= 0)
            System.out.println("Please provide a command");
        else {
            String command = input[0];
            switch (command) {
                case "add":
                    if (input.length >= 1)
                        TaskManager.addTask(input[1]);
                    else
                        System.out.println("Please provide a description");
                    break;
                case "list":
                    if (input.length <= 1)
                        TaskManager.listTasks();
                    else {
                        String status = input[1].toUpperCase();
                        switch (status) {
                            case "TODO":
                                TaskManager.listStatusTask(TaskStatus.TODO);
                                break;
                            case "IN_PROGRESS":
                            case "IN-PROGRESS":
                                TaskManager.listStatusTask(TaskStatus.IN_PROGRESS);
                                break;
                            case "COMPLETED":
                                TaskManager.listStatusTask(TaskStatus.COMPLETED);
                                break;
                            default:
                                System.out.println("Invalid status");
                                break;
                        }
                    }
                    break;
                case "mark-inprogress":
                    if (input.length <= 1 && isNumeric.checkNumeric(input[1]))
                        TaskManager.updateTask(Integer.parseInt(input[1]), TaskStatus.IN_PROGRESS);
                    else
                        System.out.println("Invalid id");
                    break;

                case "mark-done":
                    if (input.length <= 1 && isNumeric.checkNumeric(input[1]))
                        TaskManager.updateTask(Integer.parseInt(input[1]), TaskStatus.COMPLETED);
                    else
                        System.out.println("Invalid id");
                    break;

                case "delete":
                    if (input.length <= 1 && isNumeric.checkNumeric(input[1]))
                        TaskManager.deleteTask(Integer.parseInt(input[1]));
                    else
                        System.out.println("Invalid id");
                    break;
                    
                default:
                    System.out.println("Unknown Command");
                    break;
            }
        }
    }
}
