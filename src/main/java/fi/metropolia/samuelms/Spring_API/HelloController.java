package fi.metropolia.samuelms.Spring_API;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/test")
    public String test() {
        return "TEST!!!";
    }
}
