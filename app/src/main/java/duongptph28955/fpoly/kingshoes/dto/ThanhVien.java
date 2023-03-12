package duongptph28955.fpoly.kingshoes.dto;

public class ThanhVien {
    private String maTV;
    private String tenTV;
    private int soDT;
    private String matKhau;

    public ThanhVien() {
    }

    public ThanhVien(String maTV, String tenTV, int soDT, String matKhau) {
        this.maTV = maTV;
        this.tenTV = tenTV;
        this.soDT = soDT;
        this.matKhau = matKhau;
    }

    public String getMaTV() {
        return maTV;
    }

    public void setMaTV(String maTV) {
        this.maTV = maTV;
    }

    public String getTenTV() {
        return tenTV;
    }

    public void setTenTV(String tenTV) {
        this.tenTV = tenTV;
    }

    public int getSoDT() {
        return soDT;
    }

    public void setSoDT(int soDT) {
        this.soDT = soDT;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
