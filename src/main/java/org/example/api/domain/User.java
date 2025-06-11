package org.example.api.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String name;

    @Column(unique = true, name = "user_email")
    private String email;

    @Column(name = "user_pwd")
    private String password;
}
