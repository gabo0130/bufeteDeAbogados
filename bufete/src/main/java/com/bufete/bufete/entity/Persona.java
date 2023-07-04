package com.bufete.bufete.entity;
import java.time.LocalDate;
import javax.persistence.*;
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
    
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    
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
    
    @Column(name = "tipo")
    private String tipo;
    

}
