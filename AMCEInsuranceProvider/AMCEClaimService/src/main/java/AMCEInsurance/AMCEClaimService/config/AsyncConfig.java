package AMCEInsurance.AMCEClaimService.config;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncConfig implements AsyncConfigurer{
	private static final Logger logger = LoggerFactory.getLogger(AsyncConfig.class);

	@Override
	@Bean("asyncExecutor")
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	    executor.setCorePoolSize(5);
	    executor.setMaxPoolSize(10);
	    executor.setQueueCapacity(100);
	    executor.setThreadNamePrefix("AsyncWorker-");
	    executor.initialize();
	    return executor;
	}
	
	 @Override
	 public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
	       return (throwable, method, objects) -> {
	           logger.error("Exception in async method: {} with params: {}", method.getName(), objects, throwable);
	       };
	 }
}
