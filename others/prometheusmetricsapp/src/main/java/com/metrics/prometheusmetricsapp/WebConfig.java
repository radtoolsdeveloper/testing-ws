package com.metrics.prometheusmetricsapp;

import javax.servlet.http.HttpServlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.prometheus.client.exporter.MetricsServlet;

@Configuration
public class WebConfig {
	@Bean
	public ServletRegistrationBean<HttpServlet> countryServlet() {
		ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
		servRegBean.setServlet(new MetricsServlet());
		servRegBean.addUrlMappings("/newmetrics/*");
		servRegBean.setLoadOnStartup(1);
		return servRegBean;
	}
}
