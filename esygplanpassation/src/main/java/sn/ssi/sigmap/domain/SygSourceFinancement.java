package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A SygSourceFinancement.
 */
@Entity
@Table(name = "syg_source_financement")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SygSourceFinancement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "libelle", nullable = false)
    private String libelle;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "sygSourceFinancements", allowSetters = true)
    private SygTypeSourceFinancement sygTypeSourceFinancement;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public SygSourceFinancement libelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public SygTypeSourceFinancement getSygTypeSourceFinancement() {
        return sygTypeSourceFinancement;
    }

    public SygSourceFinancement sygTypeSourceFinancement(SygTypeSourceFinancement sygTypeSourceFinancement) {
        this.sygTypeSourceFinancement = sygTypeSourceFinancement;
        return this;
    }

    public void setSygTypeSourceFinancement(SygTypeSourceFinancement sygTypeSourceFinancement) {
        this.sygTypeSourceFinancement = sygTypeSourceFinancement;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SygSourceFinancement)) {
            return false;
        }
        return id != null && id.equals(((SygSourceFinancement) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SygSourceFinancement{" +
            "id=" + getId() +
            ", libelle='" + getLibelle() + "'" +
            "}";
    }
}
