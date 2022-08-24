package sn.ssi.sigmap.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import javax.persistence.Lob;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.Historique} entity.
 */
public class HistoriqueDTO implements Serializable {
    
    private Long id;

    private LocalDate dateRejet;

    private LocalDate dateRjet2;

    private LocalDate dateMiseValidation;

    private String commentaireRejet;

    private String commentaireMiseValidation;

    @Lob
    private byte[] fichierMiseValidation;

    private String fichierMiseValidationContentType;
    @Lob
    private byte[] fichierRejet;

    private String fichierRejetContentType;
    private String etat;

    private String etat2;

    private String commentaireRejet2;

    @Lob
    private byte[] fichierRejet2;

    private String fichierRejet2ContentType;

    private Long planPassationId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateRejet() {
        return dateRejet;
    }

    public void setDateRejet(LocalDate dateRejet) {
        this.dateRejet = dateRejet;
    }

    public LocalDate getDateRjet2() {
        return dateRjet2;
    }

    public void setDateRjet2(LocalDate dateRjet2) {
        this.dateRjet2 = dateRjet2;
    }

    public LocalDate getDateMiseValidation() {
        return dateMiseValidation;
    }

    public void setDateMiseValidation(LocalDate dateMiseValidation) {
        this.dateMiseValidation = dateMiseValidation;
    }

    public String getCommentaireRejet() {
        return commentaireRejet;
    }

    public void setCommentaireRejet(String commentaireRejet) {
        this.commentaireRejet = commentaireRejet;
    }

    public String getCommentaireMiseValidation() {
        return commentaireMiseValidation;
    }

    public void setCommentaireMiseValidation(String commentaireMiseValidation) {
        this.commentaireMiseValidation = commentaireMiseValidation;
    }

    public byte[] getFichierMiseValidation() {
        return fichierMiseValidation;
    }

    public void setFichierMiseValidation(byte[] fichierMiseValidation) {
        this.fichierMiseValidation = fichierMiseValidation;
    }

    public String getFichierMiseValidationContentType() {
        return fichierMiseValidationContentType;
    }

    public void setFichierMiseValidationContentType(String fichierMiseValidationContentType) {
        this.fichierMiseValidationContentType = fichierMiseValidationContentType;
    }

    public byte[] getFichierRejet() {
        return fichierRejet;
    }

    public void setFichierRejet(byte[] fichierRejet) {
        this.fichierRejet = fichierRejet;
    }

    public String getFichierRejetContentType() {
        return fichierRejetContentType;
    }

    public void setFichierRejetContentType(String fichierRejetContentType) {
        this.fichierRejetContentType = fichierRejetContentType;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getEtat2() {
        return etat2;
    }

    public void setEtat2(String etat2) {
        this.etat2 = etat2;
    }

    public String getCommentaireRejet2() {
        return commentaireRejet2;
    }

    public void setCommentaireRejet2(String commentaireRejet2) {
        this.commentaireRejet2 = commentaireRejet2;
    }

    public byte[] getFichierRejet2() {
        return fichierRejet2;
    }

    public void setFichierRejet2(byte[] fichierRejet2) {
        this.fichierRejet2 = fichierRejet2;
    }

    public String getFichierRejet2ContentType() {
        return fichierRejet2ContentType;
    }

    public void setFichierRejet2ContentType(String fichierRejet2ContentType) {
        this.fichierRejet2ContentType = fichierRejet2ContentType;
    }

    public Long getPlanPassationId() {
        return planPassationId;
    }

    public void setPlanPassationId(Long planPassationId) {
        this.planPassationId = planPassationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HistoriqueDTO)) {
            return false;
        }

        return id != null && id.equals(((HistoriqueDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "HistoriqueDTO{" +
            "id=" + getId() +
            ", dateRejet='" + getDateRejet() + "'" +
            ", dateRjet2='" + getDateRjet2() + "'" +
            ", dateMiseValidation='" + getDateMiseValidation() + "'" +
            ", commentaireRejet='" + getCommentaireRejet() + "'" +
            ", commentaireMiseValidation='" + getCommentaireMiseValidation() + "'" +
            ", fichierMiseValidation='" + getFichierMiseValidation() + "'" +
            ", fichierRejet='" + getFichierRejet() + "'" +
            ", etat='" + getEtat() + "'" +
            ", etat2='" + getEtat2() + "'" +
            ", commentaireRejet2='" + getCommentaireRejet2() + "'" +
            ", fichierRejet2='" + getFichierRejet2() + "'" +
            ", planPassationId=" + getPlanPassationId() +
            "}";
    }
}
