package ru.pravvich.start;

import ru.pravvich.models.*;

/**
 * @since Pavel Ravvich
 * @since 04.11.2016
 * @see #add() addition task
 * @see #updateItem() replace task on new
 * @see #findByHeader()
 * @see #findById()
 * @see #deleteTask()
 * @see #addCommit()
 * @see #editionCommit()
 * @see #viewAllTasks()
 */
public class StartUI {
    private Input input;
    private Tracker tracker = new Tracker();

    public StartUI(Input input) {
        this.input = input;
    }

    public void editionCommit() {
        String oldCommit = input.ask("Enter old commit for edit");
        String newCommit = input.ask("Enter new commit");
        this.tracker.editionCommit(oldCommit, newCommit);
        System.out.println(this.tracker.getMessage());
        System.out.println("=========================================================");
    }

    public void addCommit() {
        int id = input.askInt("Enter ID task for commit.");
        String commit = input.ask("Enter commit for this task.");
        this.tracker.addCommit(this.tracker.findById(id), commit);
        System.out.println(this.tracker.getMessage());
        System.out.println("=========================================================");
    }

    // init new task
    public void add() {
        String header = this.input.ask("Please enter the task name");
        this.tracker.add(new Task(header));
        System.out.println(this.tracker.getMessage());
        System.out.println("=========================================================");
    }

    public void updateItem() {
        String header = this.input.ask("Enter new name for task.");
        int id = this.input.askInt("Enter task ID for replace");
        Item item = new Item(header, id);
        this.tracker.updateItem(item);
        System.out.println(tracker.getMessage());
        System.out.println("=========================================================");
    }

    public void findById () {
        int id = this.input.askInt("Enter ID number");
        Item item = this.tracker.findById(id);
        System.out.println(tracker.getMessage() +  ": " + item.getHeader());
        System.out.println("=========================================================");
    }

    public void findByHeader() {
        String header = this.input.ask("Enter task name for search.");
        this.tracker.findByHeader(header);
        System.out.println(tracker.getMessage());
        System.out.println("=========================================================");
    }

    public void deleteTask() {
        String header = this.input.ask("Please enter the task name for delete");
        int id = this.tracker.findByHeader(header).getId();
        Item itemForDelete = this.tracker.findById(id);
        this.tracker.delete(itemForDelete);
        System.out.println(tracker.getMessage());
        System.out.println("=========================================================");
    }

    public void viewAllTasks() {
        String answer = this.input.ask("View all tasks : view -a" + "\n" +
                "View all tasks with revers filter : view -f");
        if (answer.equals("view -a")) {
            Item[] print = this.tracker.getPrintArray();
            System.out.println(this.tracker.getMessage());
            for (Item item : print) {
                System.out.println(item.getHeader() + "  ID: " + item.getId());
            }
            System.out.println("=========================================================");
        } else if (answer.equals("view -f")) {
            Item[] print = this.tracker.getArrPrintFilter();
            System.out.println(this.tracker.getMessage());
            for (Item item : print) {
                System.out.println(item.getHeader() + "  ID: " + item.getId());
            }
            System.out.println("=========================================================");
        } else {
            System.out.println("Error: command not found");
            System.out.println("=========================================================");
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        StartUI startUI = new StartUI(input);
        startUI.add();
        startUI.viewAllTasks();
        startUI.addCommit();
        //startUI.editionCommit();
        //startUI.updateItem();
        //startUI.findById();
        //startUI.findByHeader();
        //startUI.deleteTask();
    }
}
