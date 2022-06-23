package com.emrap.app;

import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.emrap.app.background.jobrunr.service.PickWinnerJobService;

@SpringBootApplication
@EnableAsync
public class AppApplication {

	@Autowired
	private JobScheduler jobScheduler;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@jakarta.annotation.PostConstruct
	public void scheduleRecurrently() {
		jobScheduler.<PickWinnerJobService>scheduleRecurrently(Cron.monthly(1),
				x -> x.executeJob("a recurring job"));
	}
}
