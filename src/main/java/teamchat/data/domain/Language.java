package teamchat.data.domain;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Entity
@Table(name="language")
@JsonIgnoreProperties({"countries"})
public class Language implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8519210466884197198L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="language")
	private String language;
	
	
	@Column(name="code")
	private String code;
	
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="languages")
	private List<Country> countries;


	public Language() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Language(Long id, String language, String code, List<Country> countries) {
		super();
		this.id = id;
		this.language = language;
		this.code = code;
		this.countries = countries;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public List<Country> getCountries() {
		return countries;
	}


	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	

}
