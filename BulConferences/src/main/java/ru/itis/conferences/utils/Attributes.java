package ru.itis.conferences.utils;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class Attributes {

    public static void addSuccessAttributes(ModelMap map, String message){
        map.addAttribute("title", "Good job!");
        map.addAttribute("message", message);
        map.addAttribute("category", "success");
    }

    public static void addErrorAttributes(ModelMap map, String message){
        map.addAttribute("title", "Oops!");
        map.addAttribute("message", message);
        map.addAttribute("category", "error");
    }

    /**
     * Method for adding a window where redirection occurs on successful process
     * @param redirectAttributes Redirect model for adding a message
     * @param message The message displayed in the window on the site
     */
    public static void addSuccessAttributesWithFlash(RedirectAttributes redirectAttributes, String message){
        redirectAttributes.addFlashAttribute("title", "Good job!");
        redirectAttributes.addFlashAttribute("message", message.isEmpty() ? "Success!" : message);
        redirectAttributes.addFlashAttribute("category", "success");
    }

    /**
     * Method for adding a window where redirection occurs in case of an unsuccessful process
     * @param redirectAttributes Redirect model for adding a message
     * @param message The message displayed in the window on the site
     */
    public static void addErrorAttributesWithFlash(RedirectAttributes redirectAttributes, String message){
        redirectAttributes.addFlashAttribute("title", "Oops!");
        redirectAttributes.addFlashAttribute("message", message.isEmpty() ? "Error!" : message);
        redirectAttributes.addFlashAttribute("category", "error");
    }
}
