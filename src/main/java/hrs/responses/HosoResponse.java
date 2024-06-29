package hrs.responses;

public class HosoResponse {

	private int id;
	private int idNhanVien;
	private String hopdonglaodongPath;
	private String bangluongPath;
	private String baohiemxahoiPath;
	private String baohiemytePath;
	private String hoten;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public String getHopdonglaodongPath() {
		return hopdonglaodongPath;
	}

	public void setHopdonglaodongPath(String hopdonglaodongPath) {
		this.hopdonglaodongPath = hopdonglaodongPath;
	}

	public String getBangluongPath() {
		return bangluongPath;
	}

	public void setBangluongPath(String bangluongPath) {
		this.bangluongPath = bangluongPath;
	}

	public String getBaohiemxahoiPath() {
		return baohiemxahoiPath;
	}

	public void setBaohiemxahoiPath(String baohiemxahoiPath) {
		this.baohiemxahoiPath = baohiemxahoiPath;
	}

	public String getBaohiemytePath() {
		return baohiemytePath;
	}

	public void setBaohiemytePath(String baohiemytePath) {
		this.baohiemytePath = baohiemytePath;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	@Override
	public String toString() {
		return "HosoResponse [id=" + id + ", idNhanVien=" + idNhanVien + ", hopdonglaodongPath=" + hopdonglaodongPath
				+ ", bangluongPath=" + bangluongPath + ", baohiemxahoiPath=" + baohiemxahoiPath + ", baohiemytePath="
				+ baohiemytePath + ", hoten=" + hoten + "]";
	}

}
