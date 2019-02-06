package teamchat.rest.controllers;

import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import teamchat.data.domain.UserAdress;
import teamchat.exception.request.IdException;
import teamchat.exception.request.NullReferenceException;
import teamchat.service.UserAdressService;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Controller
@RequestMapping(UserAdressRestController.URI)
class UserAdressRestController {

	protected final static String URI = "/api/user_adresses";

	private UserAdressService userAdressService;

	@Autowired
	public UserAdressRestController(UserAdressService userAdressService) {
		super();
		this.userAdressService = userAdressService;
	}

	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@RequestMapping(path = { "", "/", "/all", "/list" }, method = RequestMethod.GET, produces = "application/json")
	public List<UserAdress> getAllUserAdresses() throws Exception {
		return userAdressService.getAll();
	}

	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@RequestMapping(path = { "/{id}" }, method = RequestMethod.GET, produces = "application/json")
	public UserAdress getUserAdressById(@PathVariable("id") String id) throws Exception {
		if (NumberUtils.isParsable(id)) {
			Long userAdressId = Long.parseLong(id);
			return userAdressService.getById(userAdressId);
		} else
			throw new IdException("User adress id " + id + " is not parsable.Must be an integer.");
	}

	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@RequestMapping(params = { "street" }, method = RequestMethod.GET, produces = "application/json")
	public List<UserAdress> getUserAdressesByStreetLike(@RequestParam("street") String street) throws Exception {
		return userAdressService.getByStreetLike(street);
	}

	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@RequestMapping(params = { "city" }, method = RequestMethod.GET, produces = "application/json")
	public List<UserAdress> getUserAdressesByCity(@RequestParam("city") String city) throws Exception {
		return userAdressService.getByCityLike(city);
	}

	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@RequestMapping(params = { "countryId" }, method = RequestMethod.GET, produces = "application/json")
	public List<UserAdress> getUserAdressesByCountryId(@RequestParam("countryId") String countryId) throws Exception {
		if (NumberUtils.isParsable(countryId)) {
			Long id = Long.parseLong(countryId);
			return userAdressService.getByCountryId(id);
		} else
			throw new IdException("Country id " + countryId + " is not parsable.Must be an integer.");
	}

	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public UserAdress saveUserAdress(@RequestBody UserAdress userAdress) throws Exception {
		if (userAdress == null)
			throw new NullReferenceException("User adress reference binded is null.");

		return userAdressService.create(userAdress);
	}

	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@RequestMapping(path = { "/{id}" }, method = RequestMethod.PUT, produces = "application/json")
	public UserAdress editUserAdress(@PathVariable("id") String id, @RequestBody UserAdress userAdress)
			throws Exception {
		if (NumberUtils.isParsable(id)) {
			Long userAdressId = Long.parseLong(id);
			if (userAdress == null)
				throw new NullReferenceException("User adress reference binded is null.");
			userAdress.setId(userAdressId);

			return userAdressService.edit(userAdress);
		} else
			throw new IdException("User adress id " + id + " is not parsable.Must be an integer.");
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseBody
	@RequestMapping(path = { "/{id}" }, method = RequestMethod.DELETE, produces = "application/json")
	public void deleteUserAdress(@PathVariable("id") String id) throws Exception {
		if (NumberUtils.isParsable(id)) {
			Long userAdressId = Long.parseLong(id);
			userAdressService.deleteById(userAdressId);
		} else
			throw new IdException("User adress id " + id + " is not parsable.Must be an integer.");
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@RequestMapping("/*")
	public ResponseEntity<Object> unMappedRequests() throws Exception {
		return new ResponseEntity<>("Wrong URI or request method.", new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

}
