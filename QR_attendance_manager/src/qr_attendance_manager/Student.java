package qr_attendance_manager;


public class Student {
    private String username;
    private String name;
    private String status;

    public Student(String username, String name, String status) {
        this.username = username;
        this.name = name;
        this.status = status;
    }

    // Getters & Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}