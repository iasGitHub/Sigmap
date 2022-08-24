package sn.ssi.sigmap.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.Duration;
import java.util.UUID;

import sn.ssi.sigmap.domain.enumeration.DataType;

/**
 * A ConfTableDeTransaction.
 */
@Entity
@Table(name = "conf_table_de_transaction")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ConfTableDeTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 100)
    @Column(name = "table_name", length = 100)
    private String tableName;

    @Column(name = "column_name")
    private String columnName;

    @Column(name = "numero_ligne")
    private Long numeroLigne;

    @Enumerated(EnumType.STRING)
    @Column(name = "data_type")
    private DataType dataType;

    @Column(name = "master_id")
    private Long masterId;

    @Column(name = "int_value")
    private Integer intValue;

    @Column(name = "boolean_value")
    private Boolean booleanValue;

    @Column(name = "money_value", precision = 21, scale = 2)
    private BigDecimal moneyValue;

    @Column(name = "string_value")
    private String stringValue;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "text_value")
    private String textValue;

    @Column(name = "date_value")
    private LocalDate dateValue;

    @Column(name = "instant_value")
    private Instant instantValue;

    @Column(name = "zoned_date_time_value")
    private ZonedDateTime zonedDateTimeValue;

    @Column(name = "long_value")
    private Long longValue;

    @Column(name = "float_value")
    private Float floatValue;

    @Column(name = "double_value")
    private Double doubleValue;

    @Column(name = "duration_value")
    private Duration durationValue;

    @Column(name = "uuid_value")
    private UUID uuidValue;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public ConfTableDeTransaction tableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public ConfTableDeTransaction columnName(String columnName) {
        this.columnName = columnName;
        return this;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Long getNumeroLigne() {
        return numeroLigne;
    }

    public ConfTableDeTransaction numeroLigne(Long numeroLigne) {
        this.numeroLigne = numeroLigne;
        return this;
    }

    public void setNumeroLigne(Long numeroLigne) {
        this.numeroLigne = numeroLigne;
    }

    public DataType getDataType() {
        return dataType;
    }

    public ConfTableDeTransaction dataType(DataType dataType) {
        this.dataType = dataType;
        return this;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public Long getMasterId() {
        return masterId;
    }

    public ConfTableDeTransaction masterId(Long masterId) {
        this.masterId = masterId;
        return this;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public ConfTableDeTransaction intValue(Integer intValue) {
        this.intValue = intValue;
        return this;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public Boolean isBooleanValue() {
        return booleanValue;
    }

    public ConfTableDeTransaction booleanValue(Boolean booleanValue) {
        this.booleanValue = booleanValue;
        return this;
    }

    public void setBooleanValue(Boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public BigDecimal getMoneyValue() {
        return moneyValue;
    }

    public ConfTableDeTransaction moneyValue(BigDecimal moneyValue) {
        this.moneyValue = moneyValue;
        return this;
    }

    public void setMoneyValue(BigDecimal moneyValue) {
        this.moneyValue = moneyValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public ConfTableDeTransaction stringValue(String stringValue) {
        this.stringValue = stringValue;
        return this;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getTextValue() {
        return textValue;
    }

    public ConfTableDeTransaction textValue(String textValue) {
        this.textValue = textValue;
        return this;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public LocalDate getDateValue() {
        return dateValue;
    }

    public ConfTableDeTransaction dateValue(LocalDate dateValue) {
        this.dateValue = dateValue;
        return this;
    }

    public void setDateValue(LocalDate dateValue) {
        this.dateValue = dateValue;
    }

    public Instant getInstantValue() {
        return instantValue;
    }

    public ConfTableDeTransaction instantValue(Instant instantValue) {
        this.instantValue = instantValue;
        return this;
    }

    public void setInstantValue(Instant instantValue) {
        this.instantValue = instantValue;
    }

    public ZonedDateTime getZonedDateTimeValue() {
        return zonedDateTimeValue;
    }

    public ConfTableDeTransaction zonedDateTimeValue(ZonedDateTime zonedDateTimeValue) {
        this.zonedDateTimeValue = zonedDateTimeValue;
        return this;
    }

    public void setZonedDateTimeValue(ZonedDateTime zonedDateTimeValue) {
        this.zonedDateTimeValue = zonedDateTimeValue;
    }

    public Long getLongValue() {
        return longValue;
    }

    public ConfTableDeTransaction longValue(Long longValue) {
        this.longValue = longValue;
        return this;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }

    public Float getFloatValue() {
        return floatValue;
    }

    public ConfTableDeTransaction floatValue(Float floatValue) {
        this.floatValue = floatValue;
        return this;
    }

    public void setFloatValue(Float floatValue) {
        this.floatValue = floatValue;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public ConfTableDeTransaction doubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
        return this;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public Duration getDurationValue() {
        return durationValue;
    }

    public ConfTableDeTransaction durationValue(Duration durationValue) {
        this.durationValue = durationValue;
        return this;
    }

    public void setDurationValue(Duration durationValue) {
        this.durationValue = durationValue;
    }

    public UUID getUuidValue() {
        return uuidValue;
    }

    public ConfTableDeTransaction uuidValue(UUID uuidValue) {
        this.uuidValue = uuidValue;
        return this;
    }

    public void setUuidValue(UUID uuidValue) {
        this.uuidValue = uuidValue;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConfTableDeTransaction)) {
            return false;
        }
        return id != null && id.equals(((ConfTableDeTransaction) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ConfTableDeTransaction{" +
            "id=" + getId() +
            ", tableName='" + getTableName() + "'" +
            ", columnName='" + getColumnName() + "'" +
            ", numeroLigne=" + getNumeroLigne() +
            ", dataType='" + getDataType() + "'" +
            ", masterId=" + getMasterId() +
            ", intValue=" + getIntValue() +
            ", booleanValue='" + isBooleanValue() + "'" +
            ", moneyValue=" + getMoneyValue() +
            ", stringValue='" + getStringValue() + "'" +
            ", textValue='" + getTextValue() + "'" +
            ", dateValue='" + getDateValue() + "'" +
            ", instantValue='" + getInstantValue() + "'" +
            ", zonedDateTimeValue='" + getZonedDateTimeValue() + "'" +
            ", longValue=" + getLongValue() +
            ", floatValue=" + getFloatValue() +
            ", doubleValue=" + getDoubleValue() +
            ", durationValue='" + getDurationValue() + "'" +
            ", uuidValue='" + getUuidValue() + "'" +
            "}";
    }
}
