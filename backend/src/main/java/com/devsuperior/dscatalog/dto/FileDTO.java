package com.devsuperior.dscatalog.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class FileDTO implements Serializable {

    private static final long serialVersionUID = 6722971595270188029L;
    private MultipartFile file;

    public FileDTO() {
    }

    public FileDTO(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
