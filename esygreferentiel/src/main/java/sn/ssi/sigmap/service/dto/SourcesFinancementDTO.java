package sn.ssi.sigmap.service.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class SourcesFinancementDTO implements Serializable{

    private Long id;

    @NotNull
    private String code;

    @NotNull
    private String libelle;

    @NotNull
    private String corbeille;

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

    public String getCorbeille() {
        return corbeille;
    }

    public void setCorbeille(String corbeille) {
        this.corbeille = corbeille;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SourcesFinancementDTO)) {
            return false;
        }

        SourcesFinancementDTO sourcesFinancementDTO = (SourcesFinancementDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, sourcesFinancementDTO.id);
    }


    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SourcesFinancementDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", libelle='" + getLibelle() + "'" +
            ", corbeille=" + getCorbeille() +
            "}";
    }

}
