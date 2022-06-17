package br.com.redfield.crudspringcourse.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "curso")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", length = 200, nullable = false)
    private String name;

    @Column(name = "categoria", length = 200, nullable = false)
    private String category;

}
