package hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@Path("/person")
public class GreetingResource {


class PersonRestController {

	@Inject
	private final PersonService personService;

	public PersonRestController(PersonService personService) {
		this.personService = personService;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Person findPersonById(@PathVariable("id") Long id) {
		return personService.findPersonById(id);
	}
}
