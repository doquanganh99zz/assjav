/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import Model.Grade;
import Resposive.Implement.ResposiveMethodImp;
import Service.GradeManagerService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class GradeManagerServiceImp implements GradeManagerService {

    private ResposiveMethodImp rmi;
    private List<Grade> _list;

    public GradeManagerServiceImp() {
        _list = new ArrayList<>();
        rmi = new ResposiveMethodImp();
        rmi.connectSQL();
        _list = rmi.getDataGrade();
    }

    @Override
    public void remake(String studentId, String englishScore, String itScore, String gdtcScore) {
        rmi.remakeGrade(studentId, englishScore, itScore, gdtcScore);
        _list = rmi.getDataGrade();
    }

    @Override
    public void remove(String studentId) {
        rmi.removeGrade(studentId);
        _list = rmi.getDataGrade();
    }

    @Override
    public void search() {
    }

    @Override
    public List<Grade> getList() {
        _list = rmi.getDataGrade();
        return _list;
    }

    @Override
    public boolean isExist(String s) {
        for (Grade grade : _list) {
            if (grade.getMaSv().toLowerCase().equals(s.trim().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Grade> getTop3Score() {
        return rmi.getTop3DataGrade();
    }

    @Override
    public boolean isThisStudentExist(String s) {
        if (rmi.getEveryStudentId().isEmpty()) {
            return false;
        }
        for (String string : rmi.getEveryStudentId()) {
            if (s.toLowerCase().equals(string.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addNewGrade(String studentId, String englishScore, String itScore, String gdtcScore) {
        rmi.addNewGrade(studentId, englishScore, itScore, gdtcScore);
        _list = rmi.getDataGrade();
    }

}
