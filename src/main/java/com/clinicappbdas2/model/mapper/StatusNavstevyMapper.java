package com.clinicappbdas2.model.mapper;

import com.clinicappbdas2.model.StatusNavstevy;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusNavstevyMapper implements RowMapper<StatusNavstevy> {
    @Override
    public StatusNavstevy mapRow(ResultSet rs, int rowNum) throws SQLException {
        StatusNavstevy statusNavstevy = new StatusNavstevy();
        statusNavstevy.setIdStatus(rs.getLong("ID_STATUS"));
        statusNavstevy.setStatus(rs.getString("STATUS"));

        return statusNavstevy;
    }
}
