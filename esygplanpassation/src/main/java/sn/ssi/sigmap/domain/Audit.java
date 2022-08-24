package sn.ssi.sigmap.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Audit.
 */
@Entity
@Table(name = "audit")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Audit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "type_connexion")
    private String typeConnexion;

    @Column(name = "entite")
    private String entite;

    @Column(name = "message")
    private String message;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Audit date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTypeConnexion() {
        return typeConnexion;
    }

    public Audit typeConnexion(String typeConnexion) {
        this.typeConnexion = typeConnexion;
        return this;
    }

    public void setTypeConnexion(String typeConnexion) {
        this.typeConnexion = typeConnexion;
    }

    public String getEntite() {
        return entite;
    }

    public Audit entite(String entite) {
        this.entite = entite;
        return this;
    }

    public void setEntite(String entite) {
        this.entite = entite;
    }

    public String getMessage() {
        return message;
    }

    public Audit message(String message) {
        this.message = message;
        return this;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Audit)) {
            return false;
        }
        return id != null && id.equals(((Audit) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Audit{" +
            "id=" + getId() +
            ", date='" + getDate() + "'" +
            ", typeConnexion='" + getTypeConnexion() + "'" +
            ", entite='" + getEntite() + "'" +
            ", message='" + getMessage() + "'" +
            "}";
    }
}
