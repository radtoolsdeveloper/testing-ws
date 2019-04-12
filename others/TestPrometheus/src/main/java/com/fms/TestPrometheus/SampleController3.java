package com.fms.TestPrometheus;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.MockClock;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.CollectorRegistry;

@Controller
public class SampleController3 {
	PrometheusMeterRegistry prometheusMeterRegistry = null;

	@Bean
	public PrometheusMeterRegistry prometheusMeterRegistry(PrometheusConfig config, CollectorRegistry collectorRegistry,
			Clock clock) {
		prometheusMeterRegistry = new PrometheusMeterRegistry(config, collectorRegistry, clock);
		return prometheusMeterRegistry;
	}

	@GetMapping("/sample/metrics3")
	@ResponseBody
	public String carrierJobMetrics() {
		PrometheusMeterRegistry prometheusMeterRegistry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT, new CollectorRegistry(true), new MockClock());
		prometheusMeterRegistry.config().commonTags("application", "COC");
		Metrics.addRegistry(prometheusMeterRegistry);
		Random rand = new Random();
		AtomicInteger rand_int3 = new AtomicInteger(rand.nextInt(10));
		
		prometheusMeterRegistry.gauge("carrier.jobs.with.status.size", rand_int3, null);
		
		//prometheusMeterRegistry.newGauge("carrier.jobs.with.status.size", null, null);
		
		Metrics.gauge("carrier.jobs.with.status.size", rand_int3);
		
		Gauge gauge = Gauge.builder("gauge", rand_int3, AtomicInteger::get).baseUnit("bytes").register(prometheusMeterRegistry);
		
		/*MyGauge myGauge = MyGauge.
		Gauge gauge = Metrics.globalRegistry.find("carrier.jobs.with.status.size").gauge();*/

		System.out.println("HELLO IM HERE  : *************** " + rand_int3);
		System.out.println("HELLO IM HERE  : *************** " + gauge.value());

		return "SUCCESS";
	}
	
	@GetMapping("/sample/metrics4")
	@ResponseBody
	public String carrierJobMetrics4() {
		PrometheusMeterRegistry prometheusMeterRegistry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT, new CollectorRegistry(true), new MockClock());
		prometheusMeterRegistry.config().commonTags("application", "COC");
		//Metrics.removeRegistry(Metrics.globalRegistry);
		Metrics.addRegistry(prometheusMeterRegistry);
		
		Random rand = new Random();
		AtomicInteger rand_int3 = new AtomicInteger(rand.nextInt(10));
		
		//prometheusMeterRegistry.gauge("carrier.jobs.with.status.size", rand_int3, null);
		
		//prometheusMeterRegistry.newGauge("carrier.jobs.with.status.size", null, null);
		
		prometheusMeterRegistry.gauge("carrier.jobs.with.status.size", rand_int3);
		
		Metrics.globalRegistry.get("carrier.jobs.with.status.size");
		Metrics.gauge("guage", rand_int3);
		
		//Gauge gauge = Gauge.builder("carrier.jobs.with.status.size", rand_int3, AtomicInteger::get).baseUnit("bytes").register(prometheusMeterRegistry);
		/*MyGauge myGauge = MyGauge.
		Gauge gauge = Metrics.globalRegistry.find("carrier.jobs.with.status.size").gauge();*/

		System.out.println("HELLO IM HERE  : *************** " + rand_int3);
		//System.out.println("HELLO IM HERE  : *************** " + gauge.value());

		return "SUCCESS";
	}
}