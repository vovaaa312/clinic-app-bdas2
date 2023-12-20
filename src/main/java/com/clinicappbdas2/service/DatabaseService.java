package com.clinicappbdas2.service;

import com.clinicappbdas2.model.LogData;
import com.clinicappbdas2.model.TableColumn;
import com.clinicappbdas2.model.mapper.LogDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class DatabaseService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TableColumn> getTableColumns() {
        String sql = "SELECT table_name, column_name, data_type, data_length FROM user_tab_columns ORDER BY table_name, column_id";
        return jdbcTemplate.query(sql, new RowMapper<TableColumn>() {
            @Override
            public TableColumn mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new TableColumn(
                        rs.getString("table_name"),
                        rs.getString("column_name"),
                        rs.getString("data_type"),
                        rs.getInt("data_length")
                );
            }
        });
    }

    public List<LogData>getLogs(){
        String sql = "SELECT * FROM LOG_TABLE";
        return jdbcTemplate.query(sql, new LogDataMapper());
    }
}

