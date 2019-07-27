/*
 * This file is generated by jOOQ.
 */
package com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.information_schema.tables.records;


import com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.information_schema.tables.Constraints;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ConstraintsRecord extends TableRecordImpl<ConstraintsRecord> implements Record13<String, String, String, String, String, String, String, String, String, String, String, String, Integer> {

    private static final long serialVersionUID = 1316455915;

    /**
     * Setter for <code>INFORMATION_SCHEMA.CONSTRAINTS.CONSTRAINT_CATALOG</code>.
     */
    public void setConstraintCatalog(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.CONSTRAINTS.CONSTRAINT_CATALOG</code>.
     */
    public String getConstraintCatalog() {
        return (String) get(0);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.CONSTRAINTS.CONSTRAINT_SCHEMA</code>.
     */
    public void setConstraintSchema(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.CONSTRAINTS.CONSTRAINT_SCHEMA</code>.
     */
    public String getConstraintSchema() {
        return (String) get(1);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.CONSTRAINTS.CONSTRAINT_NAME</code>.
     */
    public void setConstraintName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.CONSTRAINTS.CONSTRAINT_NAME</code>.
     */
    public String getConstraintName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.CONSTRAINTS.CONSTRAINT_TYPE</code>.
     */
    public void setConstraintType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.CONSTRAINTS.CONSTRAINT_TYPE</code>.
     */
    public String getConstraintType() {
        return (String) get(3);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.CONSTRAINTS.TABLE_CATALOG</code>.
     */
    public void setTableCatalog(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.CONSTRAINTS.TABLE_CATALOG</code>.
     */
    public String getTableCatalog() {
        return (String) get(4);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.CONSTRAINTS.TABLE_SCHEMA</code>.
     */
    public void setTableSchema(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.CONSTRAINTS.TABLE_SCHEMA</code>.
     */
    public String getTableSchema() {
        return (String) get(5);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.CONSTRAINTS.TABLE_NAME</code>.
     */
    public void setTableName(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.CONSTRAINTS.TABLE_NAME</code>.
     */
    public String getTableName() {
        return (String) get(6);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.CONSTRAINTS.UNIQUE_INDEX_NAME</code>.
     */
    public void setUniqueIndexName(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.CONSTRAINTS.UNIQUE_INDEX_NAME</code>.
     */
    public String getUniqueIndexName() {
        return (String) get(7);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.CONSTRAINTS.CHECK_EXPRESSION</code>.
     */
    public void setCheckExpression(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.CONSTRAINTS.CHECK_EXPRESSION</code>.
     */
    public String getCheckExpression() {
        return (String) get(8);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.CONSTRAINTS.COLUMN_LIST</code>.
     */
    public void setColumnList(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.CONSTRAINTS.COLUMN_LIST</code>.
     */
    public String getColumnList() {
        return (String) get(9);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.CONSTRAINTS.REMARKS</code>.
     */
    public void setRemarks(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.CONSTRAINTS.REMARKS</code>.
     */
    public String getRemarks() {
        return (String) get(10);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.CONSTRAINTS.SQL</code>.
     */
    public void setSql(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.CONSTRAINTS.SQL</code>.
     */
    public String getSql() {
        return (String) get(11);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.CONSTRAINTS.ID</code>.
     */
    public void setId(Integer value) {
        set(12, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.CONSTRAINTS.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(12);
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row13<String, String, String, String, String, String, String, String, String, String, String, String, Integer> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row13<String, String, String, String, String, String, String, String, String, String, String, String, Integer> valuesRow() {
        return (Row13) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Constraints.CONSTRAINTS.CONSTRAINT_CATALOG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Constraints.CONSTRAINTS.CONSTRAINT_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Constraints.CONSTRAINTS.CONSTRAINT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Constraints.CONSTRAINTS.CONSTRAINT_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Constraints.CONSTRAINTS.TABLE_CATALOG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Constraints.CONSTRAINTS.TABLE_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Constraints.CONSTRAINTS.TABLE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Constraints.CONSTRAINTS.UNIQUE_INDEX_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Constraints.CONSTRAINTS.CHECK_EXPRESSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return Constraints.CONSTRAINTS.COLUMN_LIST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return Constraints.CONSTRAINTS.REMARKS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return Constraints.CONSTRAINTS.SQL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field13() {
        return Constraints.CONSTRAINTS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getConstraintCatalog();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getConstraintSchema();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getConstraintName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getConstraintType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getTableCatalog();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getTableSchema();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getTableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getUniqueIndexName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getCheckExpression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getColumnList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getRemarks();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return getSql();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component13() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getConstraintCatalog();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getConstraintSchema();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getConstraintName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getConstraintType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getTableCatalog();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getTableSchema();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getTableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getUniqueIndexName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getCheckExpression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getColumnList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getRemarks();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getSql();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value13() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConstraintsRecord value1(String value) {
        setConstraintCatalog(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConstraintsRecord value2(String value) {
        setConstraintSchema(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConstraintsRecord value3(String value) {
        setConstraintName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConstraintsRecord value4(String value) {
        setConstraintType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConstraintsRecord value5(String value) {
        setTableCatalog(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConstraintsRecord value6(String value) {
        setTableSchema(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConstraintsRecord value7(String value) {
        setTableName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConstraintsRecord value8(String value) {
        setUniqueIndexName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConstraintsRecord value9(String value) {
        setCheckExpression(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConstraintsRecord value10(String value) {
        setColumnList(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConstraintsRecord value11(String value) {
        setRemarks(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConstraintsRecord value12(String value) {
        setSql(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConstraintsRecord value13(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConstraintsRecord values(String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, String value11, String value12, Integer value13) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ConstraintsRecord
     */
    public ConstraintsRecord() {
        super(Constraints.CONSTRAINTS);
    }

    /**
     * Create a detached, initialised ConstraintsRecord
     */
    public ConstraintsRecord(String constraintCatalog, String constraintSchema, String constraintName, String constraintType, String tableCatalog, String tableSchema, String tableName, String uniqueIndexName, String checkExpression, String columnList, String remarks, String sql, Integer id) {
        super(Constraints.CONSTRAINTS);

        set(0, constraintCatalog);
        set(1, constraintSchema);
        set(2, constraintName);
        set(3, constraintType);
        set(4, tableCatalog);
        set(5, tableSchema);
        set(6, tableName);
        set(7, uniqueIndexName);
        set(8, checkExpression);
        set(9, columnList);
        set(10, remarks);
        set(11, sql);
        set(12, id);
    }
}
