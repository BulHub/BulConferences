package ru.itis.conferences.utils;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;

public class Before {

    public static void startPage(ModelMap modelMap, HttpSession session, Model model){
        String nickname = (String) session.getAttribute("nickname");
        model.addAttribute("nickname", nickname);
    }
}
