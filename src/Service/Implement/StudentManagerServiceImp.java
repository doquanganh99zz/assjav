/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import Model.Student;
import Resposive.Implement.ResposiveMethodImp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class StudentManagerServiceImp implements Service.StudentManagerService {

    private List<Student> _list;
    private ResposiveMethodImp rmi;

    public StudentManagerServiceImp() {
        rmi = new ResposiveMethodImp();
        rmi.connectSQL();
        _list = rmi.getDataStudent();
    }

    @Override
    public void addNewStudent(String maSv, String hoTen, String email, String sdt, String gioiTinh, String diaChi, String avatarPath) {
        rmi.addNewStudent(maSv, hoTen, email, sdt, gioiTinh, diaChi, avatarPath);
        _list = rmi.getDataStudent();
    }

    @Override
    public void updateStudent(int index, Student s) {
        _list = rmi.getDataStudent();
    }

    @Override
    public void removeStudent(int index) {
        _list = rmi.getDataStudent();
    }

    @Override
    public List<Student> getList() {
        _list = rmi.getDataStudent();
        return _list;
    }

}
