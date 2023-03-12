package duongptph28955.fpoly.kingshoes.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
}
