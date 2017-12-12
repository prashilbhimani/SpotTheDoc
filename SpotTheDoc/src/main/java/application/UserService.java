package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	public RoleType login(String username, String password){
		if (userRepo.exists(username)){
			User temp=(User) userRepo.findOne(username);
			if(temp.getPassword().equals(password))
    			return temp.getRole();
		}
		return RoleType.UnRegistered;
	}

	public boolean checkUserNameExists(String username) {
		return userRepo.exists(username);
	}
	
	public void showAllUsers(){
		for (User u:userRepo.findAll()){
			System.out.println(u.getUserName());
			System.out.println("HI");
		}
		
	}

	
}
