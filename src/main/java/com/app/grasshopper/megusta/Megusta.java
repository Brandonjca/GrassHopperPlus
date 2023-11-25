package com.app.grasshopper.megusta;

import com.app.grasshopper.publication.Publication;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
        
@Data
@Entity
public class Megusta {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long Id;

    @ManyToOne Publication publication;
            
}
