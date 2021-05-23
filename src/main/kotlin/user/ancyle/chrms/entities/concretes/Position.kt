package user.ancyle.chrms.entities.concretes

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "positions")
public data class Position(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    val positionId: Int,

    @Column(name = "position_name")
    val positionName: String
)
