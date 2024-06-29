package hrs.dtos;

public class QuaTrinhLamViecDTO {
	private int id_qtlv;
    private int id_nv;
    private String ngayvaolam;
    private String bophan;
    private String chucvu;
    private String trinhdohocvan;
	public int getId_qtlv() {
		return id_qtlv;
	}
	public void setId_qtlv(int id_qtlv) {
		this.id_qtlv = id_qtlv;
	}
	public int getId_nv() {
		return id_nv;
	}
	public void setId_nv(int id_nv) {
		this.id_nv = id_nv;
	}
	public String getNgayvaolam() {
		return ngayvaolam;
	}
	public void setNgayvaolam(String ngayvaolam) {
		this.ngayvaolam = ngayvaolam;
	}
	public String getBophan() {
		return bophan;
	}
	public void setBophan(String bophan) {
		this.bophan = bophan;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	public String getTrinhdohocvan() {
		return trinhdohocvan;
	}
	public void setTrinhdohocvan(String trinhdohocvan) {
		this.trinhdohocvan = trinhdohocvan;
	}
	@Override
	public String toString() {
		return "QuaTrinhLamViecDTO [id_qtlv=" + id_qtlv + ", id_nv=" + id_nv + ", ngayvaolam=" + ngayvaolam
				+ ", bophan=" + bophan + ", chucvu=" + chucvu + ", trinhdohocvan=" + trinhdohocvan + "]";
	}
    
    
}
