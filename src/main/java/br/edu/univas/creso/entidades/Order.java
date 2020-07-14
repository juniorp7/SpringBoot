package br.edu.univas.creso.entidades;

import java.util.Date;
import java.util.List;

import br.edu.univas.creso.entidades.Auditing;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long orderNumber;
	
	long productCode;
	
	String cpf;
	
	int amount;
	
	Date dateSale;
	
	double value;
	
	@OneToMany(mappedBy = "registerCode", fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	List<Auditing> auditings;

	public List<Auditing> getAuditings() {
		return auditings;
	}

	public void setAuditings(List<Auditing> auditings) {
		this.auditings = auditings;
	}

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public long getProductCode() {
		return productCode;
	}

	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDateSale() {
		return dateSale;
	}

	public void setDateSale(Date dateSale) {
		this.dateSale = dateSale;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	
}
