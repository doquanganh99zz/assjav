/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Student;
import java.util.List;

/**
 *
 * @author PC
 */
public interface StudentManagerService {
    public void addNewStudent(String maSv, String hoTen, String email, String sdt, String gioiTinh, String diaChi, String avatarPath);
    public void updateStudent(int index,Student s);
    public void removeStudent(int index);
    public List<Student> getList();
}
