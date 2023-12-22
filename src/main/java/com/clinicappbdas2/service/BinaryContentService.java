package com.clinicappbdas2.service;

import com.clinicappbdas2.model.BinaryContent;
import com.clinicappbdas2.model.mapper.BinaryContentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Service
public class BinaryContentService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BinaryContentService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertBinaryContent(BinaryContent binaryContent) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("VlozBinaryContent");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("pNazevSouboru", binaryContent.getFileName())
                .addValue("pTypSouboru", binaryContent.getFileType())
                .addValue("pPriponaSouboru", binaryContent.getFileExtension())
                .addValue("pContent", new SqlLobValue(binaryContent.getContent()))
                .addValue("pNahrazeniDatum", new Timestamp(binaryContent.getUploadDate().getTime()))
                .addValue("pUpravaDatum", new Timestamp(binaryContent.getModificationDate().getTime()))
                .addValue("pProvedenaOperace", binaryContent.getOperationPerformed())
                .addValue("pPerformedBy", binaryContent.getPerformedBy());
        jdbcCall.execute(in);
    }


    public void updateBinaryContent(BinaryContent binaryContent) {
        // Установка даты модификации на текущее время
        binaryContent.setModificationDate(new Date());
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("UpdateBinaryContent");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("pId", binaryContent.getId())
                .addValue("pNazevSouboru", binaryContent.getFileName())
                .addValue("pTypSouboru", binaryContent.getFileType())
                .addValue("pPriponaSouboru", binaryContent.getFileExtension())
                .addValue("pContent", new SqlLobValue(binaryContent.getContent()))
                .addValue("pNahrazeniDatum", new Timestamp(binaryContent.getUploadDate().getTime()))
                .addValue("pUpravaDatum", new Timestamp(binaryContent.getModificationDate().getTime()))
                .addValue("pProvedenaOperace", binaryContent.getOperationPerformed())
                .addValue("pPerformedBy", binaryContent.getPerformedBy());

        jdbcCall.execute(in);
    }


    public BinaryContent getBinaryContent(Long id) {
        String sql = "SELECT * FROM BinaryContent WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},new BinaryContentRowMapper());
    }

    public List<BinaryContent> getAllBinaryContents() {
        String sql = "SELECT * FROM BinaryContent";
        return jdbcTemplate.query(sql, new BinaryContentRowMapper());
    }
}

