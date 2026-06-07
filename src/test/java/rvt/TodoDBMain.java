package rvt;

public class TodoDBMain {
    public static void main(String[] args) {
        TodoDB db = new TodoDB();

        db.add("do homework");
        db.add("learn SQL");
        db.add("go for a walk");

        System.out.println("All tasks:");
        db.findAll();

        System.out.println();
        db.removeById(2);

        System.out.println("After remove:");
        db.findAll();
    }
}