package com.dicka.springboot.demointegratedangular.entity.entity_oauth;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "table_users",
        catalog = "spring_boot")
public class Users implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idusers;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "activated")
    private boolean activated;

    @Column(name = "activationkey")
    private String activationKey;

    @Column(name = "resetpasswordkey")
    private String resetPasswordKey;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "table_users_roles", joinColumns =
    @JoinColumn(name = "idusers", referencedColumnName = "idusers"), inverseJoinColumns =
    @JoinColumn(name = "idroles", referencedColumnName = "idroles"))
    private List<Roles> rolesList = new ArrayList<Roles>();
}
