package com.example.wow.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wow_character", schema = "wow")
@JsonIgnoreProperties(ignoreUnknown = true)
public class WowCharacterEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    @JsonProperty("id")
    private int id;

    @Basic
    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Basic
    @Column(name = "level")
    @JsonProperty("level")
    private Integer level;

    @Basic
    @Column(name = "race")
    @JsonProperty("race")
    private String race;

    @Basic
    @Column(name = "class")
    @JsonProperty("class")
    private String clazz;

    @Basic
    @Column(name = "specialization")
    @JsonProperty("specialization")
    private String specialization;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WowCharacterEntity that = (WowCharacterEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(level, that.level) && Objects.equals(race, that.race) && Objects.equals(clazz, that.clazz) && Objects.equals(specialization, that.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, level, race, clazz, specialization);
    }

}
