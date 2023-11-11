package com.app.grasshopper.publication;
import java.util.Date;

import com.app.grasshopper.perfil.Perfil;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity


public class Publication {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String textPublication;
    private Date datacreation; 
    private int likecounter;
    private int sharedcounter;

    
    @ManyToOne
    private Perfil perfil;
}
