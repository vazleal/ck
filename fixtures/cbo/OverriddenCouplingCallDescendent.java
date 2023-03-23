package cbo;


public class OverridenCouplingCallDescendentTargetClass {

	public void methodAtTarget() {
	}
	
}


public class OverridenCouplingCallDescendentDescendent1Class extends OverridenCouplingCallDescendentTargetClass {
	
	@Override
	public void methodAtTarget() {
	}
	
}


public class OverridenCouplingCallDescendentDescendent2Class extends OverridenCouplingCallDescendentTargetClass {
	
	@Override
	public void methodAtTarget() {
	}
	
}

public class OverridenCouplingCallDescendentSourceClass  {
	
	public void methodAtSource() {
		OverridenCouplingCallDescendentTargetClass target = new OverridenCouplingCallDescendentDescendent1Class();
		target.methodAtTarget();
	}
	
}

