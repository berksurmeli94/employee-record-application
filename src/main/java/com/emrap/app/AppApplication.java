package com.emrap.app;

import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.emrap.app.background.jobrunr.service.PickWinnerJobService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
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
