package com.mark.marker_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.zalando.problem.spring.web.EnableProblemSupport;

@SpringBootApplication
@EnableProblemSupport
public class MarkerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarkerApiApplication.class, args);
	}

}