/*package com.fms.TestPrometheus;

import java.lang.ref.WeakReference;
import java.util.function.ToDoubleFunction;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.noop.NoopGauge;
import io.micrometer.core.lang.Nullable;

public class MyGauge<T> extends AbstractCompositeMeter<Gauge> implements Gauge {
	private final WeakReference<T> ref;
	private final ToDoubleFunction<T> f;

	MyGauge(Meter.Id id, @Nullable T obj, ToDoubleFunction<T> f) {
		super(id);
		ref = new WeakReference<>(obj);
		this.f = f;
	}

	public double value() {
		return null;
	}

	Gauge newNoopMeter() {
		return new NoopGauge(getId());
	}

	Gauge registerNewMeter(MeterRegistry registry) {
		final T obj = ref.get();
		if (obj == null) {
			return null;
		}

		return Gauge.builder(getId().getName(), obj, f).tags(getId().getTags()).description(getId().getDescription())
				.baseUnit(getId().getBaseUnit()).register(registry);
	}

	@Override
	public Id getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
*/