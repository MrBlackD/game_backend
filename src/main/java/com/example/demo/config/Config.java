package com.example.demo.config;

import org.jobrunr.jobs.mappers.JobMapper;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.storage.InMemoryStorageProvider;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.utils.mapper.JsonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Config.class)
public class Config {
//    @Bean
//    public StorageProvider storageProvider(JobMapper jobMapper) {
//        InMemoryStorageProvider storageProvider = new InMemoryStorageProvider();
//        storageProvider.setJobMapper(jobMapper);
//        return storageProvider;
//    }
}
