package hrs.entities;

public class HoSo {
	private  Long id_hoso;
	private Long id_nv;
	private String hopdonglaodong;
	private String bangluong;
	private String baohiem_xh;
	private String baohiem_yte;
	public HoSo(Long id_hoso, Long id_nv, String hopdonglaodong, String bangluong, String baohiem_xh,
			String baohiem_yte) {
		this.id_hoso = id_hoso;
		this.id_nv = id_nv;
		this.hopdonglaodong = hopdonglaodong;
		this.bangluong = bangluong;
		this.baohiem_xh = baohiem_xh;
		this.baohiem_yte = baohiem_yte;
	}
	public HoSo() {

	}
	@Override
	public String toString() {
		return "HoSo [id_hoso=" + id_hoso + ", id_nv=" + id_nv + ", hopdonglaodong=" + hopdonglaodong + ", bangluong="
				+ bangluong + ", baohiem_xh=" + baohiem_xh + ", baohiem_yte=" + baohiem_yte + "]";
	}
	
	
	
}
