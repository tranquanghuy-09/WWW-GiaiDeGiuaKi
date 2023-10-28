package vn.edu.iuh.fit.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.entities.Candidate;
import vn.edu.iuh.fit.enums.Roles;
import vn.edu.iuh.fit.repositories.CandidateRepository;

import java.util.List;

public class CandidateService {
    private CandidateRepository candidateRepository;

    public CandidateService() {
        candidateRepository = new CandidateRepository();
    }

    public List<Candidate> getCandidateList(){
        return candidateRepository.getCandidateList();
    }
    public Candidate getCandidateById(long id){
        return candidateRepository.getCandidateById(id);
    }
    public List<Candidate> getCandidatesByRole(Roles role){
        return candidateRepository.getCandidatesByRole(role);
    }
    public List<Candidate> getCandidatesUseGmail(){
        return candidateRepository.getCandidatesUseGmail();
    }
    public boolean updateCandidate(Candidate candidate){
        return candidateRepository.updateCandidate(candidate);
    }
}
