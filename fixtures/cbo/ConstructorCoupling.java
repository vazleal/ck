package cbo;

public class ConstructorCouplingTargetClass {

	public void methodAtTarget() {
	}
	
}

public class ConstructorCouplingSourceClass {
	
	public void methodAtSource() {
		new ConstructorCouplingTargetClass();
	}
}

