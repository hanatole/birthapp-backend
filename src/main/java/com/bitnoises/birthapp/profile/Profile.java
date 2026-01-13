package com.bitnoises.birthapp.profile;

import com.bitnoises.birthapp.common.entity.Address;
import com.bitnoises.birthapp.common.enums.Civility;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profiles", uniqueConstraints = {
        @UniqueConstraint(name = "uk_profiles_email", columnNames = "email")
})
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    @Enumerated(EnumType.STRING)
    private Civility civility;
    @Column(nullable = false)
    private String email;
    private String password;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "address_id")
    private Address address;
}
