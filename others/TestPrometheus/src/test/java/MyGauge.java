package io.micrometer.prometheus;

import java.lang.ref.WeakReference;
import java.util.function.ToDoubleFunction;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.util.MeterEquivalence;
import io.micrometer.core.lang.Nullable;

public class MyGauge<T> extends AbstractCompositeMeter<Gauge> implements Gauge {

	@Override
	public Id getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double value() {
		// TODO Auto-generated method stub
		return 0;
	}
}
