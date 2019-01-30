package teamchat.data.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Entity
@Table(name="currency")
public class Currency implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="currency_name")
	private String currencyName;
	
	@Column(name="currency_code")
	private String currencyCode;
	
	@Column(name="currency_symbol")
	private String currencySymbol;
	
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="currencies")//currencies is the field identifier on class country
	private List<Country> countries;

	

	public Currency() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Currency(Long id, String currencyName, String currencyCode, String currencySymbol, List<Country> countries) {
		super();
		this.id = id;
		this.currencyName =currencyName;
		this.currencyCode = currencyCode;
		this.currencySymbol = currencySymbol;
		this.countries = countries;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCurrencyName() {
		return currencyName;
	}



	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}



	public String getCurrencyCode() {
		return currencyCode;
	}



	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}



	public String getCurrencySymbol() {
		return currencySymbol;
	}



	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}



	public List<Country> getCountries() {
		return countries;
	}



	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	

	
}
