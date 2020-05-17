package com.springapp.model;

import lombok.Data;
import org.hibernate.annotations.Type;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Artefact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;
    private Date date;
    private String userId;
    private String category;
    private String description;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "artefact", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> commentList;

    public Artefact() {
    }

    public Artefact(String userId, String category) {
        this.userId = userId;
        this.category = category;
    }
}
