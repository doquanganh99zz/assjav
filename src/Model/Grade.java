/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author PC
 */
public class Grade implements Serializable {

    private String maSv;
    private String hoTen;
    private double tiengAnh;
    private double tinHoc;
    private double GDTC;

    public Grade() {
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(double tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public double getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(double tinHoc) {
        this.tinHoc = tinHoc;
    }

    public double getGDTC() {
        return GDTC;
    }

    public void setGDTC(double GDTC) {
        this.GDTC = GDTC;
    }

    public Grade(String maSv, String hoTen, double tiengAnh, double tinHoc, double GDTC) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.GDTC = GDTC;
    }


    public String dienTB() {
        DecimalFormat df = new DecimalFormat("#.0");
        double total = (this.GDTC + this.tiengAnh + this.tinHoc);
        double d = total/3;
        return df.format(d);
    }
}
