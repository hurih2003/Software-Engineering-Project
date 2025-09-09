USE qr_attendance;

CREATE TABLE Attendance (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    student_id VARCHAR(50) NOT NULL,
    scan_time DATETIME DEFAULT GETDATE()
);