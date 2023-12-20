package com.clinicappbdas2.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class LogData {
    private Long idLog;
    private Timestamp time;
    private String editedTable;
    private String editedData;
    private String login;

//    public static LogData mapRow(ResultSet rs, int rowNum) throws SQLException {
//        LogData log = new LogData();
//        log.setIdLog(rs.getLong("ID_LOG"));
//        log.setTime(rs.getTimestamp("TIME"));
//        log.setEditedTable(rs.getString("EDITED_TABLE"));
//        log.setEditedData(rs.getString("EDITED_DATA"));
//        log.setLogin(rs.getString("LOGIN"));
//        return log;
//    }

}
