package com.clinicappbdas2.model;

import lombok.Data;

@Data
public class TableColumn {

    private String tableName;
    private String columnName;
    private String dataType;
    private Integer dataLength;

    public TableColumn(){

    }


    public TableColumn(String tableName, String columnName, String dataType, Integer dataLength) {
        this.tableName = tableName;
        this.columnName = columnName;
        this.dataType = dataType;
        this.dataLength = dataLength;
    }
}
