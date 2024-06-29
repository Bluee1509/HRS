package hrs.dtos;

import org.springframework.web.multipart.MultipartFile;

public class HoSoDTO {
	private Integer id_nv;
	private MultipartFile hopdonglaodong;
	private MultipartFile bangluong;
	private MultipartFile baohiem_xh;
	private MultipartFile baohiem_yte;

	// Getters và Setters
	public Integer getId_nv() {
		return id_nv;
	}

	public void setId_nv(Integer id_nv) {
		this.id_nv = id_nv;
	}

	public MultipartFile getHopdonglaodong() {
		return hopdonglaodong;
	}

	public void setHopdonglaodong(MultipartFile hopdonglaodong) {
		this.hopdonglaodong = hopdonglaodong;
	}

	public MultipartFile getBangluong() {
		return bangluong;
	}

	public void setBangluong(MultipartFile bangluong) {
		this.bangluong = bangluong;
	}

	public MultipartFile getBaohiem_xh() {
		return baohiem_xh;
	}

	public void setBaohiem_xh(MultipartFile baohiem_xh) {
		this.baohiem_xh = baohiem_xh;
	}

	public MultipartFile getBaohiem_yte() {
		return baohiem_yte;
	}

	public void setBaohiem_yte(MultipartFile baohiem_yte) {
		this.baohiem_yte = baohiem_yte;
	}

	public HoSoDTO() {
	}

	public HoSoDTO(Integer id_nv, MultipartFile hopdonglaodong, MultipartFile bangluong, MultipartFile baohiem_xh,
			MultipartFile baohiem_yte) {
		this.id_nv = id_nv;
		this.hopdonglaodong = hopdonglaodong;
		this.bangluong = bangluong;
		this.baohiem_xh = baohiem_xh;
		this.baohiem_yte = baohiem_yte;
	}

	@Override
	public String toString() {
		return "HoSoDTO [id_nv=" + id_nv + ", hopdonglaodong=" + hopdonglaodong + ", bangluong=" + bangluong
				+ ", baohiem_xh=" + baohiem_xh + ", baohiem_yte=" + baohiem_yte + "]";
	}

}
