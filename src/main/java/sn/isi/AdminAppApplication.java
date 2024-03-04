package sn.isi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sn.isi.entities.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class AdminAppApplication {

	Logger logger= LoggerFactory.getLogger(sn.isi.AdminAppApplication.class);

	@GetMapping("/getUser/{id}")
	public User getUserById(@PathVariable int id) {
		List<User> users=getUsers();
		User user=users.stream().
				filter(u->u.getId()==id).findAny().orElse(null);
		if(user!=null){
			logger.info("user found : {}",user);
			return user;
		}else{
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("User Not Found with ID : {}",id);
			}
			return new User();
		}
	}
	private List<User> getUsers() {
		return Stream.of(new User(1, "Lamine"),
						new User(2, "Ozil"),
						new User(3, "Test"),
						new User(4, "Diop"))
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(sn.isi.AdminAppApplication.class, args);
	}

}
