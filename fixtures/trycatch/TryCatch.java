package trycatch;

import java.io.IOException;

class TryCatch {
	
	public void m1() {
		try {

			try {

			} catch(Exception e) {

			}

		} catch(Exception e) {

		}
	}

	public void m2() {
		try {

		} catch(Exception e) {

		} finally {

		}
	}

	public void m3() {
		try {

		} catch(IndexOutOfBoundsException|IOException e) {

		}
	}

	public void m4() {
	}
	
	public void m5() {
		try {
			
		} catch(IndexOutOfBoundsException e1) {
			
		} catch(IOException e2) {

		}
	}
}