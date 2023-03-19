package nullcheck;

public class NullCheck {
	
	public Object a;
	
	public int i;
	
	public void checkEqual() {	
		if(a == null) {}
	}

	public void checkDifferent() {	
		if(a != null) {}
	}
		
	public void checkMultipleConditionsCheck_OneEqual() {	
		if(null == a && i == 0) {}
		if(a == null && (i == 1 || i == 2)) {}
		if(true && (null == a)) {}
	}
		
	public void checkMultipleConditionsCheck_OneDifferent() {	
		if(null != a || i == 0) {}
	}
		
		
	public void checkMultipleConditionsCheck() {	
		if((null == a && null != a) || null == a) {}
		if((null == a && null != a) || (null == a) && (a != null)) {}
		if((null == a && null != a) || (null == a) && a != null) {}
	}

	public void checkMultipleConditionsCheckNested() {	
		if(i == 0) {
			Object b;
			if(b == null) {}
			
			if(b != null) {}
			
			if(null == b) {}
			
			if(null != b) {}
		}
	}
}