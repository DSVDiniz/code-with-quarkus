package org.acme;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@DisallowConcurrentExecution
@ApplicationScoped//comment this to cause the issue
public class MyJob implements Job {
	@Transactional
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("start");
		PanacheQuery<MyEntity> assasas = MyEntity.find("from MyEntity");
		List<MyEntity> list = MyEntity.findAll().list();
		System.out.println("end");
	}

}
