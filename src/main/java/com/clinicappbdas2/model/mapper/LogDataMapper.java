package com.clinicappbdas2.model.mapper;

import com.clinicappbdas2.model.LogData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogDataMapper implements RowMapper<LogData> {
    @Override
    public LogData mapRow(ResultSet rs, int rowNum) throws SQLException {
        LogData log = new LogData();
        log.setIdLog(rs.getLong("ID_LOG"));
        log.setTime(rs.getTimestamp("TIME"));
        log.setEditedTable(rs.getString("EDITED_TABLE"));
        log.setEditedData(rs.getString("EDITED_DATA"));
        log.setLogin(rs.getString("LOGIN"));
        return log;
    }
}
