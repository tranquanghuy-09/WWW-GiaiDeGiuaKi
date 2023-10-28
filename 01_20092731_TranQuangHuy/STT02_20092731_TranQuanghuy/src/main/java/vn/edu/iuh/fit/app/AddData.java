package vn.edu.iuh.fit.app;

import vn.edu.iuh.fit.entities.LoaiXe;
import vn.edu.iuh.fit.entities.Xe;
import vn.edu.iuh.fit.repositories.LoaiXeRepository;
import vn.edu.iuh.fit.repositories.XeRepository;

public class AddData {
    public static void main(String[] args) {
        LoaiXeRepository loaiXeRepository = new LoaiXeRepository();
        XeRepository xeRepository = new XeRepository();

        LoaiXe loaiXe1 = new LoaiXe("Sedan");
        LoaiXe loaiXe2 = new LoaiXe("Container");
        loaiXeRepository.insert(loaiXe1);
        loaiXeRepository.insert(loaiXe2);

        Xe xe1_1 = new Xe("Vinfast", 2000, 2020, loaiXe1);
        Xe xe1_2 = new Xe("Fadil", 1000, 2021, loaiXe1);

        Xe xe2_1 = new Xe("Đầu kéo Mỹ", 5000, 2023, loaiXe2);
        Xe xe2_2 = new Xe("Man", 10000, 2019, loaiXe2);
        xeRepository.insert(xe1_1);
        xeRepository.insert(xe1_2);
        xeRepository.insert(xe2_1);
        xeRepository.insert(xe2_2);
    }
}
