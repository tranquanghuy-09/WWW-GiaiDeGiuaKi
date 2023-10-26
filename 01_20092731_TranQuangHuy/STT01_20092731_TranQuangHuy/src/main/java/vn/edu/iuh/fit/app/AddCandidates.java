package vn.edu.iuh.fit.app;

import vn.edu.iuh.fit.entities.Candidate;
import vn.edu.iuh.fit.entities.Experience;
import vn.edu.iuh.fit.enums.Roles;
import vn.edu.iuh.fit.repositories.CandidateRepository;
import vn.edu.iuh.fit.repositories.ExperienceRepository;

import java.time.LocalDate;

public class AddCandidates {
    public static void main(String[] args) {
        CandidateRepository candidateRepository = new CandidateRepository();
        ExperienceRepository experienceRepository = new ExperienceRepository();

        Candidate candidate1 = new Candidate("Tran Huy 1", "huy1@gmail.com", "0123456789");
        Experience experience1_1 = new Experience(LocalDate.of(2020, 01, 01), "Mo ta cong viec 1", Roles.ADMINISTRATION, "FPT",
                LocalDate.of(2021, 01, 01), candidate1);
        Experience experience1_2 = new Experience(LocalDate.of(2020, 01, 01), "Mo ta cong viec 2", Roles.STAFF, "IUH",
                LocalDate.of(2021, 01, 01), candidate1);
        Experience experience1_3 = new Experience(LocalDate.of(2020, 01, 01), "Mo ta cong viec 3", Roles.EXECUTIVE, "FIT",
                LocalDate.of(2021, 01, 01), candidate1);
        candidateRepository.insertCandidate(candidate1);
        experienceRepository.insertExperience(experience1_1);
        experienceRepository.insertExperience(experience1_2);
        experienceRepository.insertExperience(experience1_3);

        Candidate candidate2 = new Candidate("Nguyễn Minh Duy", "duyga@outlook.com", "0123456789");
        Experience experience2_1 = new Experience(LocalDate.of(2020, 01, 01), "Mo ta cong viec 1", Roles.ADMINISTRATION, "FPT",
                LocalDate.of(2021, 01, 01), candidate2);
        Experience experience2_2 = new Experience(LocalDate.of(2020, 01, 01), "Mo ta cong viec 2", Roles.STAFF, "IUH",
                LocalDate.of(2021, 01, 01), candidate2);
        Experience experience2_3 = new Experience(LocalDate.of(2020, 01, 01), "Mo ta cong viec 5", Roles.MANAGER, "FIT",
                LocalDate.of(2021, 01, 01), candidate2);
        candidateRepository.insertCandidate(candidate2);
        experienceRepository.insertExperience(experience2_1);
        experienceRepository.insertExperience(experience2_2);
        experienceRepository.insertExperience(experience2_3);

        Candidate candidate3 = new Candidate("Trần Quang Huy", "tranquanghuyit09@gmail.com", "0123456789");
        Experience experience3_1 = new Experience(LocalDate.of(2020, 01, 01), "Mo ta cong viec 1", Roles.EXECUTIVE, "FPT",
                LocalDate.of(2021, 01, 01), candidate3);
        Experience experience3_2 = new Experience(LocalDate.of(2020, 01, 01), "Mo ta cong viec 2", Roles.STAFF, "IUH",
                LocalDate.of(2021, 01, 01), candidate3);
        Experience experience3_3 = new Experience(LocalDate.of(2020, 01, 01), "Mo ta cong viec 3", Roles.MANAGER, "FIT",
                LocalDate.of(2021, 01, 01), candidate3);
        candidateRepository.insertCandidate(candidate3);
        experienceRepository.insertExperience(experience3_1);
        experienceRepository.insertExperience(experience3_2);
        experienceRepository.insertExperience(experience3_3);
    }
}
