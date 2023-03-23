package cbo;

public class ForeignInheritanceCouplingAncestorClass {

	public void methodAtAncestor() {
	}
	
}

public class ForeignInheritanceCouplingTargetClass extends ForeignInheritanceCouplingAncestorClass {
	
}

public class ForeignInheritanceCouplingSourceClass  {
	
	public void methodAtSource() {
		ForeignInheritanceCouplingTargetClass target = new ForeignInheritanceCouplingTargetClass();
		target.methodAtAncestor();
	}
}

