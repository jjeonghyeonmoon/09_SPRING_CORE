package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/* comment.
*   @Configuration 어노테이션 해당 클래스가
*   빈을 생성하는 클래스임을 컨데이너에게 알려준다.
*  */
@Configuration("configuration02")
public class ContextConfiguration {

    /* 1명의 회원을 Bean 등록 */
    /* comment.
    *   @Bean 어노테이션은 해당 메소드의 변환 값을 컨테이너에
    *   Bean(객체) 로 등록하겠다는 의미이다.
    *   이름을 별도로 지정하지 않으면 메소드 이름을 id로 인식한다.*/
    @Bean(name = "member") // <-- 이거를 설정하지 않는다고한다면 아래 getMember가 아이디가 된다.
    public MemberDTO getMember() {
        return  new MemberDTO(2,"user02","pass02","조팽팽");
    }

}
