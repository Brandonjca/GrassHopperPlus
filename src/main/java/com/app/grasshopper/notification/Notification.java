package com.app.grasshopper.notification;

import com.app.grasshopper.follower.Follower;
import com.app.grasshopper.perfil.Perfil;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity

public class Notification {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String title;
    private String description;

    @ManyToOne
    private Perfil perfil;

    @ManyToOne
    private Follower follower;
}
