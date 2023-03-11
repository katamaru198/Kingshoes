package duongptph28955.fpoly.kingshoes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;


public class DangNhapActivity extends AppCompatActivity {


    TextInputLayout edtTaiKhoan, edtMatKhau;
    Button btnDangNhap;
    CheckBox chkLuu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        edtTaiKhoan = findViewById(R.id.edtTaiKhoan);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        chkLuu = findViewById(R.id.chkLuu);

//        ThanhVienDAO thanhVienDAO = new ThanhVienDAO(this);
//
//        //sự kiện đăng nhập
//        btnDangNhap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String taiKhoan = edtTaiKhoan.getEditText().getText().toString();
//                String matKhau = edtMatKhau.getEditText().getText().toString();
//                if (thanhVienDAO.checkDangNhap(taiKhoan, matKhau)){
//                    SharedPreferences sharedPreferences = getSharedPreferences("THONGTIN",MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("matv", taiKhoan);
//                    editor.commit();
//
//                    startActivity(new Intent(DangNhapActivity.this, MainActivity.class));
//                }else {
//                    Toast.makeText(DangNhapActivity.this, "Khong Dung", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }
}