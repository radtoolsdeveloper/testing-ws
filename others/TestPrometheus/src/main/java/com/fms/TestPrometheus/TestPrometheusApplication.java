package com.fms.TestPrometheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.Counter;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.CollectorRegistry;

@SpringBootApplication
public class TestPrometheusApplication {

	PrometheusMeterRegistry prometheusMeterRegistry = null;

	private static Counter okCounter;

	/*public void CommonCrawlerService() {
		this.okCounter = Counter.builder("carrier.jobs.with.status.ok").tags("version", "v1")
				.description("Carrier Jobs with status OK").register(this.prometheusMeterRegistry);

	}*/

	@Bean
	public PrometheusMeterRegistry prometheusMeterRegistry(PrometheusConfig config, CollectorRegistry collectorRegistry,
			Clock clock) {
		prometheusMeterRegistry = new PrometheusMeterRegistry(config, collectorRegistry, clock);
		return prometheusMeterRegistry;
	}

	public static void main(String[] args) {
		SpringApplication.run(TestPrometheusApplication.class, args);
		//TestPrometheusApplication app = new TestPrometheusApplication();
		//app.CommonCrawlerService();
	}

}
