package Bean;

public class UserBean {
	//회원 idx
	private int u_idx;
	//회원 이미지
	private String u_img;
	//회원 이름
	private String u_nm;
	//회원 이메일
	private String u_email;
	//회원 패스워드
	private String u_pwd;
	//회원 활동지역
	private String u_loc;
	//회원 소개
	private String u_intro;
	//sns 연동 유무
	private int sns_con_tf;
	public int getU_idx() {
		return u_idx;
	}
	public void setU_idx(int u_idx) {
		this.u_idx = u_idx;
	}
	public String getU_img() {
		return u_img;
	}
	public void setU_img(String u_img) {
		this.u_img = u_img;
	}
	public String getU_nm() {
		return u_nm;
	}
	public void setU_nm(String u_nm) {
		this.u_nm = u_nm;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	public String getU_loc() {
		return u_loc;
	}
	public void setU_loc(String u_loc) {
		this.u_loc = u_loc;
	}
	public String getU_intro() {
		return u_intro;
	}
	public void setU_intro(String u_intro) {
		this.u_intro = u_intro;
	}
	public int getSns_con_tf() {
		return sns_con_tf;
	}
	public void setSns_con_tf(int sns_con_tf) {
		this.sns_con_tf = sns_con_tf;
	}
	public String getU_website() {
		return u_website;
	}
	public void setU_website(String u_website) {
		this.u_website = u_website;
	}
	public int getNews_sub_tf() {
		return news_sub_tf;
	}
	public void setNews_sub_tf(int news_sub_tf) {
		this.news_sub_tf = news_sub_tf;
	}
	public String getU_ph() {
		return u_ph;
	}
	public void setU_ph(String u_ph) {
		this.u_ph = u_ph;
	}
	//회원 웹사이트
	private String u_website;
	//뉴스레터 구독 유무
	private int news_sub_tf;
	//회원 핸드폰 번호
	private String u_ph;

}
