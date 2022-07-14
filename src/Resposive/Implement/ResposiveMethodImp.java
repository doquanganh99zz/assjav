/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resposive.Implement;

import Model.Account;
import Model.Grade;
import Model.Student;
import Resposive.ResposiveMethod;
import java.sql.DriverManager;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ResposiveMethodImp implements ResposiveMethod {

    private String connectionUrl;
    private Connection con;
    private PreparedStatement statement;
    private ResultSet rs;

    public ResposiveMethodImp() {
    }

    @Override
    public void connectSQL() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connectionUrl = "jdbc:sqlserver://PC\\SQLEXPRESS:1433;databaseName=FPL_DAOTAO;encrypt=true;trustServerCertificate=true;";
            con = DriverManager.getConnection(connectionUrl, "sa", "1231234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account loginQuest(String userName, String userPass) {
        try {
            String query = "select username,userpass,permission from USERS where username = '" + userName + "' and userpass = '" + userPass + "'";
            statement = con.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), Integer.parseInt(rs.getString(3)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void closeSQL() {
        try {
            con.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Grade> getDataGrade() {
        String query = "EXEC dbo.GETDATAGRADE";
        try {
            List<Grade> mask = new ArrayList<>();
            statement = con.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                mask.add(new Grade(rs.getString(1), rs.getString(2), Double.parseDouble(rs.getString(3)), Double.parseDouble(rs.getString(4)), Double.parseDouble(rs.getString(5))));
            }
            return mask;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> getDataStudent() {
        String query = "EXEC getdatastudent";
        try {
            List<Student> mask = new ArrayList<>();
            statement = con.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                mask.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)), rs.getString(6), rs.getBytes(7)));
            }
            return mask;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Grade> getTop3DataGrade() {
        String query = "EXEC dbo.GETTOP3DATAGRADE";
        try {
            List<Grade> mask = new ArrayList<>();
            statement = con.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                mask.add(new Grade(rs.getString(1), rs.getString(2), Double.parseDouble(rs.getString(3)), Double.parseDouble(rs.getString(4)), Double.parseDouble(rs.getString(5))));
            }
            return mask;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> getEveryStudentId() {
        String query = "EXEC dbo.GETEVERYSSTUDENTID";
        try {
            List<String> list = new ArrayList<>();
            statement = con.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addNewGrade(String studentId, String englishScore, String itScore, String gdtcScore) {
        try {
            String query = "EXEC dbo.ADDNEWGRADE '" + studentId + "','" + englishScore + "','" + itScore + "','" + gdtcScore + "'";
            Statement st = con.createStatement();
            st.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean removeGrade(String studentId) {
        try {
            String query = "EXEC dbo.DELETE_GRADE '" + studentId + "'";
            Statement st = con.createStatement();
            st.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean remakeGrade(String studentId, String englishScore, String itScore, String gdtcScore) {
        try {
            String query = "EXEC dbo.REMAKEGRADE '" + studentId + "','" + englishScore + "','" + itScore + "','" + gdtcScore + "'";
            Statement st = con.createStatement();
            st.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean addNewStudent(String maSv, String hoTen, String email, String sdt, String gioiTinh, String diaChi, String avatarPath) {
        try {
            String query = "EXEC dbo.ADDNEWSTUDENT '" + maSv + "','" + hoTen + "','" + email + "','" + sdt + "','" + gioiTinh + "','" + diaChi + "','" + avatarPath + "'";
            Statement st = con.createStatement();
            st.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean removeStudent(String maSv) {
        try {
            String query = "EXEC dbo.DELETESTUDENT '" + maSv + "'";
            Statement st = con.createStatement();
            st.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean remakeStudent(String maSv, String hoTen, String email, String sdt, String gioiTinh, String diaChi, String avatarPath) {
        try {
            String query = "EXEC dbo.REMAKESTUDENT '" + maSv + "','" + hoTen + "','" + email + "','" + sdt + "','" + gioiTinh + "','" + diaChi + "','" + avatarPath + "'";
            Statement st = con.createStatement();
            st.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }

}
