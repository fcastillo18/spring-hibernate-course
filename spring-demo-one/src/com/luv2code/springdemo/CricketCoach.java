package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	private String emailAddress;
	private String team;

	public CricketCoach() {
		System.out.println("CricketCoach: inside no arg constructor");
	}
	
	@Override
	public String getDailyWorkout() {

		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDaiyFortune() {

		return fortuneService.getFortune();
	}
	
	public void setFortuneService(FortuneService fortuneServive) {
		System.out.println("CricketCoach: inside set method");
		this.fortuneService = fortuneServive;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: Setting email");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: Setting team");
		this.team = team;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}
	
	
	
}
