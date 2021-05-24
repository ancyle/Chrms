package user.ancyle.chrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="confirmations")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Confirmation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="verify_id")
    private short verifyId;

    @Column(name="mod_verify")
    private boolean modVerify;

    @Column(name="mail_verify")
    private boolean mailVerify;

    @Column(name="token")
    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false,name="user_id")
    private User user;
}
