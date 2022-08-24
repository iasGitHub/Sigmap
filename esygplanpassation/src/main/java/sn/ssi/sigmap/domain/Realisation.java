package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A Realisation.
 */
@Entity
@Table(name = "realisation")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Realisation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "libelle")
    private String libelle;

    @NotNull
    @Column(name = "date_attribution", nullable = false)
    private LocalDate dateAttribution;

    @NotNull
    @Column(name = "delaiexecution", nullable = false)
    private Integer delaiexecution;

    @Column(name = "objet")
    private String objet;

    @Column(name = "montant", precision = 21, scale = 2)
    private BigDecimal montant;

    @NotNull
    @Column(name = "examen_dncmp", nullable = false)
    private Integer examenDncmp;

    @NotNull
    @Column(name = "examen_ptf", nullable = false)
    private Integer examenPtf;

    @NotNull
    @Column(name = "chapitre_imputation", nullable = false)
    private String chapitreImputation;

    @NotNull
    @Column(name = "autorisation_engagement", nullable = false)
    private String autorisationEngagement;

    @NotNull
    @Column(name = "date_reception_dossier", nullable = false)
    private LocalDate dateReceptionDossier;

    @NotNull
    @Column(name = "date_non_objection", nullable = false)
    private LocalDate dateNonObjection;

    @NotNull
    @Column(name = "date_autorisation", nullable = false)
    private LocalDate dateAutorisation;

    @NotNull
    @Column(name = "date_recep_non_objection", nullable = false)
    private LocalDate dateRecepNonObjection;

    @NotNull
    @Column(name = "date_recep_doss_corrige", nullable = false)
    private LocalDate dateRecepDossCorrige;

    @NotNull
    @Column(name = "date_pub_par_prmp", nullable = false)
    private LocalDate datePubParPrmp;

    @NotNull
    @Column(name = "date_ouverture_plis", nullable = false)
    private LocalDate dateOuverturePlis;

    @NotNull
    @Column(name = "date_recep_non_object_ocmp", nullable = false)
    private LocalDate dateRecepNonObjectOcmp;

    @NotNull
    @Column(name = "date_recep_rapport_eva", nullable = false)
    private LocalDate dateRecepRapportEva;

    @NotNull
    @Column(name = "date_recep_non_object_ptf", nullable = false)
    private LocalDate dateRecepNonObjectPtf;

    @NotNull
    @Column(name = "date_examen_juridique", nullable = false)
    private LocalDate dateExamenJuridique;

    @NotNull
    @Column(name = "date_notif_contrat", nullable = false)
    private LocalDate dateNotifContrat;

    @NotNull
    @Column(name = "date_approbation_contrat", nullable = false)
    private LocalDate dateApprobationContrat;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "realisations", allowSetters = true)
    private PlanPassation planPassation;

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

    public Realisation libelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public LocalDate getDateAttribution() {
        return dateAttribution;
    }

    public Realisation dateAttribution(LocalDate dateAttribution) {
        this.dateAttribution = dateAttribution;
        return this;
    }

    public void setDateAttribution(LocalDate dateAttribution) {
        this.dateAttribution = dateAttribution;
    }

    public Integer getDelaiexecution() {
        return delaiexecution;
    }

    public Realisation delaiexecution(Integer delaiexecution) {
        this.delaiexecution = delaiexecution;
        return this;
    }

    public void setDelaiexecution(Integer delaiexecution) {
        this.delaiexecution = delaiexecution;
    }

    public String getObjet() {
        return objet;
    }

    public Realisation objet(String objet) {
        this.objet = objet;
        return this;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public Realisation montant(BigDecimal montant) {
        this.montant = montant;
        return this;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Integer getExamenDncmp() {
        return examenDncmp;
    }

    public Realisation examenDncmp(Integer examenDncmp) {
        this.examenDncmp = examenDncmp;
        return this;
    }

    public void setExamenDncmp(Integer examenDncmp) {
        this.examenDncmp = examenDncmp;
    }

    public Integer getExamenPtf() {
        return examenPtf;
    }

    public Realisation examenPtf(Integer examenPtf) {
        this.examenPtf = examenPtf;
        return this;
    }

    public void setExamenPtf(Integer examenPtf) {
        this.examenPtf = examenPtf;
    }

    public String getChapitreImputation() {
        return chapitreImputation;
    }

    public Realisation chapitreImputation(String chapitreImputation) {
        this.chapitreImputation = chapitreImputation;
        return this;
    }

    public void setChapitreImputation(String chapitreImputation) {
        this.chapitreImputation = chapitreImputation;
    }

    public String getAutorisationEngagement() {
        return autorisationEngagement;
    }

    public Realisation autorisationEngagement(String autorisationEngagement) {
        this.autorisationEngagement = autorisationEngagement;
        return this;
    }

    public void setAutorisationEngagement(String autorisationEngagement) {
        this.autorisationEngagement = autorisationEngagement;
    }

    public LocalDate getDateReceptionDossier() {
        return dateReceptionDossier;
    }

    public Realisation dateReceptionDossier(LocalDate dateReceptionDossier) {
        this.dateReceptionDossier = dateReceptionDossier;
        return this;
    }

    public void setDateReceptionDossier(LocalDate dateReceptionDossier) {
        this.dateReceptionDossier = dateReceptionDossier;
    }

    public LocalDate getDateNonObjection() {
        return dateNonObjection;
    }

    public Realisation dateNonObjection(LocalDate dateNonObjection) {
        this.dateNonObjection = dateNonObjection;
        return this;
    }

    public void setDateNonObjection(LocalDate dateNonObjection) {
        this.dateNonObjection = dateNonObjection;
    }

    public LocalDate getDateAutorisation() {
        return dateAutorisation;
    }

    public Realisation dateAutorisation(LocalDate dateAutorisation) {
        this.dateAutorisation = dateAutorisation;
        return this;
    }

    public void setDateAutorisation(LocalDate dateAutorisation) {
        this.dateAutorisation = dateAutorisation;
    }

    public LocalDate getDateRecepNonObjection() {
        return dateRecepNonObjection;
    }

    public Realisation dateRecepNonObjection(LocalDate dateRecepNonObjection) {
        this.dateRecepNonObjection = dateRecepNonObjection;
        return this;
    }

    public void setDateRecepNonObjection(LocalDate dateRecepNonObjection) {
        this.dateRecepNonObjection = dateRecepNonObjection;
    }

    public LocalDate getDateRecepDossCorrige() {
        return dateRecepDossCorrige;
    }

    public Realisation dateRecepDossCorrige(LocalDate dateRecepDossCorrige) {
        this.dateRecepDossCorrige = dateRecepDossCorrige;
        return this;
    }

    public void setDateRecepDossCorrige(LocalDate dateRecepDossCorrige) {
        this.dateRecepDossCorrige = dateRecepDossCorrige;
    }

    public LocalDate getDatePubParPrmp() {
        return datePubParPrmp;
    }

    public Realisation datePubParPrmp(LocalDate datePubParPrmp) {
        this.datePubParPrmp = datePubParPrmp;
        return this;
    }

    public void setDatePubParPrmp(LocalDate datePubParPrmp) {
        this.datePubParPrmp = datePubParPrmp;
    }

    public LocalDate getDateOuverturePlis() {
        return dateOuverturePlis;
    }

    public Realisation dateOuverturePlis(LocalDate dateOuverturePlis) {
        this.dateOuverturePlis = dateOuverturePlis;
        return this;
    }

    public void setDateOuverturePlis(LocalDate dateOuverturePlis) {
        this.dateOuverturePlis = dateOuverturePlis;
    }

    public LocalDate getDateRecepNonObjectOcmp() {
        return dateRecepNonObjectOcmp;
    }

    public Realisation dateRecepNonObjectOcmp(LocalDate dateRecepNonObjectOcmp) {
        this.dateRecepNonObjectOcmp = dateRecepNonObjectOcmp;
        return this;
    }

    public void setDateRecepNonObjectOcmp(LocalDate dateRecepNonObjectOcmp) {
        this.dateRecepNonObjectOcmp = dateRecepNonObjectOcmp;
    }

    public LocalDate getDateRecepRapportEva() {
        return dateRecepRapportEva;
    }

    public Realisation dateRecepRapportEva(LocalDate dateRecepRapportEva) {
        this.dateRecepRapportEva = dateRecepRapportEva;
        return this;
    }

    public void setDateRecepRapportEva(LocalDate dateRecepRapportEva) {
        this.dateRecepRapportEva = dateRecepRapportEva;
    }

    public LocalDate getDateRecepNonObjectPtf() {
        return dateRecepNonObjectPtf;
    }

    public Realisation dateRecepNonObjectPtf(LocalDate dateRecepNonObjectPtf) {
        this.dateRecepNonObjectPtf = dateRecepNonObjectPtf;
        return this;
    }

    public void setDateRecepNonObjectPtf(LocalDate dateRecepNonObjectPtf) {
        this.dateRecepNonObjectPtf = dateRecepNonObjectPtf;
    }

    public LocalDate getDateExamenJuridique() {
        return dateExamenJuridique;
    }

    public Realisation dateExamenJuridique(LocalDate dateExamenJuridique) {
        this.dateExamenJuridique = dateExamenJuridique;
        return this;
    }

    public void setDateExamenJuridique(LocalDate dateExamenJuridique) {
        this.dateExamenJuridique = dateExamenJuridique;
    }

    public LocalDate getDateNotifContrat() {
        return dateNotifContrat;
    }

    public Realisation dateNotifContrat(LocalDate dateNotifContrat) {
        this.dateNotifContrat = dateNotifContrat;
        return this;
    }

    public void setDateNotifContrat(LocalDate dateNotifContrat) {
        this.dateNotifContrat = dateNotifContrat;
    }

    public LocalDate getDateApprobationContrat() {
        return dateApprobationContrat;
    }

    public Realisation dateApprobationContrat(LocalDate dateApprobationContrat) {
        this.dateApprobationContrat = dateApprobationContrat;
        return this;
    }

    public void setDateApprobationContrat(LocalDate dateApprobationContrat) {
        this.dateApprobationContrat = dateApprobationContrat;
    }

    public PlanPassation getPlanPassation() {
        return planPassation;
    }

    public Realisation planPassation(PlanPassation planPassation) {
        this.planPassation = planPassation;
        return this;
    }

    public void setPlanPassation(PlanPassation planPassation) {
        this.planPassation = planPassation;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Realisation)) {
            return false;
        }
        return id != null && id.equals(((Realisation) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Realisation{" +
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
