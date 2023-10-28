package vn.edu.iuh.fit.controllers;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.entities.LoaiXe;
import vn.edu.iuh.fit.entities.Xe;
import vn.edu.iuh.fit.repositories.LoaiXeRepository;
import vn.edu.iuh.fit.services.LoaiXeService;
import vn.edu.iuh.fit.services.XeService;

import javax.sound.midi.Soundbank;

@WebServlet(value = "/control-servlet")
public class ControlServlet extends HttpServlet {
    private XeService xeService;
    private LoaiXeService loaiXeService;

    public ControlServlet() {
        xeService = new XeService();
        loaiXeService = new LoaiXeService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "get-xes":
                handleGetListXe(req, resp);
                break;
            case "get-loaixes":
                handleGetListLoaiXe(req, resp);
                break;
            case "get-xes-by-loaixe":
                handleGetXesByLoaiXe(req, resp);
                break;
        }
    }

    private void handleGetXesByLoaiXe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String maLoaiXe = req.getParameter("maLoaiXe");
        long maLoai = Long.parseLong(maLoaiXe);
        List<Xe> loaiXes = xeService.getListXeByLoaiXe(maLoai);
        session.setAttribute("listXe", loaiXes);
        session.setAttribute("tenloaixe", loaiXeService.getLoaiXeByMaLoai(maLoai).getTenLoai());
        req.getRequestDispatcher("listxe.jsp").forward(req, resp);
    }

    private void handleGetListLoaiXe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        List<LoaiXe> loaiXes = loaiXeService.getListLoaiXe();
        session.setAttribute("listloaixe", loaiXes);
        req.getRequestDispatcher("listloaixe.jsp").forward(req, resp);
    }

    private void handleGetListXe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String maloaixe = req.getParameter("maloaixe");
        System.out.println(maloaixe);
        if(maloaixe==null){
            List<Xe> xes = xeService.getListXe();
            session.setAttribute("listXe", xes);
            req.getRequestDispatcher("listxe.jsp").forward(req, resp);
        }else{
            List<Xe> listXeByLoaiXe = xeService.getListXeByLoaiXe(Long.parseLong(maloaixe));
            session.setAttribute("listXe", listXeByLoaiXe);
            session.setAttribute("tenloaixe", loaiXeService.getLoaiXeByMaLoai(Long.parseLong(maloaixe)).getTenLoai());
            req.getRequestDispatcher("listxe.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "add-xe":
                handleAddXe(req, resp);
                break;
            case "filter-xes":
                handleFilterXes(req, resp);
                break;
        }
    }

    private void handleFilterXes(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);
        String loaiXe = req.getParameter("loaixe");
        if(loaiXe.equals("All")){
            resp.sendRedirect("control-servlet?action=get-xes");
        }else{
            long maLoaiXe = Long.parseLong(loaiXe);
            resp.sendRedirect("control-servlet?action=get-xes-by-loaixe&maLoaiXe="+maLoaiXe);
        }
    }

    private void handleAddXe(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);
        String tenXe = req.getParameter("tenxe");
        Double gia = Double.valueOf(req.getParameter("gia"));
        int namsx = Integer.parseInt(req.getParameter("namsx"));
        long maLoaiXe = Long.parseLong(req.getParameter("loaixe"));
        LoaiXe loaiXe = loaiXeService.getLoaiXeByMaLoai(maLoaiXe);
        Xe xeNew = new Xe(tenXe, gia, namsx, loaiXe);

        boolean rs = xeService.insert(xeNew);
        if(rs){
            resp.sendRedirect("control-servlet?action=get-xes");
        }
    }
}