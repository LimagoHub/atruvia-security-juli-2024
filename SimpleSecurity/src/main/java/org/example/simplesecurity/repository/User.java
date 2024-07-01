package org.example.simplesecurity.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_user")
public class User implements UserDetails{




        private static final long serialVersionUID = -6486214960326841088L;

        @Id	@Column(length = 50)
//	@Pattern(regexp="^[a-zA-Z0-9ÄÖÜäüö]{6,50}$",message="username braucht min. 6 Stellen, nur Buchstaben und Ziffern sind erlaubt.")
        @Email
        @NotEmpty
        private String username;

        @JsonIgnore
        //@Pattern(regexp="^((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,255})$",message="Password braucht min. 6 Stellen, muss min. einen Gross- und einen Kleinbuchstaben, sowie eine Ziffer und eines dieser Zeichen '@#$%' enthalten.")
        //@Size(min = 6, max=255)
        //@NotEmpty(message = "Password darf nicht leer sein.")
        private String password;

        @Column(length = 50)
        @Size(min = 2, max=50)
        @NotEmpty
        private String fullname;

        @Builder.Default
        private String rolle= "USER";

        @Builder.Default
        private boolean enabled = true;

        private LocalDateTime lastUpdate;

        @OneToMany( mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Role> roles = new ArrayList<>();

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {

                //roles.forEach(System.out::println);

                List<GrantedAuthority> authorities = new ArrayList<>();
                roles.forEach(r->authorities.add(new SimpleGrantedAuthority("ROLE_" + r.getRole())));
                return authorities;
        }



        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {

            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {

            return true;
        }

        @PrePersist
        public void setCreateTime() {
            lastUpdate = LocalDateTime.now();
        }

        @PreUpdate
        public void setUpdateTime() {
            lastUpdate = LocalDateTime.now();
        }







}
