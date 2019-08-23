package com.art.experience.dev.Configuration;

import java.util.concurrent.Executor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class SpringConfig {

  @Bean(name = "threadPoolTaskExecutorBean")
  public Executor threadPoolTaskExecutorBean() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(5);
    executor.setMaxPoolSize(5);
    executor.setQueueCapacity(200);
    executor.setThreadNamePrefix("Art-Experience");
    executor.initialize();
    return executor;
  }
}
