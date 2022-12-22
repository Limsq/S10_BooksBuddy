package member.model.vo;
import java.sql.Date;

public class Members implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	//컬럼명과 동일한 멤버변수
	private String uid;
	private String email;
	private String upw;
	private Date joindate;
	
	//기본 생성자
	public Members(){
		
	}
	
	//파라미터를 받아서 멤버변수에 저장하는 생성자
	public Members(String uid, String email, String upw, Date joindate) {
		this.uid=uid;
		this.email=email;
		this.upw=upw;
		this.joindate=joindate;
	}
	// getter * setter //
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	
}
