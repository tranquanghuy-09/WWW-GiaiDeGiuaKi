package vn.edu.iuh.fit.controllers;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.entities.Candidate;
import vn.edu.iuh.fit.enums.Roles;
import vn.edu.iuh.fit.services.CandidateService;

@WebServlet(urlPatterns = {"/control-servlet"})
public class ControlServlet extends HttpServlet {
    private final CandidateService candidateService;

    public ControlServlet() {
        candidateService = new CandidateService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        switch (action){
            case "get-candidates":
                handelGetCandidates(req, resp);
                break;
            case "candidate-detail":
                handelGetCandidateDetail(req, resp);
                break;
            case "get-candidates-by-role":
                handelGetCandidatesByRole(req, resp);
                break;
            case "get-candidates-use-gmail":
                handelGetCandidatesUseGmail(req, resp);
                break;
        }
    }

    private void handelGetCandidatesUseGmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Candidate> candidatesUseGmail = candidateService.getCandidatesUseGmail();

        HttpSession session = req.getSession();
        session.setAttribute("candidatesUseGmail", candidatesUseGmail);

        req.getRequestDispatcher("report2.jsp").forward(req, resp);
    }

    private void handelGetCandidatesByRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        int role = Integer.parseInt(req.getParameter("role"));

        List<Candidate> candidatesByRole = candidateService.getCandidatesByRole(Roles.fromValue(role));
        System.out.println(candidatesByRole);
        session.setAttribute("CandidatesByRole", candidatesByRole);
        session.setAttribute("currentRole", role);

        req.getRequestDispatcher("report1.jsp").forward(req, resp);
    }

    private void handelGetCandidateDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        long id = Long.parseLong(req.getParameter("id"));

        Candidate candidate = candidateService.getCandidateById(id);
        System.out.println(candidate);
        session.setAttribute("candidate", candidate);

        req.getRequestDispatcher("candidate_detail.jsp").forward(req, resp);
    }

    private void handelGetCandidates(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Candidate> candidates = candidateService.getCandidateList();

        HttpSession session = req.getSession();
        session.setAttribute("candidates", candidates);

        req.getRequestDispatcher("candidates.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        switch (action){
            case "filter-candidate":
                handelFilterCandidate(req, resp);
                break;
        }
    }

    private void handelFilterCandidate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);
        session.invalidate();
        int role = Integer.parseInt(req.getParameter("role"));
        resp.sendRedirect("control-servlet?action=get-candidates-by-role&role="+role);
    }
}