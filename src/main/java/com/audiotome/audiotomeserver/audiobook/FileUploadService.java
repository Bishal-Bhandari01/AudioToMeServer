package com.audiotome.audiotomeserver.audiobook;

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
<<<<<<< HEAD
    public String uploadFile(MultipartFile multipartFile) throws IOException{
        return cloudi.uploader()
                .upload(multipartFile.getBytes(), Map.of("public_id",UUID.randomUUID().toString()))
                        .get("url")
                        .toString();
=======

    public String uploadFile(MultipartFile multipartFile) throws IOException {
        return cloudi.uploader()
                .upload(multipartFile.getBytes(), Map.of("public_id", UUID.randomUUID().toString()))
                .get("url")
                .toString();
>>>>>>> 17faaac ( new server hosting)
    }
}
