package com.mvc2.member.vo;

public class MemberVO {

	private String knum;
	private String kname;
	private String kid;
	private String kpw;
	private String kbirth;
	private String kgender;
	private String kemail;
	private String kmobile;
	private String kpostnum;
	private String kaddr;
	private String kaddr1;
	private	String kimg;
	private String kdeleteyn;
	private String kinsertdate;
	private String kupdatedate;
	
	@Override
	public String toString() {
		return "MemberVO [knum=" + knum + ", kname=" + kname + ", kid=" + kid + ", kpw=" + kpw + ", kbirth=" + kbirth
				+ ", kgender=" + kgender + ", kemail=" + kemail + ", kmobile=" + kmobile + ", kpostnum=" + kpostnum
				+ ", kaddr=" + kaddr + ", kaddr1=" + kaddr1 + ", kimg=" + kimg + ", kdeleteyn=" + kdeleteyn
				+ ", kinsertdate=" + kinsertdate + ", kupdatedate=" + kupdatedate + "]";
	}
	
	public MemberVO() {}
	public MemberVO(String knum, String kname, String kid, String kpw, String kbirth, String kgender, String kemail,
			String kmobile, String kpostnum, String kaddr, String kaddr1, String kimg, String kdeleteyn,
			String kinsertdate, String kupdatedate) {
		super();
		this.knum = knum;
		this.kname = kname;
		this.kid = kid;
		this.kpw = kpw;
		this.kbirth = kbirth;
		this.kgender = kgender;
		this.kemail = kemail;
		this.kmobile = kmobile;
		this.kpostnum = kpostnum;
		this.kaddr = kaddr;
		this.kaddr1 = kaddr1;
		this.kimg = kimg;
		this.kdeleteyn = kdeleteyn;
		this.kinsertdate = kinsertdate;
		this.kupdatedate = kupdatedate;
	}
	public String getKnum() {
		return knum;
	}
	public void setKnum(String knum) {
		this.knum = knum;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
	public String getKid() {
		return kid;
	}
	public void setKid(String kid) {
		this.kid = kid;
	}
	public String getKpw() {
		return kpw;
	}
	public void setKpw(String kpw) {
		this.kpw = kpw;
	}
	public String getKbirth() {
		return kbirth;
	}
	public void setKbirth(String kbirth) {
		this.kbirth = kbirth;
	}
	public String getKgender() {
		return kgender;
	}
	public void setKgender(String kgender) {
		this.kgender = kgender;
	}
	public String getKemail() {
		return kemail;
	}
	public void setKemail(String kemail) {
		this.kemail = kemail;
	}
	public String getKmobile() {
		return kmobile;
	}
	public void setKmobile(String kmobile) {
		this.kmobile = kmobile;
	}
	public String getKpostnum() {
		return kpostnum;
	}
	public void setKpostnum(String kpostnum) {
		this.kpostnum = kpostnum;
	}
	public String getKaddr() {
		return kaddr;
	}
	public void setKaddr(String kaddr) {
		this.kaddr = kaddr;
	}
	public String getKaddr1() {
		return kaddr1;
	}
	public void setKaddr1(String kaddr1) {
		this.kaddr1 = kaddr1;
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
	
	
	
	
	
}
