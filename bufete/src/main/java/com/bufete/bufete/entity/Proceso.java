package com.bufete.bufete.entity;

import java.time.LocalDate;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "procesos")
public class Proceso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "juzgado_id")
    private Juzgado juzgado;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    @Column(name = "descripcion")
    private String descripcion;
}
