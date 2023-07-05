package com.bufete.bufete.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @ManyToOne
    @JoinColumn(name = "proceso_id")
    private Proceso proceso;


    public void agregarTestigo(Persona testigo) {
        this.testigos.add(testigo);
        testigo.getCasosComoTestigo().add(this);
    }

    public void eliminarTestigo(Persona testigo) {
        this.testigos.remove(testigo);
        testigo.getCasosComoTestigo().remove(this);
    }
}
