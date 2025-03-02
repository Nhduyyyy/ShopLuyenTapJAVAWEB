/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

// @Entity
// @Table(name = "Roles")
public class role {
    
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "RoleID")
    private int roleId;
    
    // @Column(name = "RoleName", nullable = false, unique = true, length = 50)
    private String roleName;
    
    // @Column(name = "Description", length = 255)
    private String description;
    
    // Constructor không đối số 
    public role() {
    }
    
    // Constructor đầy đủ tham số
    public role(int roleId, String roleName, String description) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.description = description;
    }
    
    /**
    * Constructor có tham số cho lớp Role.
    * 
    * Mục đích của constructor này là khởi tạo một đối tượng Role mới bằng cách thiết lập 
    * các thuộc tính roleName và description ngay khi đối tượng được tạo ra.
    *
    * Lý do không cần truyền roleID vào constructor này là:
    * - roleID được sinh tự động bởi cơ sở dữ liệu (nhờ cột IDENTITY) hoặc bởi framework ORM như JPA/Hibernate.
    * - Khi lưu đối tượng vào cơ sở dữ liệu, roleID sẽ được tự động tạo và gán.
    * - Do đó, không cần thiết phải khởi tạo roleID thủ công khi tạo mới đối tượng Role.
    *
    * @param roleName    tên của vai trò, không được null và phải là duy nhất
    * @param description mô tả của vai trò, có thể null nếu không cần thiết
    */
    public role(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }
    
     // Getter và Setter
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "role{" + "roleId=" + roleId + ", roleName=" + roleName + ", description=" + description + '}';
    }
    
    
}
