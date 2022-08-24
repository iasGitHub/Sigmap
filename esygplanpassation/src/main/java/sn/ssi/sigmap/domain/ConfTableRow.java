package sn.ssi.sigmap.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

import sn.ssi.sigmap.domain.enumeration.DataType;

/**
 * A ConfTableRow.
 */
@Entity
@Table(name = "conf_table_row")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ConfTableRow implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 64)
    @Column(name = "table_name", length = 64)
    private String tableName;

    @Size(max = 100)
    @Column(name = "label_name", length = 100)
    private String labelName;

    @Size(max = 50)
    @Column(name = "column_name", length = 50)
    private String columnName;

    @Enumerated(EnumType.STRING)
    @Column(name = "data_type")
    private DataType dataType;

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

    public ConfTableRow tableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getLabelName() {
        return labelName;
    }

    public ConfTableRow labelName(String labelName) {
        this.labelName = labelName;
        return this;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getColumnName() {
        return columnName;
    }

    public ConfTableRow columnName(String columnName) {
        this.columnName = columnName;
        return this;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public DataType getDataType() {
        return dataType;
    }

    public ConfTableRow dataType(DataType dataType) {
        this.dataType = dataType;
        return this;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConfTableRow)) {
            return false;
        }
        return id != null && id.equals(((ConfTableRow) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ConfTableRow{" +
            "id=" + getId() +
            ", tableName='" + getTableName() + "'" +
            ", labelName='" + getLabelName() + "'" +
            ", columnName='" + getColumnName() + "'" +
            ", dataType='" + getDataType() + "'" +
            "}";
    }
}
