package mg.scuderia.car_show.file;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String saveFile(MultipartFile file);

    boolean deleteFile(String url);

}