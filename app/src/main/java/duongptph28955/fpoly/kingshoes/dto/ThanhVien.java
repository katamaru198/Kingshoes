package duongptph28955.fpoly.kingshoes.dto;

public class ThanhVien {
    private String maTV;
    private String tenTV;
    private String soDT;
    private String matKhau;//abc

    public ThanhVien() {
    }

    public ThanhVien(String maTV, String tenTV, String soDT, String matKhau) {
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

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
