package com.fms.TestPrometheus;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

@Controller
public class SampleController {

	@GetMapping("/sample/metrics")
	@ResponseBody
	public String carrierJobMetrics() {

		SimpleMeterRegistry simpleMeterRegistry = new SimpleMeterRegistry();
		simpleMeterRegistry.config().commonTags("application", "COC");
		// simpleMeterRegistry.config().commonTags("statuscount.step","1");
		Metrics.addRegistry(simpleMeterRegistry);

		Random rand = new Random();
		int rand_int1 = rand.nextInt(10);
		int rand_int2 = rand.nextInt(10);
		int rand_int3 = rand.nextInt(10);
		
		/*String carrierJobsWithStatusOk = "carrier.jobs.with.status.ok";
		String carrierJobsWithStatusError = "carrier.jobs.with.status.error";


		Metrics.counter(carrierJobsWithStatusOk);
		Counter okCounter = Metrics.globalRegistry.find(carrierJobsWithStatusOk).counter();// Counter.builder(carrierJobsWithStatusOk).register(simpleMeterRegistry);
		System.out.println(rand_int1);
		okCounter.increment(rand_int1);

		Metrics.counter(carrierJobsWithStatusError);
		Counter errorCounter = Metrics.globalRegistry.find(carrierJobsWithStatusError).counter();
		System.out.println(rand_int2);
		errorCounter.increment(rand_int2);*/

		
		Metrics.gauge("carrier.jobs.with.status.size", rand_int3);
		
		Gauge gauge = Metrics.globalRegistry.find("carrier.jobs.with.status.size").gauge();

		System.out.println("HELLO IM HERE  : *************** " + rand_int3);
		System.out.println("HELLO IM HERE  : *************** " + gauge.value());
		/*CompositeGauge CompositeGauge = new CompositeGauge();
		compositegau gauge = Metrics.globalRegistry.find("carrier.jobs.with.status.size").gauge();*/

		// System.out.println("HELLO IM HERE : *************** " +
		// okCounter.count() + " : " + errorCounter.count());
		return "SUCCESS";
	}

	@GetMapping("/sample/pmetrics")
	@ResponseBody
	public String carrierJobPMetrics() {
		return null;/*
		PrometheusConfig PrometheusConfig = 
		PrometheusMeterRegistry prometheusMeterRegistry = new PrometheusMeterRegistry(null);
		prometheusMeterRegistry.config().commonTags("application", "COC");
		
		prometheusMeterRegistry.
		// simpleMeterRegistry.config().commonTags("statuscount.step","1");
		Metrics.addRegistry(prometheusMeterRegistry);

		String carrierJobsWithStatusOk = "carrier.jobs.with.status.ok";
		String carrierJobsWithStatusError = "carrier.jobs.with.status.error";

		Random rand = new Random();
		int rand_int1 = rand.nextInt(10);
		int rand_int2 = rand.nextInt(10);
		int rand_int3 = rand.nextInt(10);

		Metrics.counter(carrierJobsWithStatusOk);
		Counter okCounter = Metrics.globalRegistry.find(carrierJobsWithStatusOk).counter();// Counter.builder(carrierJobsWithStatusOk).register(simpleMeterRegistry);
		System.out.println(rand_int1);
		okCounter.increment(rand_int1);

		Metrics.counter(carrierJobsWithStatusError);
		Counter errorCounter = Metrics.globalRegistry.find(carrierJobsWithStatusError).counter();
		System.out.println(rand_int2);
		errorCounter.increment(rand_int2);

		List<String> list = new ArrayList<>(4);
		Metrics.gauge("carrier.jobs.with.status.size", rand_int3);
		//Gauge gauge = Gauge.builder("carrier.jobs.with.status.size", list, List::size).register(simpleMeterRegistry);
		Gauge gauge = Metrics.globalRegistry.find("carrier.jobs.with.status.size").gauge();
		
		System.out.println("HELLO IM HERE  : *************** "+ gauge.value());
		CompositeGauge CompositeGauge = new CompositeGauge();
		compositegau gauge = Metrics.globalRegistry.find("carrier.jobs.with.status.size").gauge();
		
		//System.out.println("HELLO IM HERE  : *************** " + okCounter.count() + " : " + errorCounter.count());
		return "SUCCESS";
	*/}
}