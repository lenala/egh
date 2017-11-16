package com.microsoft.egh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Dailyinput")
public class ClientFact {

	@Id
	@Column(name = "clientid")
	private Integer clientId;

	private Date date;

	private boolean breakfast;

	public ClientFact() {
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isBreakfast() {
		return breakfast;
	}

	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	@Override
	public String toString() {
		return super.toString();
//				String.format("ClientFact[id=%d, firstName='%s', lastName='%s']", id,
//				firstName, lastName);
	}

}
