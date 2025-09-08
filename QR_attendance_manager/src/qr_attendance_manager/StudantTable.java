
package qr_attendance_manager;

public class StudantTable {
  
    private String date;
    private String status;
    private String notes;

    public StudantTable(String date, String status, String notes) {
        this.date = date;
        this.status = status;
        this.notes = notes;
    }

    // Getters و Setters (مطلوبة للـ TableView)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

