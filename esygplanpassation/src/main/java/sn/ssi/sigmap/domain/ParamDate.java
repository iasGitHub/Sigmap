package sn.ssi.sigmap.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A ParamDate.
 */
@Entity
@Table(name = "param_date")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ParamDate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "date_creat")
    private LocalDate dateCreat;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateCreat() {
        return dateCreat;
    }

    public ParamDate dateCreat(LocalDate dateCreat) {
        this.dateCreat = dateCreat;
        return this;
    }

    public void setDateCreat(LocalDate dateCreat) {
        this.dateCreat = dateCreat;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ParamDate)) {
            return false;
        }
        return id != null && id.equals(((ParamDate) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ParamDate{" +
            "id=" + getId() +
            ", dateCreat='" + getDateCreat() + "'" +
            "}";
    }
}
