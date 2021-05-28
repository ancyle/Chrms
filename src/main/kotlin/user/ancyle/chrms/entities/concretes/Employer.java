package user.ancyle.chrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","announcements"})
@Data
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_id")
    private short empId;

    @Column(name="corp_name")
    private String corpName;

    @Column(name="web_site")
    private String webSite;

    @Column(name="phone_number")
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy="employer")
    List<Announcement> announcements;
}
