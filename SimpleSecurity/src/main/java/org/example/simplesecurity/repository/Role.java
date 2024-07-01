package org.example.simplesecurity.repository;


import jakarta.persistence.*;
import lombok.*;
import lombok.ToString.Exclude;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_role")

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Exclude
    @ManyToOne()
    private User user;
    private String role;

}
