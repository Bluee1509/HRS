package hrs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import hrs.dtos.HoSoDTO;
import hrs.repositories.HosoRepository;
import hrs.responses.HosoResponse;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class HoSoService {

    @Autowired
    private HosoRepository hosoRepository;

    private final String UPLOAD_DIR = "src/main/resources/static/uploads/";

    public int addHoSo(HoSoDTO hoSoDTO) {
        String hopdonglaodongPath = saveFile(hoSoDTO.getHopdonglaodong());
		String bangluongPath = saveFile(hoSoDTO.getBangluong());
		String baohiemXhPath = saveFile(hoSoDTO.getBaohiem_xh());
		String baohiemYtePath = saveFile(hoSoDTO.getBaohiem_yte());
		return hosoRepository.addHoSo(hoSoDTO, hopdonglaodongPath, bangluongPath, baohiemXhPath, baohiemYtePath);
    }

    public int updateHoSo(int id_hoso, HoSoDTO hoSoDTO) {
    	String hopdonglaodongPath = null;
		String bangluongPath = null;
		String baohiemXhPath = null;
		String baohiemYtePath = null;
    	if (hoSoDTO.getHopdonglaodong() != null) {
    		hopdonglaodongPath = saveFile(hoSoDTO.getHopdonglaodong());
    	}
    	if (hoSoDTO.getBangluong() != null) {
    		bangluongPath = saveFile(hoSoDTO.getBangluong());
    	}
    	if (hoSoDTO.getBaohiem_xh() != null) {
    		baohiemXhPath = saveFile(hoSoDTO.getBaohiem_xh());
    	}
    	if (hoSoDTO.getBaohiem_yte() != null) {
    		baohiemYtePath = saveFile(hoSoDTO.getBaohiem_yte());
    	}
        
		return hosoRepository.updateHoSo(id_hoso, hoSoDTO, hopdonglaodongPath, bangluongPath, baohiemXhPath, baohiemYtePath);
    }

    public int deleteHoSo(int id_hoso) {
        return hosoRepository.deleteHoSo(id_hoso);
    }
    // Hàm lấy danh sách tất cả hồ sơ
    public List<HosoResponse> getAllHoSo() {
        return hosoRepository.getAllHoSo();
    }

    // Hàm tìm kiếm hồ sơ theo tên nhân viên
    public List<HosoResponse> searchHoSoByTenNhanVien(String tenNhanVien) {
        return hosoRepository.searchHoSoByTenNhanVien(tenNhanVien);
    }

    private String saveFile(MultipartFile file) {
    	 String imageUrl = null;
         try {
             String fileName = StringUtils.cleanPath(file.getOriginalFilename());
             String uploadDir = "src/main/resources/static/images/";
             Path uploadPath = Paths.get(uploadDir);
             if (!Files.exists(uploadPath)) {
                 Files.createDirectories(uploadPath);
             }
             try (InputStream inputStream = file.getInputStream()) {
                 Path filePath = uploadPath.resolve(fileName);
                 Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                 imageUrl = "/images/" + fileName; // URL để truy cập hình ảnh từ frontend
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
         return imageUrl;
    }

}
