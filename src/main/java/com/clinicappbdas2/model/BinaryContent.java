package com.clinicappbdas2.model;

import lombok.Data;

import java.util.Date;

@Data
public class BinaryContent {

    private Long id;
    private String fileName;
    private String fileType;
    private String fileExtension;

    private byte[] content;
    private Date uploadDate;
    private Date modificationDate;
    private String operationPerformed;
    private Long performedBy;
}
