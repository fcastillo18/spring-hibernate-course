package com.luv2code.springdemo;

public class BaseballCoach implements Coach{
	
	//field for dependecy
	private FortuneService fortuneService;
	
	//constructor for dependecy injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDaiyFortune() {
		
		return fortuneService.getFortune();
	}
}
