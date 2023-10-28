package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import jdk.jfr.Name;

@Entity
@Table(name = "xe")
@NamedQueries({
        @NamedQuery(name = "Xe.GetListXe", query = "from Xe"),
        @NamedQuery(name = "Xe.getListXeByLoaiXe", query = "from Xe x inner join LoaiXe l on x.loaiXe.maLoai=l.maLoai where l.maLoai = :loaiXe "),

})
public class Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_xe")
    private long maXe;
    private String tenXe;
    private double gia;
    private int namSx;
    @ManyToOne
    @JoinColumn(name = "ma_loai", referencedColumnName = "ma_loai")
    private LoaiXe loaiXe;

    public Xe() {
    }

    public Xe(String tenXe, double gia, int namSx, LoaiXe loaiXe) {
        this.tenXe = tenXe;
        this.gia = gia;
        this.namSx = namSx;
        this.loaiXe = loaiXe;
    }

    public long getMaXe() {
        return maXe;
    }

    public void setMaXe(long maXe) {
        this.maXe = maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getNamSx() {
        return namSx;
    }

    public void setNamSx(int namSx) {
        this.namSx = namSx;
    }

    public LoaiXe getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(LoaiXe loaiXe) {
        this.loaiXe = loaiXe;
    }

    @Override
    public String toString() {
        return "Xe{" +
                "maXe=" + maXe +
                ", tenXe='" + tenXe + '\'' +
                ", gia=" + gia +
                ", namSx=" + namSx +
                ", loaiXe=" + loaiXe +
                '}';
    }
}
