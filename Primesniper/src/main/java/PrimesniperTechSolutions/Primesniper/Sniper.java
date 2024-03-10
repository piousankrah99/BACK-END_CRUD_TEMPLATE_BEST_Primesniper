package PrimesniperTechSolutions.Primesniper;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "primesnipertsdb")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Sniper {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long id;

    String username;

    String msisdn;

    Gender gender;

    LocalDate birthday;

    String email;

    String password;

}
