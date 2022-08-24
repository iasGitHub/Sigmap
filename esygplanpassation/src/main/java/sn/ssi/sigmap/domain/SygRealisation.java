package sn.ssi.sigmap.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A SygRealisation.
 */
@Entity
@Table(name = "syg_realisation")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SygRealisation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "libelle", nullable = false)
    private String libelle;

    @NotNull
    @Column(name = "date_attribution", nullable = false)
    private LocalDate dateAttribution;

    @Column(name = "delaiexecution")
    private Integer delaiexecution;

    @Column(name = "objet")
    private String objet;

    @Column(name = "montant", precision = 21, scale = 2)
    private BigDecimal montant;

    @Column(name = "examen_dncmp")
    private Integer examenDncmp;

    @Column(name = "examen_ptf")
    private Integer examenPtf;

    @Column(name = "chapitre_imputation")
    private String chapitreImputation;

    @Column(name = "autorisation_engagement")
    private String autorisationEngagement;

    @Column(name = "date_reception_dossier")
    private LocalDate dateReceptionDossier;

    @Column(name = "date_non_objection")
    private LocalDate dateNonObjection;

    @Column(name = "date_autorisation")
    private LocalDate dateAutorisation;

    @Column(name = "date_recep_non_objection")
    private LocalDate dateRecepNonObjection;

    @Column(name = "date_recep_doss_corrige")
    private LocalDate dateRecepDossCorrige;

    @Column(name = "date_pub_par_prmp")
    private LocalDate datePubParPrmp;

    @Column(name = "date_ouverture_plis")
    private LocalDate dateOuverturePlis;

    @Column(name = "date_recep_non_object_ocmp")
    private LocalDate dateRecepNonObjectOcmp;

    @Column(name = "date_recep_rapport_eva")
    private LocalDate dateRecepRapportEva;

    @Column(name = "date_recep_non_object_ptf")
    private LocalDate dateRecepNonObjectPtf;

    @Column(name = "date_examen_juridique")
    private LocalDate dateExamenJuridique;

    @Column(name = "date_notif_contrat")
    private LocalDate dateNotifContrat;

    @Column(name = "date_approbation_contrat")
    private LocalDate dateApprobationContrat;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public SygRealisation libelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public LocalDate getDateAttribution() {
        return dateAttribution;
    }

    public SygRealisation dateAttribution(LocalDate dateAttribution) {
        this.dateAttribution = dateAttribution;
        return this;
    }

    public void setDateAttribution(LocalDate dateAttribution) {
        this.dateAttribution = dateAttribution;
    }

    public Integer getDelaiexecution() {
        return delaiexecution;
    }

    public SygRealisation delaiexecution(Integer delaiexecution) {
        this.delaiexecution = delaiexecution;
        return this;
    }

    public void setDelaiexecution(Integer delaiexecution) {
        this.delaiexecution = delaiexecution;
    }

    public String getObjet() {
        return objet;
    }

    public SygRealisation objet(String objet) {
        this.objet = objet;
        return this;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public SygRealisation montant(BigDecimal montant) {
        this.montant = montant;
        return this;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Integer getExamenDncmp() {
        return examenDncmp;
    }

    public SygRealisation examenDncmp(Integer examenDncmp) {
        this.examenDncmp = examenDncmp;
        return this;
    }

    public void setExamenDncmp(Integer examenDncmp) {
        this.examenDncmp = examenDncmp;
    }

    public Integer getExamenPtf() {
        return examenPtf;
    }

    public SygRealisation examenPtf(Integer examenPtf) {
        this.examenPtf = examenPtf;
        return this;
    }

    public void setExamenPtf(Integer examenPtf) {
        this.examenPtf = examenPtf;
    }

    public String getChapitreImputation() {
        return chapitreImputation;
    }

    public SygRealisation chapitreImputation(String chapitreImputation) {
        this.chapitreImputation = chapitreImputation;
        return this;
    }

    public void setChapitreImputation(String chapitreImputation) {
        this.chapitreImputation = chapitreImputation;
    }

    public String getAutorisationEngagement() {
        return autorisationEngagement;
    }

    public SygRealisation autorisationEngagement(String autorisationEngagement) {
        this.autorisationEngagement = autorisationEngagement;
        return this;
    }

    public void setAutorisationEngagement(String autorisationEngagement) {
        this.autorisationEngagement = autorisationEngagement;
    }

    public LocalDate getDateReceptionDossier() {
        return dateReceptionDossier;
    }

    public SygRealisation dateReceptionDossier(LocalDate dateReceptionDossier) {
        this.dateReceptionDossier = dateReceptionDossier;
        return this;
    }

    public void setDateReceptionDossier(LocalDate dateReceptionDossier) {
        this.dateReceptionDossier = dateReceptionDossier;
    }

    public LocalDate getDateNonObjection() {
        return dateNonObjection;
    }

    public SygRealisation dateNonObjection(LocalDate dateNonObjection) {
        this.dateNonObjection = dateNonObjection;
        return this;
    }

    public void setDateNonObjection(LocalDate dateNonObjection) {
        this.dateNonObjection = dateNonObjection;
    }

    public LocalDate getDateAutorisation() {
        return dateAutorisation;
    }

    public SygRealisation dateAutorisation(LocalDate dateAutorisation) {
        this.dateAutorisation = dateAutorisation;
        return this;
    }

    public void setDateAutorisation(LocalDate dateAutorisation) {
        this.dateAutorisation = dateAutorisation;
    }

    public LocalDate getDateRecepNonObjection() {
        return dateRecepNonObjection;
    }

    public SygRealisation dateRecepNonObjection(LocalDate dateRecepNonObjection) {
        this.dateRecepNonObjection = dateRecepNonObjection;
        return this;
    }

    public void setDateRecepNonObjection(LocalDate dateRecepNonObjection) {
        this.dateRecepNonObjection = dateRecepNonObjection;
    }

    public LocalDate getDateRecepDossCorrige() {
        return dateRecepDossCorrige;
    }

    public SygRealisation dateRecepDossCorrige(LocalDate dateRecepDossCorrige) {
        this.dateRecepDossCorrige = dateRecepDossCorrige;
        return this;
    }

    public void setDateRecepDossCorrige(LocalDate dateRecepDossCorrige) {
        this.dateRecepDossCorrige = dateRecepDossCorrige;
    }

    public LocalDate getDatePubParPrmp() {
        return datePubParPrmp;
    }

    public SygRealisation datePubParPrmp(LocalDate datePubParPrmp) {
        this.datePubParPrmp = datePubParPrmp;
        return this;
    }

    public void setDatePubParPrmp(LocalDate datePubParPrmp) {
        this.datePubParPrmp = datePubParPrmp;
    }

    public LocalDate getDateOuverturePlis() {
        return dateOuverturePlis;
    }

    public SygRealisation dateOuverturePlis(LocalDate dateOuverturePlis) {
        this.dateOuverturePlis = dateOuverturePlis;
        return this;
    }

    public void setDateOuverturePlis(LocalDate dateOuverturePlis) {
        this.dateOuverturePlis = dateOuverturePlis;
    }

    public LocalDate getDateRecepNonObjectOcmp() {
        return dateRecepNonObjectOcmp;
    }

    public SygRealisation dateRecepNonObjectOcmp(LocalDate dateRecepNonObjectOcmp) {
        this.dateRecepNonObjectOcmp = dateRecepNonObjectOcmp;
        return this;
    }

    public void setDateRecepNonObjectOcmp(LocalDate dateRecepNonObjectOcmp) {
        this.dateRecepNonObjectOcmp = dateRecepNonObjectOcmp;
    }

    public LocalDate getDateRecepRapportEva() {
        return dateRecepRapportEva;
    }

    public SygRealisation dateRecepRapportEva(LocalDate dateRecepRapportEva) {
        this.dateRecepRapportEva = dateRecepRapportEva;
        return this;
    }

    public void setDateRecepRapportEva(LocalDate dateRecepRapportEva) {
        this.dateRecepRapportEva = dateRecepRapportEva;
    }

    public LocalDate getDateRecepNonObjectPtf() {
        return dateRecepNonObjectPtf;
    }

    public SygRealisation dateRecepNonObjectPtf(LocalDate dateRecepNonObjectPtf) {
        this.dateRecepNonObjectPtf = dateRecepNonObjectPtf;
        return this;
    }

    public void setDateRecepNonObjectPtf(LocalDate dateRecepNonObjectPtf) {
        this.dateRecepNonObjectPtf = dateRecepNonObjectPtf;
    }

    public LocalDate getDateExamenJuridique() {
        return dateExamenJuridique;
    }

    public SygRealisation dateExamenJuridique(LocalDate dateExamenJuridique) {
        this.dateExamenJuridique = dateExamenJuridique;
        return this;
    }

    public void setDateExamenJuridique(LocalDate dateExamenJuridique) {
        this.dateExamenJuridique = dateExamenJuridique;
    }

    public LocalDate getDateNotifContrat() {
        return dateNotifContrat;
    }

    public SygRealisation dateNotifContrat(LocalDate dateNotifContrat) {
        this.dateNotifContrat = dateNotifContrat;
        return this;
    }

    public void setDateNotifContrat(LocalDate dateNotifContrat) {
        this.dateNotifContrat = dateNotifContrat;
    }

    public LocalDate getDateApprobationContrat() {
        return dateApprobationContrat;
    }

    public SygRealisation dateApprobationContrat(LocalDate dateApprobationContrat) {
        this.dateApprobationContrat = dateApprobationContrat;
        return this;
    }

    public void setDateApprobationContrat(LocalDate dateApprobationContrat) {
        this.dateApprobationContrat = dateApprobationContrat;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SygRealisation)) {
            return false;
        }
        return id != null && id.equals(((SygRealisation) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SygRealisation{" +
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
            "}";
    }
}
