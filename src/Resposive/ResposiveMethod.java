/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Resposive;

import Model.Account;
import Model.Grade;
import Model.Student;
import java.util.List;

/**
 *
 * @author PC
 */
public interface ResposiveMethod {

    // Services
    public void connectSQL();

    public void closeSQL();

    public Account loginQuest(String userName, String userPass);
    //  --------------------------------------------------------- Grade

    public List<Grade> getDataGrade();

    public List<Grade> getTop3DataGrade();

    public List<String> getEveryStudentId();

    public boolean addNewGrade(String studentId, String englishScore, String itScore, String gdtcScore);

    public boolean removeGrade(String studentId);

    public boolean remakeGrade(String studentId, String englishScore, String itScore, String gdtcScore);
    //  --------------------------------------------------------- Student

    public List<Student> getDataStudent();

    public boolean addNewStudent(String maSv, String hoTen, String email, String sdt, String gioiTinh, String diaChi, String avatarPath);

    public boolean removeStudent(String maSv);

    public boolean remakeStudent(String maSv, String hoTen, String email, String sdt, String gioiTinh, String diaChi, String avatarPath);
}
