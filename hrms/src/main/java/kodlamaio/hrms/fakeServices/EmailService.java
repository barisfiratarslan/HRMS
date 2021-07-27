package kodlamaio.hrms.fakeServices;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	public boolean verificationEmail(String email) {
		return true;
	}
}
