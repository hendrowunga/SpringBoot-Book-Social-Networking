package com.endos.book.user;

import com.endos.book.book.Book;
import com.endos.book.history.BookTransactionHistory;
import com.endos.book.role.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter // Membuat getter otomatis untuk semua properti kelas ini.
@Setter // Membuat setter otomatis untuk semua properti kelas ini.
@Builder // Membuat builder pattern untuk mempermudah pembuatan objek kelas ini.
@AllArgsConstructor // Membuat konstruktor yang menerima semua properti kelas sebagai parameter.
@NoArgsConstructor // Membuat konstruktor tanpa parameter.
@Entity // Menandakan bahwa kelas ini adalah entitas JPA yang akan dipetakan ke tabel database.
@Table(name="_user") // Menentukan nama tabel di database yang akan dipetakan ke kelas ini.
@EntityListeners(AuditingEntityListener.class) // Menambahkan listener untuk mengaudit perubahan pada entitas ini.



public class User implements UserDetails, Principal {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;

    @Column(unique = true)
    private String email;
    private String password;
    private boolean accountLocked;
    private boolean enabled;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;




    @Override
    public String getName() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
    public String fullName() {
        return getFirstname() + " " + getLastname();
    }
    public String getFullName() {
        return firstname + " " + lastname;
    }
}
