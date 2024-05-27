package com.github.mauricioaniche.ck.metrictypes;

import com.github.mauricioaniche.ck.metric.CouplingExtras;
import com.github.mauricioaniche.ck.metric.NOCExtras;

public class ClassMetrics {
	private int dit;
	private int noc = -1;
	private int wmc;
	private int cbo;
	private int cboModified = -1;
	private int fanin = -1;
	private int fanout = -1;
	private int lcom;
	private float lcomNormalized;
	private int rfc;
	private float tightClassCohesion;
	private float looseClassCohesion;

	private String className;

	public ClassMetrics(String className) {
		this.className = className;
	}

	public int getDit() {
		return dit;
	}

	public void setDit(int dit) {
		this.dit = dit;
	}

	public int getNoc() {
		if (this.noc == -1) {
			NOCExtras extras = NOCExtras.getInstance();
			this.setNoc(extras.getNocValueByName(this.className));
		}

		return this.noc;
	}

	public void setNoc(int noc) {
		this.noc = noc;
	}

	public void setWmc(int cc) {
		this.wmc = cc;
	}

	public int getWmc() {
		return wmc;
	}

	public int getCbo() {
		return cbo;
	}

	public void setCbo(int cbo) {
		this.cbo = cbo;
	}

	public int getCboModified() {
		if (this.cboModified == -1) {
			CouplingExtras extras = CouplingExtras.getInstance();
			this.setCboModified(extras.getValueCBOClass(this.className));
		}
		return cboModified;
	}

	public void setCboModified(int cboModified) {
		this.cboModified = cboModified;
	}

	public int getFanin() {

		if (this.fanin == -1) {
			CouplingExtras extras = CouplingExtras.getInstance();
			this.setFanin(extras.getValueFanInClass(this.className));
		}

		return fanin;
	}

	public void setFanin(int fanin) {
		this.fanin = fanin;
	}

	public int getFanout() {

		if (this.fanout == -1) {
			CouplingExtras extras = CouplingExtras.getInstance();
			this.setFanout(extras.getValueFanOutClass(this.className));
		}

		return fanout;
	}

	public void setFanout(int fanout) {
		this.fanout = fanout;
	}

	public void setLcom(int lcom) {
		this.lcom = lcom;
	}

	public int getLcom() {
		return lcom;
	}

	public void setLcomNormalized(float lcomNormalized) {
		this.lcomNormalized = lcomNormalized;
	}

	public float getLcomNormalized() {
		return lcomNormalized;
	}

	public void setRfc(int rfc) {
		this.rfc = rfc;
	}

	public int getRfc() {
		return rfc;
	}

	public float getTightClassCohesion() {
		return tightClassCohesion;
	}

	public float getLooseClassCohesion() {
		return looseClassCohesion;
	}

	public void setTightClassCohesion(float tightClassCohesion) {
		this.tightClassCohesion = tightClassCohesion;
	}

	public void setLooseClassCohesion(float looseClassCohesion) {
		this.looseClassCohesion = looseClassCohesion;
	}
}
