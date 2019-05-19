package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Event;
import model.EventLocation;

@ManagedBean(name = "eventBean")
@SessionScoped

public class EventBean {

	private static final long serialVersionUID = 3973801993975443027L;

	private int id;
	private String name;
	private String type;
	private int eventLocation;
	private String description;
	List<Event> eventList = new ArrayList<Event>();
	List<EventLocation> eventLocationList = new ArrayList<EventLocation>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Event> getEventList() {
		return eventList;
	}
	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}
	public int getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(int eventLocation) {
		this.eventLocation = eventLocation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<EventLocation> getEventLocationList() {
		return eventLocationList;
	}
	public void setEventLocationList(List<EventLocation> eventLocationList) {
		this.eventLocationList = eventLocationList;
	}
}
