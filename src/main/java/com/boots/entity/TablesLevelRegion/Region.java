package com.boots.entity.TablesLevelRegion;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    Set<Level> levels = new HashSet<>();

    public void add(Level departboss){
        levels.add(departboss);}

    public Region() {
    }

    public Region(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Set<Level> getBosses() {
        return levels;
    }

    public void setBosses(Set<Level> levels) {
        this.levels = levels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
