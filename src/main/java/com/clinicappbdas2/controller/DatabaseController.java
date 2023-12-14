package com.clinicappbdas2.controller;

import com.clinicappbdas2.model.TableColumn;
import com.clinicappbdas2.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/database")
public class DatabaseController {

    private final DatabaseService databaseService;

    @Autowired
    public DatabaseController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @GetMapping("/tables/columns")
    public List<TableColumn> getTableColumns() {
        return databaseService.getTableColumns();
    }
}
