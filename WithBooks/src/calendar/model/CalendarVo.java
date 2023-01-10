package calendar.model;

public class CalendarVo {
	public int id;
	public String mid;
	public String title;
	public String cpcontent;
	public String cpauthor;
	public int cpreadchk;
	public String start;
	public String end;
	public boolean allday;
	public String textColor;
	public String bgColor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCpcontent() {
		return cpcontent;
	}
	public void setCpcontent(String cpcontent) {
		this.cpcontent = cpcontent;
	}
	public String getCpauthor() {
		return cpauthor;
	}
	public void setCpauthor(String cpauthor) {
		this.cpauthor = cpauthor;
	}
	public int getCpreadchk() {
		return cpreadchk;
	}
	public void setCpreadchk(int cpreadchk) {
		this.cpreadchk = cpreadchk;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public boolean isAllday() {
		return allday;
	}
	public void setAllday(boolean allday) {
		this.allday = allday;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	public String getBgColor() {
		return bgColor;
	}
	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
	
	
}
