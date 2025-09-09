Use QrAttendence
CREATE TABLE Users (
    user_id INT PRIMARY KEY IDENTITY(1,1),
    full_name NVARCHAR(100) NOT NULL,
    qr_code NVARCHAR(255) UNIQUE NOT NULL
); 
CREATE TABLE Students (
    student_id INT PRIMARY KEY, 
    class NVARCHAR(50) NOT NULL,
    guardian_name NVARCHAR(100) NOT NULL,
    guardian_phone NVARCHAR(20) NOT NULL,
    qr_code NVARCHAR(255) UNIQUE NOT NULL,
    FOREIGN KEY (student_id) REFERENCES Users(user_id) ON DELETE CASCADE,
);
CREATE TABLE Teachers (
    teacher_id INT PRIMARY KEY,
    subject NVARCHAR(50),
    FOREIGN KEY (teacher_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
CREATE TABLE Admins (
    admin_id INT PRIMARY KEY,
    role NVARCHAR(50) CHECK (role IN ('Principal','Admin')),
    FOREIGN KEY (admin_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
CREATE TABLE Attendance (
    attendance_id INT PRIMARY KEY IDENTITY(1,1),
    user_id INT NOT NULL,
    date DATE NOT NULL,
    status NVARCHAR(10) CHECK (status IN ('Present','Absent')),
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
CREATE TABLE LoginAccounts (
    account_id INT PRIMARY KEY IDENTITY(1,1),
    user_id INT NOT NULL UNIQUE,
    username NVARCHAR(100) UNIQUE NOT NULL,
    password_hash NVARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
CREATE TABLE Warnings (
    warning_id INT IDENTITY(1,1) PRIMARY KEY,
    student_id INT FOREIGN KEY REFERENCES Students(student_id),
    warning_date DATETIME DEFAULT GETDATE(),
    reason NVARCHAR(255)
);
CREATE TABLE Guardians (
    guardian_id INT PRIMARY KEY IDENTITY(1,1),
    student_id INT NOT NULL,
    guardian_name NVARCHAR(100) NOT NULL,
    guardian_phone NVARCHAR(20) NOT NULL,
    relationship NVARCHAR(50) NULL,
    FOREIGN KEY (student_id) REFERENCES Students(student_id) ON DELETE CASCADE
);

 
