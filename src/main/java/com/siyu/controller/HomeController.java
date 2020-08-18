package com.siyu.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView test(HttpServletResponse response) throws IOException {
        return new ModelAndView("home").addObject("ssd", "abc");
    }


    @RequestMapping(value = "/put", method = RequestMethod.GET)
    public ModelAndView setSessionValue(HttpSession session, @RequestParam("value") String value) throws IOException {
        session.setAttribute("value", value);
        return new ModelAndView("home").addObject("value", session.getAttribute("value")).addObject("sessionId"
                , session.getId());
    }
}
