package cde.mc.outageanalytics1.UserRegistrationService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class ApplicationController {

    @GetMapping("/process")
    public String process(){
        return "processing...";
    }
}
