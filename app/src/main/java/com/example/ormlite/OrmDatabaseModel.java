package com.example.ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "MAST_CUST")
public class OrmDatabaseModel implements Serializable {


    @DatabaseField(columnName = "id",generatedId = true)

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @DatabaseField(columnName = "READDATE")
    private String READDATE;


    @DatabaseField(columnName = "RRNO")
    private String RRNO;

    @DatabaseField(columnName = "NAME")
    private String NAME;

    @DatabaseField(columnName = "ADD1")
    private String ADD1;

    public String getREADDATE() {
        return READDATE;
    }

    public void setREADDATE(String READDATE) {
        this.READDATE = READDATE;
    }

    public String getRRNO() {
        return RRNO;
    }

    public void setRRNO(String RRNO) {
        this.RRNO = RRNO;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getADD1() {
        return ADD1;
    }

    public void setADD1(String ADD1) {
        this.ADD1 = ADD1;
    }


}
