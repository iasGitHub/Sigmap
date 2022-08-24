package sn.ssi.sigmap.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.SygService} entity.
 */
public class SygServiceDTO implements Serializable {
    
    private Long id;

    @NotNull
    private String code;

    @NotNull
    private String libelle;

    private String description;


    private Long sygTypeServiceId;

    private String sygTypeServiceLibelle;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSygTypeServiceId() {
        return sygTypeServiceId;
    }

    public void setSygTypeServiceId(Long sygTypeServiceId) {
        this.sygTypeServiceId = sygTypeServiceId;
    }

    public String getSygTypeServiceLibelle() {
        return sygTypeServiceLibelle;
    }

    public void setSygTypeServiceLibelle(String sygTypeServiceLibelle) {
        this.sygTypeServiceLibelle = sygTypeServiceLibelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SygServiceDTO)) {
            return false;
        }

        return id != null && id.equals(((SygServiceDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SygServiceDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", libelle='" + getLibelle() + "'" +
            ", description='" + getDescription() + "'" +
            ", sygTypeServiceId=" + getSygTypeServiceId() +
            ", sygTypeServiceLibelle='" + getSygTypeServiceLibelle() + "'" +
            "}";
    }
}
