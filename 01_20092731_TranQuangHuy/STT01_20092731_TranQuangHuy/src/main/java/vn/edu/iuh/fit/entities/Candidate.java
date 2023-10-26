package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "candidate")
@NamedQueries({
        @NamedQuery(name = "Candidate.getListCandidate", query = " from Candidate"),
        @NamedQuery(name = "Candidate.getCandidateById", query = "from Candidate where id= :idFind"),
        @NamedQuery(name = "Candidate.getCandidatesByRole", query = "from Candidate c inner join Experience e on c.id=e.candidate.id where e.role = :role "),
        @NamedQuery(name = "Candidate.FilterCandidateUseGmail", query = "from Candidate c where c.email like '%@gmail%'"),
})
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id", columnDefinition = "bigint(20)")
    private long id;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String email;
    @Column(columnDefinition = "varchar(15)", nullable = false)
    private String phone;
    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
    private List<Experience> experiences;

    public Candidate() {
    }

    public Candidate(long id, String fullName, String email, String phone, List<Experience> experiences) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.experiences = experiences;
    }

    public Candidate(String fullName, String email, String phone) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
