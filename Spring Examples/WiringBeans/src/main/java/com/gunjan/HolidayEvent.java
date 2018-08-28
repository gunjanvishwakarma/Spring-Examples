package com.gunjan;

import org.springframework.context.ApplicationEvent;

public class HolidayEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;

	public HolidayEvent(Object source) {
		super(source);
	}
	
	public String holidayReason(){
		return "Independence Day";
	}

}
