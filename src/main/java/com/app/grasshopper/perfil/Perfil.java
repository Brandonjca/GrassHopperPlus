package com.app.grasshopper.perfil;

import com.app.grasshopper.register.Register;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Perfil {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private long id;
    private String bannerpicture;
    private String biografia;
    private String location;
    private String socialNetwork;
    private String profilepicture;

    @OneToOne
    private Register register;
}
