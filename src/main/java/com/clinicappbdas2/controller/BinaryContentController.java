package com.clinicappbdas2.controller;

import com.clinicappbdas2.model.BinaryContent;
import com.clinicappbdas2.service.BinaryContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.io.IOException;
import java.util.Date;


@RestController
@RequestMapping("/api/binarycontent")
public class BinaryContentController {

    private final BinaryContentService binaryContentService;

    @Autowired
    public BinaryContentController(BinaryContentService binaryContentService) {
        this.binaryContentService = binaryContentService;
    }

    @PostMapping
    public void insertBinaryContent(@RequestParam("file") MultipartFile file) throws IOException {
        BinaryContent binaryContent = new BinaryContent();
        binaryContent.setFileName(file.getOriginalFilename());
        binaryContent.setFileType(file.getContentType());

        String fileName = file.getOriginalFilename();
        String fileExtension = null;
        if (fileName != null) {
            int lastDotIndex = fileName.lastIndexOf(".");
            if (lastDotIndex != -1) {
                fileExtension = fileName.substring(lastDotIndex + 1);
            }
        }

        binaryContent.setFileExtension(fileExtension);
        binaryContent.setContent(file.getBytes());
        binaryContent.setUploadDate(new Date());
        binaryContent.setModificationDate(new Date());
        binaryContent.setOperationPerformed("upload");
        binaryContent.setPerformedBy(1);

        binaryContentService.insertBinaryContent(binaryContent);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBinaryContent(@PathVariable int id, @RequestBody BinaryContent updatedContent) {
        try {
            BinaryContent existingContent = binaryContentService.getBinaryContent(id);
            if (existingContent == null) {
                return new ResponseEntity<>("Binary content not found", HttpStatus.NOT_FOUND);
            }

            existingContent.setId(updatedContent.getId());
            existingContent.setFileName(updatedContent.getFileName());
            existingContent.setFileType(updatedContent.getFileType());
            existingContent.setFileExtension(updatedContent.getFileExtension());
            existingContent.setContent(updatedContent.getContent());
            existingContent.setOperationPerformed(updatedContent.getOperationPerformed());
            existingContent.setPerformedBy(updatedContent.getPerformedBy());

            // Обновление содержимого
            binaryContentService.updateBinaryContent(existingContent);
            return new ResponseEntity<>("Binary content updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            // Логирование ошибки
            return new ResponseEntity<>("Error updating binary content: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{id}")
    public BinaryContent getBinaryContent(@PathVariable int id) {
        return binaryContentService.getBinaryContent(id);
    }

    @GetMapping("/all")
    public List<BinaryContent> getAllBinaryContents() {
        return binaryContentService.getAllBinaryContents();
    }
}
