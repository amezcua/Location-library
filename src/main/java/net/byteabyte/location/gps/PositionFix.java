package net.byteabyte.location.gps;

public enum PositionFix {
	NotAvailableOrInvalid,
	SPSMode,
	DifferentialGPS,
	PPSMode,
	RealTimeKinematic,
	FloatRTK,
	Estimated,
	ManualInputMode,
	SimulationMode
}
