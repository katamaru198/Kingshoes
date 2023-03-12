package duongptph28955.fpoly.kingshoes.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import duongptph28955.fpoly.kingshoes.DAO.LoaiGiayDAO;
import duongptph28955.fpoly.kingshoes.R;
import duongptph28955.fpoly.kingshoes.dto.LoaiGiay;

public class LoaiGiayAdapter extends RecyclerView.Adapter<LoaiGiayAdapter.ViewHolder>{
    private ArrayList<LoaiGiay> list;
    private Context context;
    private LoaiGiayDAO loaiGiayDAO;

    public LoaiGiayAdapter(ArrayList<LoaiGiay> list, Context context, LoaiGiayDAO loaiGiayDAO) {
        this.list = list;
        this.context = context;
        this.loaiGiayDAO = loaiGiayDAO;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_recycler_loaigiay, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtMaLoai.setText("Mã loại giầy: " + list.get(position).getMaLoai());
        holder.txtTenLoai.setText("Tên loại giầy: "+ list.get(position).getTenLoai());

        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogCapNhatLoai(list.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtMaLoai, txtTenLoai;
        ImageView imgEdit, imgDel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMaLoai = itemView.findViewById(R.id.txtMaLoai);
            txtTenLoai = itemView.findViewById(R.id.txtTenLoai);

            imgEdit = itemView.findViewById(R.id.ivEdit);
            imgDel = itemView.findViewById(R.id.ivDel);
        }
    }
    private void showDialogCapNhatLoai(LoaiGiay loaiGiay){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_editloaigiay, null );
        builder.setView(view);

        TextView txtMaLoai = view.findViewById(R.id.txtDiaEditMaLoai);
        TextInputLayout edtTenLoai = view.findViewById(R.id.edtDiaEditTenLoai);

        txtMaLoai.setText("Mã loai giầy: " + loaiGiay.getMaLoai());
        edtTenLoai.getEditText().setText(loaiGiay.getTenLoai());

        builder.setNegativeButton("Cập Nhật", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String tenLoai = edtTenLoai.getEditText().getText().toString();
                int id = loaiGiay.getMaLoai();

                boolean check = loaiGiayDAO.thaydoiLoaiGiay(id, tenLoai);
                if (check){
                    Toast.makeText(context, "Cập nhật thông tin loại giầy thành công", Toast.LENGTH_SHORT).show();
                    loadData();
                }else {
                    Toast.makeText(context, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setPositiveButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private  void loadData(){
        list.clear();
        list = loaiGiayDAO.getDSLoaiGiay();
        notifyDataSetChanged();
    }

}
