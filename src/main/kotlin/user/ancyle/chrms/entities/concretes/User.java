package user.ancyle.chrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name="users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private short userId;

    @Column(name="user_no")
    private short userNo;

    @Column(name="user_mail")
    private String userMail;

    @Column(name="user_pass")
    private String userPass;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="created_date",columnDefinition = "date default now()")
    private Date createdDate;



}
