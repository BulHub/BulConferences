package ru.itis.conferences.controllers;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.conferences.utils.Attributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.logging.LogManager;

@Controller
public class SignInController {

    /**
     * Method for handling site entry
     * @param request Request to check the session
     * @param modelMap Page model
     * @param error Error object
     */
    @GetMapping("/signIn")
    public String getSignIn(HttpServletRequest request, ModelMap modelMap, @RequestParam(value = "error", required = false) String error){
        LogManager.getLogManager().reset();
        HttpSession session = request.getSession(false);
        if (session != null && error != null){
            AuthenticationException ex = (AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                Attributes.addErrorAttributes(modelMap, ex.getMessage());
            }
        }
        return "signIn";
    }
}
