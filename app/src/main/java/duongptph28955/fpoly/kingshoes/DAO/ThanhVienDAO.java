package duongptph28955.fpoly.kingshoes.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import duongptph28955.fpoly.kingshoes.DBHelper.DBHelper;
import duongptph28955.fpoly.kingshoes.dto.ThanhVien;

public class ThanhVienDAO {
    SQLiteDatabase db;

    public ThanhVienDAO(Context ct) {
        DBHelper dbHelper = new DBHelper(ct);
        db = dbHelper.getWritableDatabase();
    }

    public long insertThanhVien(ThanhVien obj){
        ContentValues values = new ContentValues();
        values.put("maThanhVien", obj.getMaTV());
        values.put("tenThanhVien", obj.getTenTV());
        values.put("matKhau", obj.getMatKhau());
        values.put("soDienThoaiTV", obj.getSoDT());
        return db.insert("THANHVIEN", null, values);
    }

    public int checkLogin(String ma ,String matkhau){
        String  sql ="SELECT *FROM THANHVIEN WHERE maThanhVien =? AND matKhau=?";
        List<ThanhVien> list =getData(sql,ma,matkhau);
        if (list.size()==0){
            return -1;

        }
        return 1;
    }
    @SuppressLint("Range")
    public List<ThanhVien> getData(String sql , String ... SelectionArgs){
            List<ThanhVien>list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,SelectionArgs);
while (c.moveToNext()){
    ThanhVien thanhVien = new ThanhVien();
    thanhVien.maTV= c.getString(c.getColumnIndex("maThanhVien"));
    thanhVien.tenTV= c.getString(c.getColumnIndex("tenThanhVien"));
    thanhVien.matKhau= c.getString(c.getColumnIndex("matKhau"));
    thanhVien.soDT= c.getString(c.getColumnIndex("soDienThoaiTV"));
    list.add(thanhVien);
}
return list;
    }

}
