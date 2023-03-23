package cbo;


public class AbstractCouplingTargetClass {

	public abstract void methodAtTarget();
	
}


public class AbstractCouplingDescendent1Class extends AbstractCouplingTargetClass {
	
	@Override
	public void methodAtTarget() {
	}
	
}


public class AbstractCouplingDescendent2Class extends AbstractCouplingTargetClass {
	
	@Override
	public void methodAtTarget() {
	}
	
}

public class AbstractCouplingSourceClass  {
	
	public void methodAtSource() {
		AbstractCouplingTargetClass target = new AbstractCouplingDescendent1Class();
		target.methodAtTarget();
	}
	
}

