package com.vince.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * create by wujl on 2016年5月24日
 */
public class Job1 extends QuartzJobBean {

	private int timeout;

	private static int i = 0;

	// 调度工厂实例化后，经过timeout时间开始执行调度

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("定时任务执行中…");
	}

}