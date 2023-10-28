package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.LoaiXe;
import vn.edu.iuh.fit.repositories.LoaiXeRepository;

import java.util.List;

public class LoaiXeService {
    private LoaiXeRepository loaiXeRepository;

    public LoaiXeService() {
        loaiXeRepository = new LoaiXeRepository();
    }
    public List<LoaiXe> getListLoaiXe(){
        return loaiXeRepository.getListLoaiXe();
    }
    public LoaiXe getLoaiXeByMaLoai(long maLoaiXe){
        return loaiXeRepository.getLoaiXeByMaLoai(maLoaiXe);
    }
}
