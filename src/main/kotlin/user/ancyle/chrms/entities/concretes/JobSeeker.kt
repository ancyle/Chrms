package user.ancyle.chrms.entities.concretes

import java.util.*
import javax.persistence.*


@Entity
@Table(name = "job_seekers")
public data class JobSeeker(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "js_id")
    val jsId: Int,
    @Column(name = "js_no")
    val jsNo: String,
    @Column(name = "js_mail")
    val jsMail: String,
    @Column(name = "js_pass")
    val jsPass: String,
    @Column(name = "js_first_name")
    val jsFirstName: String,
    @Column(name = "js_last_name")
    val jsLastName: String,
    @Column(name = "js_national_identity")
    val nationalIdentity: String,
    @Column(name = "js_birth_year")
    val jsBirthYear: Int,
    @Column(name = "is_active")
    val isActive: Boolean,
    @Column(name = "created_date")
    val createdDate: Date
)
