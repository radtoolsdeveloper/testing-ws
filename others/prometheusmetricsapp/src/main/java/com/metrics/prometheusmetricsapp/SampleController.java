package com.metrics.prometheusmetricsapp;

import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.prometheus.client.Gauge;

@Controller
public class SampleController {

	public static Gauge carrierOkstatusGauge = Gauge.build().name("fms_carrier_job_count_of_status_ok")
			.help("fms carrier job count of status ok").create().register();

	@GetMapping("/sample/newmetrics/gauge")
	@ResponseBody
	public String carrierJobMetricsGauge() {
		Random rand = new Random();
		Integer rand_int1 = rand.nextInt(50);
		System.out.println("Gauge values with time : " + new Date() + " : " + rand_int1);
		carrierOkstatusGauge.setChild(new Gauge.Child() {
			@Override
			public double get() {
				return rand_int1;
			}
		});
		return "SUCCESS:" + rand_int1;
	}
}