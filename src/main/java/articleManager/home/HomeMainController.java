package articleManager.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class HomeMainController {

    @GetMapping("/")
    public String index() {
        return "home/main";
    }

}
