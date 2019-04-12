package com.fms.TestPrometheus;

import io.micrometer.core.instrument.AbstractMeter;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.util.MeterEquivalence;
import io.prometheus.client.DoubleAdder;

class MyCounter extends AbstractMeter implements Counter {

	private DoubleAdder count = new DoubleAdder();

	MyCounter(Meter.Id id) {
		super(id);
	}

	@Override
	public void increment(double amount) {
		if (amount > 0)
			count.add(amount);
	}

	@Override
	public double count() {
		return count.doubleValue();
	}

	@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
	@Override
	public boolean equals(Object o) {
		return MeterEquivalence.equals(this, o);
	}

	public void assign(double amount) {
		count.reset();
		increment(amount);
	}

	@Override
	public int hashCode() {
		return MeterEquivalence.hashCode(this);
	}
}
