package com.app.grasshopper.register;

import com.app.grasshopper.perfil.Perfil;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity

public class Register {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private LocalDateTime birthday;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    
    @OneToOne
    private Perfil perfil;
}
