package articleManager.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import articleManager.member.dto.LoginFormDto;
import articleManager.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MemberController {
    
    private final MemberService memberService;

    @GetMapping("/member/login")
    public String loginPage() {
        return "member/login";
    }

    @PostMapping("/member/login")
    public String loginForm(HttpSession session, LoginFormDto loginForm) {
        log.info("loginId: {}, loginPw: {}", loginForm.getLoginId(), loginForm.getLoginPw());
        memberService.loginCheck(loginForm);
        return "redirect:/member/login";
    }
}
