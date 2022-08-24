package sn.ssi.sigmap.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.SygTypeSourceFinancement} entity.
 */
public class SygTypeSourceFinancementDTO implements Serializable {
    
    private Long id;

    @NotNull
    private String libelle;

    
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SygTypeSourceFinancementDTO)) {
            return false;
        }

        return id != null && id.equals(((SygTypeSourceFinancementDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SygTypeSourceFinancementDTO{" +
            "id=" + getId() +
            ", libelle='" + getLibelle() + "'" +
            "}";
    }
}
