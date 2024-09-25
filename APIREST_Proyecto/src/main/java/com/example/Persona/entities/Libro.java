package com.example.Persona.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited
@Table(name = "libro")
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name="genero")
    private String genero;
    @Column(name = "paginas")
    private int paginas;
    @ManyToMany(mappedBy = "libros")
    @Builder.Default
    private List<Autor> autores = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;


}
