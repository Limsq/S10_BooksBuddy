package calendar.model;

import java.util.ArrayList;
import java.util.Calendar;

public class CalendarService {
	public CalendarDao dao;
	
	public ArrayList<Calendar> calenList(){
		return dao.calenList();
	}
}
