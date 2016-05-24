# 任务调度框架Quartz
	用两个例子演示如何使用Quartz来进行任务调度
	
# 样例介绍
1. 继承特定基类的定时器
- 实例如：Job1(==com.vince.quartz.job.Job1==)
- 配置如下
```
			<bean name="job1" class="==org.springframework.scheduling.quartz.JobDetailFactoryBean==">
				<property name="jobClass" value="com.vince.quartz.job.Job1" />
				<property name="jobDataAsMap">
					<map>
						<entry key="timeout" value="0" />
					</map>
				</property>
			</bean>
```
2. 不继承特定基类的定时器
- 实例如：Job2(==com.vince.quartz.job.Job2==)
- 配置如下
```
			<bean id="job2" class="org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean">
		<property name="targetObject">
			<bean class="com.vince.quartz.job.Job2" />
		</property>
		<property name="targetMethod" value="doJob2" />
		<!-- 作业不并发调度 -->
		<property name="concurrent" value="false" />
	</bean>
```


# 公共配置
1. 配置作业调度触发器 

```
	<!-- 按照一定频度执行定时任务 -->
	<bean id="simpleTrigger"
		class="org.springframework.scheduling.quartz.SimpleTriggerFactoryBean">
		<!-- <property name="jobDetail" ref="job1" /> -->
		<property name="jobDetail" ref="job2" />
		<property name="startDelay" value="0" /><!-- 调度工厂实例化后，经过0秒开始执行调度 -->
		<property name="repeatInterval" value="2000" /><!-- 每2秒调度一次 -->
	</bean>
```

```
	<!-- 按照指定时间执行定时任务 -->
	<bean id="cronTrigger"
		class="org.springframework.scheduling.quartz.CronTriggerFactoryBean">
		<property name="jobDetail" ref="job1" />
		<property name="cronExpression" value="0 0 12 * * ?" />
	</bean> 
```
	
2. 配置调度工厂

```
<bean class="org.springframework.scheduling.quartz.SchedulerFactoryBean">
		<property name="triggers">
			<list>
				<ref bean="simpleTrigger" />
			</list>
		</property>
</bean>
```

	
	

	
	
	