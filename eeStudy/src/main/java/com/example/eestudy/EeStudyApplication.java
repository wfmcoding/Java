package com.example.eestudy;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableCaching //开启缓存
@EnableScheduling //开启定时任务
public class EeStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EeStudyApplication.class, args);
    }
}
