package sn.ssi.sigmap.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.Realisation} entity.
 */
public class RealisationDTO implements Serializable {
    
    private Long id;

    private String libelle;

    @NotNull
    private LocalDate dateAttribution;

    @NotNull
    private Integer delaiexecution;

    private String objet;

    private BigDecimal montant;

    @NotNull
    private Integer examenDncmp;

    @NotNull
    private Integer examenPtf;

    @NotNull
    private String chapitreImputation;

    @NotNull
    private String autorisationEngagement;

    @NotNull
    private LocalDate dateReceptionDossier;

    @NotNull
    private LocalDate dateNonObjection;

    @NotNull
    private LocalDate dateAutorisation;

    @NotNull
    private LocalDate dateRecepNonObjection;

    @NotNull
    private LocalDate dateRecepDossCorrige;

    @NotNull
    private LocalDate datePubParPrmp;

    @NotNull
    private LocalDate dateOuverturePlis;

    @NotNull
    private LocalDate dateRecepNonObjectOcmp;

    @NotNull
    private LocalDate dateRecepRapportEva;

    @NotNull
    private LocalDate dateRecepNonObjectPtf;

    @NotNull
    private LocalDate dateExamenJuridique;

    @NotNull
    private LocalDate dateNotifContrat;

    @NotNull
    private LocalDate dateApprobationContrat;


    private Long planPassationId;
    
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

    public LocalDate getDateAttribution() {
        return dateAttribution;
    }

    public void setDateAttribution(LocalDate dateAttribution) {
        this.dateAttribution = dateAttribution;
    }

    public Integer getDelaiexecution() {
        return delaiexecution;
    }

    public void setDelaiexecution(Integer delaiexecution) {
        this.delaiexecution = delaiexecution;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Integer getExamenDncmp() {
        return examenDncmp;
    }

    public void setExamenDncmp(Integer examenDncmp) {
        this.examenDncmp = examenDncmp;
    }

    public Integer getExamenPtf() {
        return examenPtf;
    }

    public void setExamenPtf(Integer examenPtf) {
        this.examenPtf = examenPtf;
    }

    public String getChapitreImputation() {
        return chapitreImputation;
    }

    public void setChapitreImputation(String chapitreImputation) {
        this.chapitreImputation = chapitreImputation;
    }

    public String getAutorisationEngagement() {
        return autorisationEngagement;
    }

    public void setAutorisationEngagement(String autorisationEngagement) {
        this.autorisationEngagement = autorisationEngagement;
    }

    public LocalDate getDateReceptionDossier() {
        return dateReceptionDossier;
    }

    public void setDateReceptionDossier(LocalDate dateReceptionDossier) {
        this.dateReceptionDossier = dateReceptionDossier;
    }

    public LocalDate getDateNonObjection() {
        return dateNonObjection;
    }

    public void setDateNonObjection(LocalDate dateNonObjection) {
        this.dateNonObjection = dateNonObjection;
    }

    public LocalDate getDateAutorisation() {
        return dateAutorisation;
    }

    public void setDateAutorisation(LocalDate dateAutorisation) {
        this.dateAutorisation = dateAutorisation;
    }

    public LocalDate getDateRecepNonObjection() {
        return dateRecepNonObjection;
    }

    public void setDateRecepNonObjection(LocalDate dateRecepNonObjection) {
        this.dateRecepNonObjection = dateRecepNonObjection;
    }

    public LocalDate getDateRecepDossCorrige() {
        return dateRecepDossCorrige;
    }

    public void setDateRecepDossCorrige(LocalDate dateRecepDossCorrige) {
        this.dateRecepDossCorrige = dateRecepDossCorrige;
    }

    public LocalDate getDatePubParPrmp() {
        return datePubParPrmp;
    }

    public void setDatePubParPrmp(LocalDate datePubParPrmp) {
        this.datePubParPrmp = datePubParPrmp;
    }

    public LocalDate getDateOuverturePlis() {
        return dateOuverturePlis;
    }

    public void setDateOuverturePlis(LocalDate dateOuverturePlis) {
        this.dateOuverturePlis = dateOuverturePlis;
    }

    public LocalDate getDateRecepNonObjectOcmp() {
        return dateRecepNonObjectOcmp;
    }

    public void setDateRecepNonObjectOcmp(LocalDate dateRecepNonObjectOcmp) {
        this.dateRecepNonObjectOcmp = dateRecepNonObjectOcmp;
    }

    public LocalDate getDateRecepRapportEva() {
        return dateRecepRapportEva;
    }

    public void setDateRecepRapportEva(LocalDate dateRecepRapportEva) {
        this.dateRecepRapportEva = dateRecepRapportEva;
    }

    public LocalDate getDateRecepNonObjectPtf() {
        return dateRecepNonObjectPtf;
    }

    public void setDateRecepNonObjectPtf(LocalDate dateRecepNonObjectPtf) {
        this.dateRecepNonObjectPtf = dateRecepNonObjectPtf;
    }

    public LocalDate getDateExamenJuridique() {
        return dateExamenJuridique;
    }

    public void setDateExamenJuridique(LocalDate dateExamenJuridique) {
        this.dateExamenJuridique = dateExamenJuridique;
    }

    public LocalDate getDateNotifContrat() {
        return dateNotifContrat;
    }

    public void setDateNotifContrat(LocalDate dateNotifContrat) {
        this.dateNotifContrat = dateNotifContrat;
    }

    public LocalDate getDateApprobationContrat() {
        return dateApprobationContrat;
    }

    public void setDateApprobationContrat(LocalDate dateApprobationContrat) {
        this.dateApprobationContrat = dateApprobationContrat;
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
        if (!(o instanceof RealisationDTO)) {
            return false;
        }

        return id != null && id.equals(((RealisationDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RealisationDTO{" +
            "id=" + getId() +
            ", libelle='" + getLibelle() + "'" +
            ", dateAttribution='" + getDateAttribution() + "'" +
            ", delaiexecution=" + getDelaiexecution() +
            ", objet='" + getObjet() + "'" +
            ", montant=" + getMontant() +
            ", examenDncmp=" + getExamenDncmp() +
            ", examenPtf=" + getExamenPtf() +
            ", chapitreImputation='" + getChapitreImputation() + "'" +
            ", autorisationEngagement='" + getAutorisationEngagement() + "'" +
            ", dateReceptionDossier='" + getDateReceptionDossier() + "'" +
            ", dateNonObjection='" + getDateNonObjection() + "'" +
            ", dateAutorisation='" + getDateAutorisation() + "'" +
            ", dateRecepNonObjection='" + getDateRecepNonObjection() + "'" +
            ", dateRecepDossCorrige='" + getDateRecepDossCorrige() + "'" +
            ", datePubParPrmp='" + getDatePubParPrmp() + "'" +
            ", dateOuverturePlis='" + getDateOuverturePlis() + "'" +
            ", dateRecepNonObjectOcmp='" + getDateRecepNonObjectOcmp() + "'" +
            ", dateRecepRapportEva='" + getDateRecepRapportEva() + "'" +
            ", dateRecepNonObjectPtf='" + getDateRecepNonObjectPtf() + "'" +
            ", dateExamenJuridique='" + getDateExamenJuridique() + "'" +
            ", dateNotifContrat='" + getDateNotifContrat() + "'" +
            ", dateApprobationContrat='" + getDateApprobationContrat() + "'" +
            ", planPassationId=" + getPlanPassationId() +
            "}";
    }
}
