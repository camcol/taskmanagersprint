public class ToDoListManager {
    private static final int MAX_USERS = 100;
    private User[] users;
    private int userCount;

    public ToDoListManager() {
        users = new User[MAX_USERS];
        userCount = 0;
    }

    public void addUser(String name) {
        if (userCount < MAX_USERS) {
            users[userCount++] = new User(name);
        } else {
            System.out.println("User limit reached. Cannot add more users.");
        }
    }

    public User getUser(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equals(name)) {
                return users[i];
            }
        }
        System.out.println("User not found: " + name);
        return null;
    }

    public static void main(String[] args) {
        ToDoListManager manager = new ToDoListManager();

        // Create users
        manager.addUser("Alice");
        manager.addUser("Bob");

        // Add tasks to users
        User alice = manager.getUser("Alice");
        if (alice != null) {
            alice.addTask("Buy groceries");
            alice.addTask("Complete assignment");
        }

        User bob = manager.getUser("Bob");
        if (bob != null) {
            bob.addTask("Walk the dog");
            bob.addTask("Read a book");
        }

        // Mark tasks as completed
        if (alice != null) {
            alice.markTaskAsCompleted("Buy groceries");
        }

        if (bob != null) {
            bob.markTaskAsCompleted("Read a book");
        }

        // Print all tasks for each user
        if (alice != null) {
            alice.printTasks();
        }

        if (bob != null) {
            bob.printTasks();
        }
    }
}
