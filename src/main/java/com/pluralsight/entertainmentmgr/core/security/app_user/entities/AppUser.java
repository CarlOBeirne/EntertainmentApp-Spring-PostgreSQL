package com.pluralsight.entertainmentmgr.core.security.app_user.entities;

import com.pluralsight.entertainmentmgr.core.auditable.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "app_users")
public class AppUser extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Builder.Default
    private Set<String> authorities = new HashSet<>(Arrays.asList("USER"));

    public void addAuthorities(String authority) {
        if (authorities == null || authorities.isEmpty()) {
            return;
        }
        this.authorities.add(authority);
    }

}
