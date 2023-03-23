package cbo;

public class LocalInheritanceCouplingTargetClass {

	public void methodAtTarget() {
	}
	
}

public class LocalInheritanceCouplingSourceClass extends LocalInheritanceCouplingTargetClass {
	
	public void methodAtSource() {
		this.methodAtTarget();
	}
}

