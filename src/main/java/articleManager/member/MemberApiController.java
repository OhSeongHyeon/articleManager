package articleManager.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import articleManager.member.dto.LoginFormDto;
import articleManager.member.dto.MemberDto;
import articleManager.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/login")
    public ResponseEntity<?> login(HttpSession session, LoginFormDto loginForm) {
        log.info("sesstion: {}", session.getAttribute("loginId"));
        if (session.getAttribute("loginId") != null) {
            return ResponseEntity.status(HttpStatus.OK).body("로그인되어 있는 상태입니다. 로그아웃 먼저 진행해주세요.");
        }
        log.info("loginId: {}, loginPw: {}", loginForm.getLoginId(), loginForm.getLoginPw());
        MemberDto login = memberService.loginCheck(loginForm);
        log.info("login: {}", login);
        if (login == null) {
            return ResponseEntity.status(HttpStatus.OK).body("아이디 또는 비밀번호가 올바르지 않습니다.");
        }
        session.setAttribute("loginId", login.getLoginId());
        session.setAttribute("member", login.asMap());
        log.info("{}",session.getAttribute("member"));
        return ResponseEntity.status(HttpStatus.OK).body(login);
    }
    
    @PostMapping("/api/logout")
    public ResponseEntity<?> logout(HttpSession session, LoginFormDto loginForm) {
        if (session.getAttribute("loginId") != null) {
            session.removeAttribute("loginId");
            session.removeAttribute("member");
            return ResponseEntity.status(HttpStatus.OK).body("로그아웃 완료.");
        }
        return ResponseEntity.status(HttpStatus.OK).body("로그인 먼저 하세요.");
    }
    
    @PostMapping("/api/join")
    public ResponseEntity<?> join(MemberDto memberDto) {
        log.info("{}", memberDto);
        boolean isSuccess = memberService.join(memberDto);
        if (isSuccess == false) {
            return ResponseEntity.status(HttpStatus.OK).body("이미 존재하는 회원입니다.");
        }
        return ResponseEntity.ok().build();
    }
}


























