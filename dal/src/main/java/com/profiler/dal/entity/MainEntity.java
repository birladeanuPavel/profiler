package com.profiler.dal.entity;

import javax.persistence.*;

/**
 *
 * @author pavel
 */
@MappedSuperclass
public abstract class MainEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
