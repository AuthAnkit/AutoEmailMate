package com.AutoEmailMate.eg.Service.ServiceImpl;

import com.AutoEmailMate.eg.Config.PassWordEncoder;
import com.AutoEmailMate.eg.DTO.request.UserLoginReq;
import com.AutoEmailMate.eg.DTO.request.UserRegisterReq;
import com.AutoEmailMate.eg.Exceptions.EmailAlreadyExists;
import com.AutoEmailMate.eg.Exceptions.IncorrectPassWord;
import com.AutoEmailMate.eg.Exceptions.UserNameAlreadyExists;
import com.AutoEmailMate.eg.Model.User;
import com.AutoEmailMate.eg.Repository.UserRepo;
import com.AutoEmailMate.eg.Service.UserService;
import com.AutoEmailMate.eg.Transformer.UserTransformer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.function.array.OracleUnnestFunction;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String registerUser(UserRegisterReq userRegisterReq) {
        if(userRepo.findByUsername(userRegisterReq.getUsername()).isPresent())
            throw new UserNameAlreadyExists("UserName Already Exists , Choose Other UserName");
        else if(userRepo.findByEmail(userRegisterReq.getEmail()).isPresent())
            throw new EmailAlreadyExists("\"Email Already Exists . LogIn with username and password OR Register with another Account\"");
        User newuser = UserTransformer.toEntity(userRegisterReq);
        newuser.setPassword(passwordEncoder.encode(userRegisterReq.getPassword()));
        userRepo.save(newuser);
        return "User registered successfully with Email : " + newuser.getEmail() + " and Username : " + newuser.getUsername();
    }


    @Override
    public String login(UserLoginReq userLoginReq) {
        if(userRepo.findByUsername(userLoginReq.getUsername()).isPresent()){
            User user = userRepo.findByUsername(userLoginReq.getUsername()).get();
            if(passwordEncoder.matches(userLoginReq.getPassword(), user.getPassword())){
                return "User logged in successfully with username: " + userLoginReq.getUsername();
            }
        }
        throw new IncorrectPassWord("Incorrect Password");
    }
}
