package articleManager.member.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import articleManager.member.dto.MemberDto;

@Mapper
public interface MemberMapper {

    Optional<MemberDto> findByLoginId(String loginId);

    int join(MemberDto memberDto);
}
