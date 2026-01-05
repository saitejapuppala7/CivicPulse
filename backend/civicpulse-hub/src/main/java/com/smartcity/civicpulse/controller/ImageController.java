package com.smartcity.civicpulse.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class ImageController {

    @GetMapping("/complaint-image/{imageName}")
    public ResponseEntity<Resource> getComplaintImage(
            @PathVariable String imageName) throws Exception {

        Path imagePath = Paths.get(
                System.getProperty("user.dir") + "/uploads/complaints/" + imageName
        );
        System.out.println("IMAGE PATH LOOKING FOR: " +imagePath);

        Resource resource = new UrlResource(imagePath.toUri());

        if (!resource.exists()) {
            System.out.println("IMAGE NOT FOUND");
            return ResponseEntity.notFound().build();
        }

        String contentType = Files.probeContentType(imagePath);
        System.out.println("hello this image controller");

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }
}

