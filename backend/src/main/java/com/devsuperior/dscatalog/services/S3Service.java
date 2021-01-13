package com.devsuperior.dscatalog.services;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Instant;
import java.util.Date;

@Service
public class S3Service {

    private static Logger LOG = LoggerFactory.getLogger(S3Service.class);

    @Autowired
    private AmazonS3 s3client;

    @Value("${s3.bucket}")
    private String bucketName;

    public URL uploadFile(MultipartFile file) {
        try {
            String originalName = file.getOriginalFilename();
            String extension = FilenameUtils.getExtension(originalName);
            String fileName = Date.from(Instant.now()).getTime() + "." + extension;

            InputStream is = file.getInputStream();
            String contenType = file.getContentType();

            return uploadFile(is, fileName, contenType);
        }
        catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private URL uploadFile(InputStream is, String fileName, String contenType) {
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentType(contenType);
        LOG.info("Upload start end: [fileName: {}, contenType: {}]", fileName, contenType);
        s3client.putObject(bucketName, fileName, is, meta);
        LOG.info("Upload end");
        return s3client.getUrl(bucketName, fileName);
    }
}
