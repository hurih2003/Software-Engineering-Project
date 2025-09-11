Use QrAttendence2
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

 CREATE TABLE Classes (
    class_id INT PRIMARY KEY IDENTITY(1,1),
    class_name NVARCHAR(50) NOT NULL UNIQUE,   -- e.g., "Grade 5 - A"
    section NVARCHAR(20) NULL,                -- optional, if you want sections
    teacher_id INT NULL,                      -- optional homeroom/class teacher
    FOREIGN KEY (teacher_id) REFERENCES Teachers(teacher_id) ON DELETE SET NULL
);
ALTER TABLE Students
DROP COLUMN class;  

ALTER TABLE Students
ADD class_id INT FOREIGN KEY REFERENCES Classes(class_id) ON DELETE SET NULL;

ALTER TABLE Teachers
ADD status NVARCHAR(10) CHECK (status IN ('Present','Absent')) DEFAULT 'Present';

ALTER TABLE Students
ADD warnings INT DEFAULT 0;

ALTER TABLE Students
ADD warnings INT DEFAULT 0;
---------------------------------- manageAccounts: 
CREATE TABLE ManageAccounts (
    account_id INT PRIMARY KEY IDENTITY(1,1),
    user_id INT NOT NULL,
    username VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,

    CONSTRAINT FK_ManageAccounts_User FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
ALTER TABLE Users
ADD username VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL;



