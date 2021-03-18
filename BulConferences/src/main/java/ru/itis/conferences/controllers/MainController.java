package ru.itis.conferences.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.conferences.models.Feedback;
import ru.itis.conferences.models.User;
import ru.itis.conferences.security.details.UserDetailsImpl;
import ru.itis.conferences.services.FeedbackService;
import ru.itis.conferences.services.TelegramService;
import ru.itis.conferences.services.UserService;
import ru.itis.conferences.utils.Attributes;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class MainController {

    private final FeedbackService feedbackService;
    private final UserService userService;
    private final TelegramService telegramService;

    @Autowired
    public MainController(FeedbackService feedbackService, UserService userService,
                          TelegramService telegramService) {
        this.feedbackService = feedbackService;
        this.userService = userService;
        this.telegramService = telegramService;
    }

    @GetMapping("/developers")
    public String getDevelopers(HttpSession session) {
        pushSession(session);
        return "developers";
    }

    @GetMapping("/feedback")
    public String getFeedback() {
        return "feedback";
    }

    @PostMapping("/feedback")
    public String feedback(ModelMap modelMap, HttpSession session, Feedback feedback){
        Optional<User> user = userService.findByEmail((String) session.getAttribute("email"));
        feedback.setOwner_id(user.get().getId());
        feedback.setProcessed(false);
        feedbackService.add(feedback);
        telegramService.sendMessageForFeedback(feedback);
        Attributes.addSuccessAttributes(modelMap,"Success!");
        return "/feedback";
    }

    @GetMapping("/logout")
    public String getExit(HttpSession session) {
        session.removeAttribute("email");
        session.removeAttribute("nickname");
        return "redirect:/signIn";
    }

    @GetMapping("/home")
    public String getHome(HttpSession session) {
        pushSession(session);
        return "home";
    }

    @GetMapping("/courses")
    public String getCourses() {
        return "courses";
    }

    @GetMapping("/course-single")
    public String getCourse(){
        return "/course-single";
    }

    @GetMapping("/aboutUs")
    public String getAboutUs(){
        return "about";
    }

    @GetMapping("/admissions")
    public String getAdmissions(){
        return "admissions";
    }

    private void pushSession(HttpSession session){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName()).orElse(new User());
        session.setAttribute("nickname", user.getNickname());
        session.setAttribute("email", user.getEmail());
    }
}