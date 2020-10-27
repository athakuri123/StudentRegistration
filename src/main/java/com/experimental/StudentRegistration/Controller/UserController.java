package com.experimental.StudentRegistration.Controller;

import com.experimental.StudentRegistration.Model.Student;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController
{
    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public ModelAndView User()
    {
        Student user = new Student();
        ModelAndView modelAndView = new ModelAndView("user", "command", user);
        return modelAndView;
    }

}
