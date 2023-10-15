package com.audiotome.audiotomeserver.cloudinary;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileUploadService {

    private final Cloudinary cloudi;

    public FileUploadResponse uploadFile(MultipartFile multipartFile) throws IOException {
        System.out.println("Ihave been called");
        var cloud = cloudi.uploader()
                .upload(multipartFile.getBytes(), Map.of("public_id", UUID.randomUUID().toString()))
                .get("url")
                .toString();
        FileUploadResponse neResponse = new FileUploadResponse();
        neResponse.setFileLink(cloud);
        return neResponse;
    }
}
