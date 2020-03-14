package com.mvc2.board.vo;

public class BoardVO {
	private String kno;
	private String ktitle;
	private String kname;
	private String kpw;
	private String kcontent;
	private String kimg;
	private String kdeleteyn;
	private String kinsertdate;
	private String kupdatedate;
	public String getKno() {
		return kno;
	}
	public void setKno(String kno) {
		this.kno = kno;
	}
	public String getKtitle() {
		return ktitle;
	}
	public void setKtitle(String ktitle) {
		this.ktitle = ktitle;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
	public String getKpw() {
		return kpw;
	}
	public void setKpw(String kpw) {
		this.kpw = kpw;
	}
	public String getKcontent() {
		return kcontent;
	}
	public void setKcontent(String kcontent) {
		this.kcontent = kcontent;
	}
	public String getKimg() {
		return kimg;
	}
	public void setKimg(String kimg) {
		this.kimg = kimg;
	}
	public String getKdeleteyn() {
		return kdeleteyn;
	}
	public void setKdeleteyn(String kdeleteyn) {
		this.kdeleteyn = kdeleteyn;
	}
	public String getKinsertdate() {
		return kinsertdate;
	}
	public void setKinsertdate(String kinsertdate) {
		this.kinsertdate = kinsertdate;
	}
	public String getKupdatedate() {
		return kupdatedate;
	}
	public void setKupdatedate(String kupdatedate) {
		this.kupdatedate = kupdatedate;
	}
	@Override
	public String toString() {
		return "BoardVO [kno=" + kno + ", ktitle=" + ktitle + ", kname=" + kname + ", kpw=" + kpw + ", kcontent="
				+ kcontent + ", kimg=" + kimg + ", kdeleteyn=" + kdeleteyn + ", kinsertdate=" + kinsertdate
				+ ", kupdatedate=" + kupdatedate + "]";
	}
	
}
