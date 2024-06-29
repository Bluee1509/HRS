package hrs.entities;

public class Nhanvien {
	private Long id_nv;
	private String hoten;
	private String ngaysinh;
	private String diachi;
	private Integer sdt;
	private String email;
	
	
	public Nhanvien() {
		super();
	}
	public Nhanvien(Long id_nv, String hoten, String ngaysinh, String diachi, Integer sdt, String email) {
		super();
		this.id_nv = id_nv;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
	}
	
	public Long getId_nv() {
		return id_nv;
	}
	public void setId_nv(Long id_nv) {
		this.id_nv = id_nv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public Integer getSdt() {
		return sdt;
	}
	public void setSdt(Integer sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Nhanvien [id_nv=" + id_nv + ", hoten=" + hoten + ", ngaysinh=" + ngaysinh + ", diachi=" + diachi
				+ ", sdt=" + sdt + ", email=" + email + "]";
	}
	
	
}
