package com.bufete.bufete.entity;
import java.time.LocalDate;
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
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "foto_perfil")
    private String fotoPerfil;
    
    @Column(name = "numero_identificacion")
    private String numeroIdentificacion;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento")
    private TipoDocumento tipoDocumento;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    
    @Column(name = "ciudad")
    private String ciudad;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "celular")
    private String celular;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoPersona tipo;

    @ManyToMany(mappedBy = "testigos")
    @JsonIgnore
    private List<Caso> casosComoTestigo = new ArrayList<>();
    

}
