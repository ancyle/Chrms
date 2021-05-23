package user.ancyle.chrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_seekers")
@Data
public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="js_id")
    private short jsId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="national_id")
    private String nationalId;

    @Column(name="birth_year")
    private short birthYear;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
