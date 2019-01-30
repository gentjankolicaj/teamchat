package teamchat.data.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.JoinColumn;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Entity
@Table(name="country")
@JsonIgnoreProperties({"userAdressList","currencies","languages"})//just for testing
public class Country implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="country_name")
	private String countryName;
	
	@Column(name="iso_codes")
	private String isoCodes;
	
	@Column(name="phone_prefix")
	private String phonePrefix;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="country")
	private List<UserAdress> userAdressList;
	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="country_currency",
			joinColumns= { @JoinColumn(name="country_id")},
			inverseJoinColumns= { @JoinColumn(name="currency_id")})
	private List<Currency> currencies;
	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="country_language",
	joinColumns= @JoinColumn(name="country_id"),
	inverseJoinColumns=@JoinColumn(name="language_id"))
	private List<Language> languages;


	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Country(Long id, String countryName, String isoCodes, String phonePrefix, List<UserAdress> userAdressList,
			List<Currency> currencies, List<Language> languages) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.isoCodes = isoCodes;
		this.phonePrefix = phonePrefix;
		this.userAdressList = userAdressList;
		this.currencies = currencies;
		this.languages = languages;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public String getIsoCodes() {
		return isoCodes;
	}


	public void setIsoCodes(String isoCodes) {
		this.isoCodes = isoCodes;
	}


	public String getPhonePrefix() {
		return phonePrefix;
	}


	public void setPhonePrefix(String phonePrefix) {
		this.phonePrefix = phonePrefix;
	}


	public List<UserAdress> getUserAdressList() {
		return userAdressList;
	}


	public void setUserAdressList(List<UserAdress> userAdressList) {
		this.userAdressList = userAdressList;
	}


	public List<Currency> getCurrencies() {
		return currencies;
	}


	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}


	public List<Language> getLanguages() {
		return languages;
	}


	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}


	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + countryName + ", isoCodes=" + isoCodes + ", phonePrefix="
				+ phonePrefix + "]";
	}

	

}
