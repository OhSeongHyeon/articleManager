package articleManager.member.service;

import org.springframework.stereotype.Service;

import articleManager.member.dto.LoginFormDto;
import articleManager.member.dto.MemberDto;
import articleManager.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberDto loginCheck(LoginFormDto form) {
        return memberMapper.findByLoginId(form.getLoginId())
            .filter(member -> member.getLoginPw().equals(form.getLoginPw()))
            .orElse(null);
    }
    
    public boolean join(MemberDto memberDto) {
        MemberDto member = memberMapper.findByLoginId(memberDto.getLoginId()).orElse(null);
        if (member != null) {
            // 이미 존재하는 회원
            return false;
        }
        memberMapper.join(memberDto);
        return true;
    }

}
