package org.example.alzo.servicesImp;

import lombok.AllArgsConstructor;
import org.example.alzo.daos.UserRepository;
import org.example.alzo.dtos.SignInRequest;
import org.example.alzo.dtos.SignInResponse;
import org.example.alzo.dtos.SignUpRequest;
import org.example.alzo.entities.Task;
import org.example.alzo.entities.User;
import org.example.alzo.services.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {
    // Implement methods defined in the service interface
    @Autowired
    private final UserRepository userRepository;


    public String encodePassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Method to check if the raw password matches the encoded password
    public boolean checkPassword(String rawPassword, String hashedPassword) {
        return BCrypt.checkpw(rawPassword, hashedPassword);
    }

    @Override
    public User signUp(SignUpRequest signUpRequest) {
        // Check if email is already in use
        if (userRepository.findByEmail(signUpRequest.getEmail()).isPresent()) {
            return null;
        } else {

            // Create a new User entity
            User user = new User();
            user.setEmail(signUpRequest.getEmail());
            user.setPassword(this.encodePassword((signUpRequest.getPassword()))); // Hash the password
            user.setFirstName(signUpRequest.getFirstName());
            user.setLastName(signUpRequest.getLastName());
            user.setAge(signUpRequest.getAge());
            user.setMedicalCondition(signUpRequest.getMedicalCondition());
            user.setEmergencyContact(signUpRequest.getEmergencyContact());
            user.setDescription(signUpRequest.getDescription() );
            user.setBirthday(signUpRequest.getBirthday());

            // Save user to the repository
            return userRepository.save(user);
        }
    }


    @Override
    public SignInResponse signIn(SignInRequest signInRequest) {
        // Retrieve the user by email

        Optional <User> userOptional = userRepository.findByEmail(signInRequest.getEmail()) ;

        if (userOptional.isPresent()) {
            User user = userOptional.get();


            // Check if the password matches the hashed password
            if (!this.checkPassword(signInRequest.getPassword(), user.getPassword())) {
                // password doesn t match
                return null;
            }

            // Return user details without password
            SignInResponse res = new SignInResponse(
                    user.getUserID(),
                    user.getEmail(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getAge(),
                    user.getMedicalCondition(),
                    user.getEmergencyContact(),
                    user.getDescription(),
                    user.getBirthday()
            );
            return res;
        }
        else return null ;
    }

    @Override
    public List<Task> getTasksByUserId(Long userId) {
        // Fetch the user by ID
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            // Return the list of tasks associated with the user
            return user.getTaskList();
        }
     else return null;
    }

}