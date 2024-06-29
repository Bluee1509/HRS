package hrs.entities;

public class QuaTrinhLamViec {
	private int id_qtlv;
    private int id_nv;
    private String ngayvaolam;
    private String bophan;
    private String chucvu;
    private String trinhdohocvan;
	public QuaTrinhLamViec(int id_qtlv, int id_nv, String ngayvaolam, String bophan, String chucvu,
			String trinhdohocvan) {
		this.id_qtlv = id_qtlv;
		this.id_nv = id_nv;
		this.ngayvaolam = ngayvaolam;
		this.bophan = bophan;
		this.chucvu = chucvu;
		this.trinhdohocvan = trinhdohocvan;
	}
	public QuaTrinhLamViec() {
	}
	@Override
	public String toString() {
		return "QuaTrinhLamViec [id_qtlv=" + id_qtlv + ", id_nv=" + id_nv + ", ngayvaolam=" + ngayvaolam + ", bophan="
				+ bophan + ", chucvu=" + chucvu + ", trinhdohocvan=" + trinhdohocvan + "]";
	}
    
    
}
