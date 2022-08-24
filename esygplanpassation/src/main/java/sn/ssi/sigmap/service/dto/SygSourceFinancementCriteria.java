package sn.ssi.sigmap.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link sn.ssi.sigmap.domain.SygSourceFinancement} entity. This class is used
 * in {@link sn.ssi.sigmap.web.rest.SygSourceFinancementResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /syg-source-financements?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class SygSourceFinancementCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter libelle;

    private LongFilter sygTypeSourceFinancementId;

    public SygSourceFinancementCriteria() {
    }

    public SygSourceFinancementCriteria(SygSourceFinancementCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.libelle = other.libelle == null ? null : other.libelle.copy();
        this.sygTypeSourceFinancementId = other.sygTypeSourceFinancementId == null ? null : other.sygTypeSourceFinancementId.copy();
    }

    @Override
    public SygSourceFinancementCriteria copy() {
        return new SygSourceFinancementCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getLibelle() {
        return libelle;
    }

    public void setLibelle(StringFilter libelle) {
        this.libelle = libelle;
    }

    public LongFilter getSygTypeSourceFinancementId() {
        return sygTypeSourceFinancementId;
    }

    public void setSygTypeSourceFinancementId(LongFilter sygTypeSourceFinancementId) {
        this.sygTypeSourceFinancementId = sygTypeSourceFinancementId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SygSourceFinancementCriteria that = (SygSourceFinancementCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(libelle, that.libelle) &&
            Objects.equals(sygTypeSourceFinancementId, that.sygTypeSourceFinancementId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        libelle,
        sygTypeSourceFinancementId
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SygSourceFinancementCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (libelle != null ? "libelle=" + libelle + ", " : "") +
                (sygTypeSourceFinancementId != null ? "sygTypeSourceFinancementId=" + sygTypeSourceFinancementId + ", " : "") +
            "}";
    }

}
