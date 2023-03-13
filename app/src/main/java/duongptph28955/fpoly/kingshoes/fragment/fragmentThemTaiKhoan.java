package duongptph28955.fpoly.kingshoes.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import duongptph28955.fpoly.kingshoes.DAO.ThanhVienDAO;
import duongptph28955.fpoly.kingshoes.R;
import duongptph28955.fpoly.kingshoes.dto.ThanhVien;

public class fragmentThemTaiKhoan extends Fragment {
    ThanhVienDAO dao;
    EditText ed_user, ed_hoten, edPass, edRePass, edSDT;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_themtaikhoan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ed_user = view.findViewById(R.id.edNewUser);
        ed_hoten = view.findViewById(R.id.edHoTenTV);
        edSDT = view.findViewById(R.id.edSoDienThoaiTV);
        edPass = view.findViewById(R.id.edPassWord);
        edRePass = view.findViewById(R.id.edRePassWord);
        view.findViewById(R.id.btnCancelAddTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_user.setText("");
                edPass.setText("");
                ed_hoten.setText("");
                edRePass.setText("");
                edSDT.setText("");
            }
        });
        view.findViewById(R.id.btnAddTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThanhVien thanhVien = new ThanhVien();
                thanhVien.maTV = ed_user.getText().toString();
                thanhVien.tenTV = ed_hoten.getText().toString();
                thanhVien.soDT = edSDT.getText().toString();
                thanhVien.matKhau = edPass.getText().toString();
                dao = new ThanhVienDAO(getContext());
                if (validate()>0){
                    if (dao.insertThanhVien(thanhVien)>0){
                        Toast.makeText(getContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
                        ed_user.setText("");
                        edPass.setText("");
                        ed_hoten.setText("");
                        edRePass.setText("");
                        edSDT.setText("");
                    } else {
                        Toast.makeText(getContext(), "Lưu thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private int validate() {
        int check = 1;
        if(ed_user.getText().length() == 0||ed_hoten.getText().length() == 0 || edPass.getText().length() == 0 || edRePass.getText().length() == 0 || edSDT.getText().length() == 0){
            Toast.makeText(getContext(), "Bạn phải nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            String pass = edPass.getText().toString();
            String rePass = edRePass.getText().toString();
            if (!pass.equals(rePass)){
                Toast.makeText(getContext(), "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                check = -1;
            }
        }
        return check;

    }
}
