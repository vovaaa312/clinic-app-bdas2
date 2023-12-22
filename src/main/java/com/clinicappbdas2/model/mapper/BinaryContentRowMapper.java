package com.clinicappbdas2.model.mapper;

import com.clinicappbdas2.model.BinaryContent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BinaryContentRowMapper implements RowMapper<BinaryContent> {

    @Override
    public BinaryContent mapRow(ResultSet rs, int rowNum) throws SQLException {
        BinaryContent binaryContent = new BinaryContent();
        binaryContent.setId(rs.getLong("ID"));
        binaryContent.setFileName(rs.getString("NAZEV_SOUBORU"));
        binaryContent.setFileType(rs.getString("TYP_SOUBORU"));
        binaryContent.setFileExtension(rs.getString("PRIPONA_SOUBORU"));
        binaryContent.setContent(rs.getBytes("CONTENT"));
        binaryContent.setUploadDate(rs.getDate("NAHRAT_DATUM"));
        binaryContent.setModificationDate(rs.getDate("UPRAVA_DATUM"));
        binaryContent.setOperationPerformed(rs.getString("PROVEDENA_OPERACE"));
        binaryContent.setPerformedBy(rs.getLong("PERFORMED_BY"));
        return binaryContent;
    }
}