package pl.oskarpolak.fdetector.models.services;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.plaf.multi.MultiInternalFrameUI;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

@Service
public class ImageService {

    public void moveImageToPhotoDir(MultipartFile image, int id) throws IOException {
        Files.write(Paths.get("photos/" + id), image.getBytes(), StandardOpenOption.CREATE_NEW);
    }

}
