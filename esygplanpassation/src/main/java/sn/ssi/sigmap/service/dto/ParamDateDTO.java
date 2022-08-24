package sn.ssi.sigmap.service.dto;

import java.time.LocalDate;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.ParamDate} entity.
 */
public class ParamDateDTO implements Serializable {
    
    private Long id;

    private LocalDate dateCreat;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateCreat() {
        return dateCreat;
    }

    public void setDateCreat(LocalDate dateCreat) {
        this.dateCreat = dateCreat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ParamDateDTO)) {
            return false;
        }

        return id != null && id.equals(((ParamDateDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ParamDateDTO{" +
            "id=" + getId() +
            ", dateCreat='" + getDateCreat() + "'" +
            "}";
    }
}
