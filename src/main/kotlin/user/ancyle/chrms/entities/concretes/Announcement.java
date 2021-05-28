package user.ancyle.chrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name="announcements")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private short id;
  //  @Column(name="job_id")
 // private short jobId;
    @Column(name="ann_name")
    private String annName;
  // @Column(name="city_id")
  // private String cityId;
    @Column(name="description")
    private String description;
    @Column(name="monthly")
    private String monthly;
    @Column(name="quota")
    private short quota;
    @Column(name="ex_date")
    private LocalDate exDate;
    @Column(name="status")
    private boolean status;

    @ManyToOne()
    @JoinColumn(name="emp_id")
    private Employer employer;


}
