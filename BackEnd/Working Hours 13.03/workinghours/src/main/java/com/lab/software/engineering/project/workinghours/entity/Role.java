package com.lab.software.engineering.project.workinghours.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@SequenceGenerator(name = "ROLES_ID_GENERATOR", sequenceName = "ROLES_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLES_ID_GENERATOR")
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    
    private RoleName name;

    public Role() {}

    public Role(RoleName name) {
        this.name = name;
    }
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}