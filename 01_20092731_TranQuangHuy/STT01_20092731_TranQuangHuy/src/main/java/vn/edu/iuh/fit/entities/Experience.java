package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import vn.edu.iuh.fit.converters.RoleConverter;
import vn.edu.iuh.fit.enums.Roles;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id", columnDefinition = "bigint(20)")
    private long id;
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;
    @Lob
    @Column(name = "work_desc", columnDefinition = "varchar(400)", nullable = false)
    private String workDescription;

    @Convert(converter = RoleConverter.class)
    @Column(columnDefinition = "tinyint(4)", nullable = false)
    private Roles role;
    @Column(name = "company",columnDefinition = "varchar(120)", nullable = false)
    private String companyName;
    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;
    @ManyToOne()
    @JoinColumn(name = "can_id", referencedColumnName = "can_id")
    private Candidate candidate;

    public Experience(long id, LocalDate fromDate, String workDescription, Roles role, String companyName, LocalDate toDate, Candidate candidate) {
        this.id = id;
        this.fromDate = fromDate;
        this.workDescription = workDescription;
        this.role = role;
        this.companyName = companyName;
        this.toDate = toDate;
        this.candidate = candidate;
    }

    public Experience(LocalDate fromDate, String workDescription, Roles role, String companyName, LocalDate toDate, Candidate candidate) {
        this.fromDate = fromDate;
        this.workDescription = workDescription;
        this.role = role;
        this.companyName = companyName;
        this.toDate = toDate;
        this.candidate = candidate;
    }



    public Experience() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", workDescription='" + workDescription + '\'' +
                ", role=" + role +
                ", companyName='" + companyName + '\'' +
                ", toDate=" + toDate +
                ", candidate=" + candidate +
                '}';
    }
}
