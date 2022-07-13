/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Grade;
import java.util.List;

/**
 *
 * @author PC
 */
public interface GradeManagerService {


    public void remake(String studentId, String englishScore, String itScore, String gdtcScore);

    public void remove(String studentId);

    public void search();

    public List<Grade> getList();

    public boolean isExist(String s);

    public List<Grade> getTop3Score();

    public boolean isThisStudentExist(String s);

    public void addNewGrade(String studentId, String englishScore, String itScore, String gdtcScore);
}
