package com.springapp.model;

import lombok.Data;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", insertable = false, updatable = false, nullable = false)
    private UUID id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artefactId")
    private Artefact artefact;
    private String userId;
    private String content;

    public Comment() {
    }

    public Comment(Artefact artefact, String userId, String content) {
        this.artefact = artefact;
        this.userId = userId;
        this.content = content;
    }
}
