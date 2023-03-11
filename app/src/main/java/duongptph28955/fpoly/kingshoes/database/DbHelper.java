package duongptph28955.fpoly.kingshoes.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context){
        super(context,"DUAN1",null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String dbThanhVien ="CREATE TABLE THANHVIEN(matv text primary key, tentv text, matkhau text, sdt text)";
        sqLiteDatabase.execSQL(dbThanhVien);  //matv sẽ dùng làm tên đăng nhập

        String dbKhachHang ="CREATE TABLE KHACHHANG(makh integer primary key autoincrement, tenkh text, sdt text, diachi text)";
        sqLiteDatabase.execSQL(dbKhachHang);

        String dbLoaiGiay ="CREATE TABLE LOAIGIAY(maloai integer primary key autoincrement, tenloai text)";
        sqLiteDatabase.execSQL(dbLoaiGiay);

        String dbSanPham ="CREATE TABLE SANPHAM(masp integer primary key autoincrement, maloai integer references LOAIGIAY(maloai), tensp text, mausac text, size text, gianhap integer, soluong integer, ngaynhap text, hinhanh integer)";
        sqLiteDatabase.execSQL(dbSanPham);

        String dbMauSac ="CREATE TABLE MAUSAC(mamau text primary key autoincrement, tenmau text, masp integer references SANPHAM(masp) )";
        sqLiteDatabase.execSQL(dbMauSac);

        String dbSize ="CREATE TABLE SIZE(masize integer primary key autoincrement, size text, masp integer references SANPHAM(masp))";
        sqLiteDatabase.execSQL(dbSize);

        String dbHoaDon ="CREATE TABLE HOADON(mahd integer primary key autoincrement, masp integer references SANPHAM(masp), makh references KHACHHANG(makh), trangthai integer, giaxuat integer, ngayxuat text, soluongxuat integer)";
        sqLiteDatabase.execSQL(dbHoaDon); // trạng thái (trangthai): đã thanh toán (1)   ;   chưa thanh toán (0)



        // insert bảng thành viên
        sqLiteDatabase.execSQL("INSERT INTO THANHVIEN VALUES ('quyetmtph28802','Mai Thế Quyết','ph28802', '0365512453'), ('thaobcph28911','Bùi Công Thảo','ph28911', '0123456789')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i != i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS THANHVIEN");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS KHACHHANG");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LOAIGIAY");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS SANPHAM");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MAUSAC");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS SIZE");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS HOADON");
            onCreate(sqLiteDatabase);
        }
    }
}
