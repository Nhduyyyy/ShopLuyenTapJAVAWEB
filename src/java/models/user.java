/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;
import java.sql.Timestamp;

// @Entity
// @Table(name = "Users")
public class user {
    
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "UserID")
    private int userId;
    
    /**
     * Quan hệ nhiều-một với bảng Role.
     * Vì mỗi người dùng (User) thuộc về một vai trò (Role),
     * nên chúng ta ánh xạ trường RoleId trong cơ sở dữ liệu thành một đối tượng Role.
     */
    // @ManyToOne
    // @JoinColumn(name = "RoleId", nullable = false)
    private role role;
    
    // @Column(name = "Username", nullable = false, unique = true, length = 50)
    private String username;
    
    // @Column(name = "Password", nullable = false, length = 255)
    private String password;
    
    // @Column(name = "Email", nullable = false, unique = true, length = 100)
    private String email;
    
    // @Column(name = "FullName", nullable = false, length = 100)
    private String fullName;
    
    // @Column(name = "PhoneNumber", length = 20)
    private String phoneNumber;
    
    // @Column(name = "Avatar", length = 255)
    private String avatar;
    
    // @Column(name = "Score")
    private int score = 0; // Mặc định là 0
    
    // @Column(name = "Sex", length = 10)
    private String sex;
    
    /**
    * Trường 'locked' được ánh xạ từ cột 'Locked' trong cơ sở dữ liệu.
    * Kiểu BIT trong SQL được ánh xạ thành kiểu boolean trong Java.
    * Giá trị mặc định của trường này là false (tương đương với 0 trong cơ sở dữ liệu),
    * điều này có nghĩa là khi một đối tượng mới được tạo ra, nếu không có giá trị nào được thiết lập, 
    * nó sẽ được coi là chưa bị khóa.
    */
   // @Column(name = "Locked", nullable = false, columnDefinition = "BIT DEFAULT 0")
    private boolean locked = false;
       
    // Sử dụng java.util.Date:
    // - Lưu trữ thời gian với độ chính xác đến mili giây.
    // - Phù hợp cho các tác vụ xử lý thời gian chung mà không cần độ chính xác cực cao.
    // @Column(name = "BirthDate")
    private Date birthDate;
    
    // Sử dụng java.sql.Timestamp:
    // - Là lớp con của java.util.Date.
    // - Hỗ trợ độ chính xác cao (đến nano giây).
    // - Thường được dùng khi làm việc với cơ sở dữ liệu cần lưu trữ thời gian chính xác.
    // @Column(name = "CreatedAt")
    private Timestamp createdAt;
    
    // @Column(name = "UpdatedAt")
    private Timestamp updatedAt;
    
    // Định nghĩa cột trong SQL (SQL Server)
    // Tạo cột CreatedAt và UpdatedAt với kiểu dữ liệu DATETIME.
    // Dòng code: 
    //      CreatedAt DATETIME DEFAULT GETDATE(),
    //      UpdatedAt DATETIME DEFAULT GETDATE()
    // có nghĩa là:
    // 1. Kiểu dữ liệu DATETIME lưu trữ ngày và giờ.
    // 2. DEFAULT GETDATE() đặt giá trị mặc định cho cột là ngày giờ hiện tại.
    //    => Khi bạn INSERT bản ghi mới mà không chỉ định (Không cần ghi GETDATE() khi insert) 
    //     giá trị cho CreatedAt và UpdatedAt, SQL Server sẽ tự động gọi hàm GETDATE() 
    //     để lấy ngày giờ hiện tại và gán cho cột này.
    // 3. Bạn cũng có thể gõ câu lệnh "GETDATE()" trong khi insert vào giá trị 
    //    cho CreatedAt và UpdatedAt để nó tự lấy dữ liệu ngày giờ hiện tại cũng được
    
    // // Constructor không đối số 
    public user() {
    }

    public user(int userId, role role, String username, String password, String email, String fullName, 
            String phoneNumber, String avatar, String sex, Date birthDate, Timestamp createdAt, Timestamp updatedAt) {
        this.userId = userId;
        this.role = role;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.sex = sex;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
          
    // Constructor có tham số, ngoại trừ các trường tự động tạo (userId, createdAt, updatedAt)
    public user(role role, String username, String password, String email, String fullName,
                String phoneNumber, String avatar, int score, String sex, Date birthDate) {
        this.role = role;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.score = score;
        this.sex = sex;
        this.birthDate = birthDate;
        // createdAt và updatedAt thường được set tự động, ví dụ thông qua trigger hoặc trong logic dịch vụ.
    }
    
    // Getter và Setter
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public role getRole() {
        return role;
    }

    public void setRole(role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "user{" + "userId=" + userId + ", role=" + role + ", username=" + username + ", password=" + password + ", email=" + email + ", "
                + "fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", avatar=" + avatar + ", score=" + score + ", sex=" + sex + ", "
                + "locked=" + locked + ", birthDate=" + birthDate + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
}
