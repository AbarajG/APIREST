package com.andygomez.main.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = SEQUENCE,
            generator = "categories_id_seq")
    @SequenceGenerator(name = "categories_id_seq",
            sequenceName = "categories_id_seq",
            initialValue = 1,
            allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @JsonIgnore
    @Column(name = "category_id", nullable = false)
    private Short categoryId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id",
            referencedColumnName = "id",
            insertable = false,
            updatable = false)

    private Category category;

    @JsonIgnore
    @Column(nullable = false)
    private Boolean deleted;

}
