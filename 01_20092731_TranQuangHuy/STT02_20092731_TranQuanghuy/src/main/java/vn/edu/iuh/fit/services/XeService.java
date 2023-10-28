package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Xe;
import vn.edu.iuh.fit.repositories.XeRepository;

import java.util.ArrayList;
import java.util.List;

public class XeService {
    private XeRepository xeRepository;

    public XeService() {
        xeRepository = new XeRepository();
    }
    public List<Xe> getListXe(){
        return xeRepository.getListXe();
    }
    public boolean insert(Xe xe){
        return xeRepository.insert(xe);
    }
    public List<Xe> getListXeByLoaiXe(long loaiXe){
        return xeRepository.getListXeByLoaiXe(loaiXe);
    }
}
