package JPA.Book.jpashop.api;


import JPA.Book.jpashop.Member.domain.Member;
import JPA.Book.jpashop.Member.services.MemberService;
import jakarta.validation.Valid;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*
 * @Controller, @ResponseBody
 * -> 이 두가지를 합친 것이 바로 @RestController
 * */
@RequiredArgsConstructor
@RequestMapping("/api/member")
@Slf4j
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/v1/signup")
    public ApiMemberResponse saveMemberV1(@RequestBody @Valid Member member) {
        //@RequestBody 는 JsonBody 에 담긴 data 를 Member 객체에 바인딩하는 어노테이션
        Long memberId = memberService.signup(member);
        return ApiMemberResponse.createMemberResponse(memberId, member.getName(), member.getAddress());
    }

    @PostMapping("/v2/signup")
    public ApiMemberResponse saveMemberV2(@RequestBody @Valid ApiMemberRequest request) {

        Long memberId = memberService.signup(request.createApiMemberRequest());
        return ApiMemberResponse.createMemberResponse(memberId, request.getMemberName(), request.getAddress());
    }

}
