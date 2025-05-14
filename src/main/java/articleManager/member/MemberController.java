package articleManager.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import articleManager.member.dto.LoginFormDto;
import articleManager.member.dto.MemberDto;
import articleManager.member.service.MemberService;
import articleManager.member.vo.UserVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/login")
    public String loginPage(HttpSession session) {
        UserVO user = (UserVO) session.getAttribute("user");
        return user == null ? "member/login" : "redirect:/home/main";
    }

    @PostMapping("/member/login")
    public String loginForm(HttpSession session, LoginFormDto loginForm) {
        log.info("loginId: {}, loginPw: {}", loginForm.getLoginId(), loginForm.getLoginPw());
        MemberDto member = memberService.loginCheck(loginForm);
        log.info("loginCheck: {}", member);

        // 존재 하지 않는 회원
        if (member == null) {
            return "redirect:/member/login";
        }

        UserVO user = UserVO.from(member);
        session.setAttribute("user", user);

        return "redirect:/home/main";
    }
    
    @PostMapping("/member/logout")
    public String logout(HttpSession session) {
        UserVO user = (UserVO) session.getAttribute("user");
        if (user == null) {
            return "redirect:/home/main";
        }
        session.invalidate();
        return "redirect:/home/main";
    }
    
}
