package cbo;


public class OverridenCouplingCallRootTargetClass {

	public void methodAtTarget() {
	}
	
}


public class OverridenCouplingCallRootDescendent1Class extends OverridenCouplingCallRootTargetClass {
	
	@Override
	public void methodAtTarget() {
	}
	
}


public class OverridenCouplingCallRootDescendent2Class extends OverridenCouplingCallRootTargetClass {
	
	@Override
	public void methodAtTarget() {
	}
	
}

public class OverridenCouplingCallRootSourceClass  {
	
	public void methodAtSource() {
		OverridenCouplingCallRootTargetClass target = new OverridenCouplingCallRootTargetClass();
		target.methodAtTarget();
	}
	
}

