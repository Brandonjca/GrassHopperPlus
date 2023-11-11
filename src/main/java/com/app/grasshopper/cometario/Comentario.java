package com.app.grasshopper.cometario;

import com.app.grasshopper.publication.Publication;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Comentario {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String description;

    @ManyToOne
    private Publication publication;
}
