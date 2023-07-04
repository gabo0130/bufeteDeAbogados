package com.bufete.bufete.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "casos")
public class Caso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona cliente;

    @ManyToMany
    @JoinTable(name = "caso_testigo",
            joinColumns = @JoinColumn(name = "caso_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private List<Persona> testigos = new ArrayList<>();
}
