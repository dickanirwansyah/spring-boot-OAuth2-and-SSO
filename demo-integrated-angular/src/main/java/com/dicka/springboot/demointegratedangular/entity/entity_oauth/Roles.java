package com.dicka.springboot.demointegratedangular.entity.entity_oauth;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "table_roles",
        catalog = "spring_boot")
public class Roles implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idroles;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;
}
