package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class MyScheduler {
	@Inject
	Scheduler quartz;

	void onStart(@Observes StartupEvent event) throws SchedulerException {
		JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("Process", "Identity").build();
		Trigger trigger = TriggerBuilder.newTrigger()
										.withIdentity("Trigger", "Identity")
										.startNow()
										.withSchedule(SimpleScheduleBuilder	.simpleSchedule()
																			.withIntervalInSeconds(1)
																			.repeatForever())
										.build();
		quartz.scheduleJob(job, trigger);
	}
}
