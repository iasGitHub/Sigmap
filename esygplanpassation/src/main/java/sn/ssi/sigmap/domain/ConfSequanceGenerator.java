package sn.ssi.sigmap.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A ConfSequanceGenerator.
 */
@Entity
@Table(name = "conf_sequance_generator")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ConfSequanceGenerator implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 100)
    @Column(name = "nom_table", length = 100)
    private String nomTable;

    @Column(name = "current_value")
    private Long currentValue;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomTable() {
        return nomTable;
    }

    public ConfSequanceGenerator nomTable(String nomTable) {
        this.nomTable = nomTable;
        return this;
    }

    public void setNomTable(String nomTable) {
        this.nomTable = nomTable;
    }

    public Long getCurrentValue() {
        return currentValue;
    }

    public ConfSequanceGenerator currentValue(Long currentValue) {
        this.currentValue = currentValue;
        return this;
    }

    public void setCurrentValue(Long currentValue) {
        this.currentValue = currentValue;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConfSequanceGenerator)) {
            return false;
        }
        return id != null && id.equals(((ConfSequanceGenerator) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ConfSequanceGenerator{" +
            "id=" + getId() +
            ", nomTable='" + getNomTable() + "'" +
            ", currentValue=" + getCurrentValue() +
            "}";
    }
}
