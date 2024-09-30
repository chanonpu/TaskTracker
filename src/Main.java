public class Main {
    public static void main(String[] args) {
        if (args.length <= 0)
            System.out.println("Please provide a command");
        else {
            String command = args[0];
            switch (command) {
                case "add":
                    if (args.length <= 1)
                        TaskManager.addTask(args[1]);
                    else
                        System.out.println("Please provide a description");
                    break;
                case "list":
                    if (args.length <= 1)
                        TaskManager.listTasks();
                    else {
                        String status = args[1].toUpperCase();
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
                    if (args.length <= 1 && isNumeric.checkNumeric(args[1]))
                        TaskManager.updateTask(Integer.parseInt(args[1]), TaskStatus.IN_PROGRESS);
                    else
                        System.out.println("Invalid id");
                    break;

                case "mark-done":
                    if (args.length <= 1 && isNumeric.checkNumeric(args[1]))
                        TaskManager.updateTask(Integer.parseInt(args[1]), TaskStatus.COMPLETED);
                    else
                        System.out.println("Invalid id");
                    break;

                case "delete":
                    if (args.length <= 1 && isNumeric.checkNumeric(args[1]))
                        TaskManager.deleteTask(Integer.parseInt(args[1]));
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
