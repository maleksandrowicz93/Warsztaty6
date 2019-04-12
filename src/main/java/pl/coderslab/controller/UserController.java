package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.validation.RegistrationValidationGroup;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String saveRegistration(@Validated(RegistrationValidationGroup.class) User user, BindingResult result) {
    if (result.hasErrors()) {
        return "user/register";
    }

    User existingUser = userRepository.findFirstByEmail(user.getEmail());
    if (existingUser != null) {
        result.addError(new FieldError("user", "email", "This email exist"));
        return "user/register";
    }

    userRepository.save(user);
    return "redirect:/";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@Valid User user, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "user/login";
        }
        User existingUser = userRepository.findFirstByEmailAndPassword(user.getEmail(), user.getPassword());
        if (existingUser == null) {
            result.addError(new FieldError("user", "email", "Email or password is incorrect"));
            return "user/login";
        }

        session.setAttribute("userID", existingUser.getId());

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
