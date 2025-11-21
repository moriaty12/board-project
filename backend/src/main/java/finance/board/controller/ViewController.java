package finance.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String index() {
        // static 폴더의 index.html로 포워드
        return "forward:/index.html";
    }
}
