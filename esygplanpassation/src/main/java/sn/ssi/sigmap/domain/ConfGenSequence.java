package sn.ssi.sigmap.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A ConfGenSequence.
 */
@Entity
@Table(name = "conf_gen_sequence")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ConfGenSequence implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 100)
    @Column(name = "table_name", length = 100)
    private String tableName;

    @Column(name = "current_value")
    private Long currentValue;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public ConfGenSequence tableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getCurrentValue() {
        return currentValue;
    }

    public ConfGenSequence currentValue(Long currentValue) {
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
        if (!(o instanceof ConfGenSequence)) {
            return false;
        }
        return id != null && id.equals(((ConfGenSequence) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ConfGenSequence{" +
            "id=" + getId() +
            ", tableName='" + getTableName() + "'" +
            ", currentValue=" + getCurrentValue() +
            "}";
    }
}
