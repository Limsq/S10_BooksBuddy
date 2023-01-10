package board.model;

import java.sql.Date;
import java.util.List;

public class BoardVo {
//	"RP_NO"	NUMBER		NOT NULL,
//	"UID"	VARCHAR2(40)		NOT NULL,
//	"RP_CONTENT"	VARCHAR2(1000)		NOT NULL,
//	"RP_TITLE"	VARCHAR2(100)		NOT NULL,
//	"RP_AUTHOR"	VARCHAR2(50)		NOT NULL,
//	"READ_DATE"	DATE		NOT NULL,
//	"REG_DATE"	DATE		NOT NULL,
//	"PHRASE"	VARCHAR(200)		NULL,
//	"RP_READ_CHECK"	NUMBER(1)		NOT NULL
	
	private int rpno;
	private String mid;
	private String rpcontent;
	private String rptitle;
	private String rpauthor;
	private Date readdate;
	private Date regdate;
	private String phrase;
	private int readchk;
	
	@Override
	public String toString() {
		return "BoardVo [rpno = " + rpno + ", mid = "+mid+", rpcontent = "+rpcontent+", rptitle = "+rptitle
				+", rpauthor = "+rpauthor+ ", readdate ="+readdate+", regdate = "+regdate+", phrase = "+phrase
				+", readchk = "+readchk;
	}

	public int getRpno() {
		return rpno;
	}

	public void setRpno(int rpno) {
		this.rpno = rpno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getRpcontent() {
		return rpcontent;
	}

	public void setRpcontent(String rpcontent) {
		this.rpcontent = rpcontent;
	}

	public String getRptitle() {
		return rptitle;
	}

	public void setRptitle(String rptitle) {
		this.rptitle = rptitle;
	}

	public String getRpauthor() {
		return rpauthor;
	}

	public void setRpauthor(String rpauthor) {
		this.rpauthor = rpauthor;
	}

	public Date getReaddate() {
		return readdate;
	}

	public void setReaddate(Date readdate) {
		this.readdate = readdate;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	public int getReadchk() {
		return readchk;
	}

	public void setReadchk(int readchk) {
		this.readchk = readchk;
	}
	
}
