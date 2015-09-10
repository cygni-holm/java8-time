package se.cygni.calendar;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calendar {
	private String name;

	private List<ActivityTemplate> activityTemplates = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ActivityTemplate> getActivityTemplates() {
		return new ArrayList<ActivityTemplate>(activityTemplates);
	}

	public void setActivityTemplates(List<ActivityTemplate> activityTemplates) {
		this.activityTemplates = activityTemplates;
	}

	public void addActivityTemplate(ActivityTemplate activityTemplate) {
		activityTemplates.add(activityTemplate);
	}

	public List<Activity> getActivities(ZonedDateTime now, ZonedDateTime start, ZonedDateTime end) {
		return activityTemplates.stream().flatMap(template -> template.getActivities(now, start, end).stream())
				.collect(Collectors.toList());
	}
}
