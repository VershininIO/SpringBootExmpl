package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProcessStringController {

    @RequestMapping("/inc/str")
    @ResponseBody
    public String process(@RequestParam String str) {

        String[] strArr = str.split(" ");

        StringBuilder sb = new StringBuilder();

        for (String elStr: strArr) {
            int i = 0;
            try {
                i = Integer.parseInt(elStr);
            } catch (Exception e){
                throw new RuntimeException("string not a digit " + elStr);
            };

            i++;
            sb.append(i);
            sb.append(" ");
        }

        return sb.toString();
    }
}
