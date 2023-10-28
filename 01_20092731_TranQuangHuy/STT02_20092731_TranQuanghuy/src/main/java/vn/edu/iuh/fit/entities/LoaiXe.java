package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "loaixe")
@NamedQueries({
        @NamedQuery(name = "LoaiXe.getListLoaiXe", query = "from LoaiXe"),
        @NamedQuery(name = "LoaiXe.getLoaiXeByMaLoai", query = "from LoaiXe where maLoai = :loaixe")

})
public class LoaiXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai", columnDefinition = "bigint(6)")
    private long maLoai;
    @Column(name = "ten_loai", columnDefinition = "varchar(100)", nullable = false)
    private String tenLoai;

    @OneToMany(mappedBy = "loaiXe",fetch = FetchType.LAZY)
    List<Xe> xes;

    public LoaiXe() {
    }

    public LoaiXe(long maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    public LoaiXe(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public long getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(long maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public List<Xe> getXes() {
        return xes;
    }

    public void setXes(List<Xe> xes) {
        this.xes = xes;
    }

    @Override
    public String toString() {
        return "LoaiXe{" +
                "maLoai=" + maLoai +
                ", tenLoai='" + tenLoai + '\'' +
                '}';
    }
}
