package com.andygomez.main.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = SEQUENCE,
            generator = "product_id_seq")
    @SequenceGenerator(name = "product_id_seq",
            sequenceName = "product_id_seq",
            initialValue = 1,
            allocationSize = 1)
    private Short id;
    @Column(nullable = false, length = 50)
    private String name;

}
