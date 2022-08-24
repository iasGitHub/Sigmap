package sn.ssi.sigmap.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.SygSourceFinancement} entity.
 */
public class SygSourceFinancementDTO implements Serializable {
    
    private Long id;

    @NotNull
    private String libelle;


    private Long sygTypeSourceFinancementId;

    private String sygTypeSourceFinancementLibelle;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Long getSygTypeSourceFinancementId() {
        return sygTypeSourceFinancementId;
    }

    public void setSygTypeSourceFinancementId(Long sygTypeSourceFinancementId) {
        this.sygTypeSourceFinancementId = sygTypeSourceFinancementId;
    }

    public String getSygTypeSourceFinancementLibelle() {
        return sygTypeSourceFinancementLibelle;
    }

    public void setSygTypeSourceFinancementLibelle(String sygTypeSourceFinancementLibelle) {
        this.sygTypeSourceFinancementLibelle = sygTypeSourceFinancementLibelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SygSourceFinancementDTO)) {
            return false;
        }

        return id != null && id.equals(((SygSourceFinancementDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SygSourceFinancementDTO{" +
            "id=" + getId() +
            ", libelle='" + getLibelle() + "'" +
            ", sygTypeSourceFinancementId=" + getSygTypeSourceFinancementId() +
            ", sygTypeSourceFinancementLibelle='" + getSygTypeSourceFinancementLibelle() + "'" +
            "}";
    }
}
