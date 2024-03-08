/*Spring 프레임워크를 사용하여 웹 애플리케이션을 개발하는데 사용되는 컨트롤러(Controller) 클래스*/
package com.hooong.simpleMember.Controller;
/* 이 코드는 해당 클래스가 `com.hooong.simpleMember.Controller` 패키지에 속한다. */

/* Member, MemberDto, MemberService를 가져온다.  */
import com.hooong.simpleMember.Domain.Member;
import com.hooong.simpleMember.Dto.MemberDto;
import com.hooong.simpleMember.Service.MemberService;


import lombok.AllArgsConstructor;
/* Lombok(롬복) 라이브러리에서 제공하는 어노테이션 중 하나인 AllArgsConstructor 를 사용하기 위한 import 
AllArgsConstructor : 모든 필드를 인자로 받는 생성자를 자동으로 생성해 주는 어노테이션
해당 클래스의 모든 필드를 초기화하는 생성자를 자동으로 생성해 줌
코드 작성을 간소화, 반복적 작업을 줄이며 코드의 가독성과 유지 보수성을 향상시킨다. 
*/

import org.springframework.context.annotation.Configuration;
/* Configuration 클래스 : 스프링의 IoC 컨테이너가 해당 클래스를 스캔하여 bean으로 등록하고 애플리케이션 컨텍스트를 설정할 때 이 클래스의 설정을 사용함

스프링의 구성(Configuration) 클래스 : 주로 애플리케이션의 구성 요소를 정의하고 관리하는데 사용됨
예 : bean 설정, 데이터베이스 연결, 보안 설정, 캐시 설정을 정의할 수 있음. 

어노테이션이 달린 클래스 : XML 기반 설정 대신 자바 기반 설정을 사용하는데 도움이 됨. */

import org.springframework.stereotype.Controller;

/* 컨트롤러 : Spring Framework에서 사용되는 어노테이션 : 해당 클래스는 스프링 MVC의 컨트롤러이다. 
컨트롤러는 클라이언트의 HTTP 요청을 처리하고 응답을 반환하는데 사용됨
@Controller 어노테이션이 달린 클래스는 스프링 MVC가 자동으로 URL 매핑을 처리하고 요청을 컨트롤러에 라우팅하여 처리할 수 있다. 
 */

 /*스테레오 타입이란? :Spring Framework에서 사용되는 개념 중 하나로, 주로 애플리케이션의 구성 요소를 선언하는 어노테이션의 그룹 */

import org.springframework.ui.Model;
/*Model : 컨트롤러가 View에 데이터를 전달할 때 사용하는 인터페이스. 컨트롤러에서 처리된 결과나 사용자에게 보여줄 데이터를 담아서 전달하는 용도로 사용 */


import org.springframework.validation.BindingResult;
/*BindingResult : 스프링 MVC에서 사용되는 데이터 바인딩 및 유효성 검사 결과를 저장하는 인터페이스. 주로 컨트롤러에서 사용자 입력을 검증하고 결과를 받아온다. */

import org.springframework.web.bind.annotation.GetMapping;
/*GetMapping :  HTTP GET 요청을 처리하는 스프링 MVC 어노테이션,  해당 요청이 들어오면 메소드가 실행되어 지정된 작업을 수행함 */

import org.springframework.web.bind.annotation.PostMapping;
/*PostMapping:  HTTP POST 요청을 처리하는 핸들러 메서드를 정의할 때 사용되는 Spring MVC 어노테이션. */


import javax.validation.Valid;

/*javax.validation : Java 표준 API의 일부로 포함되어 있지는 않다. Bean Validation API의 일부, 자바 EE, 또는 jakarta EE 스펙의 일부, 유효성 검사 기능을 제공한다.  
일반적으로는 Maven Gradle 등의 의존성 관리 도구를 사용하여 필요한 라이브러리를 프로젝트에 추가함 */

/*javax.validation 패키지에서 Valid 어노케이션을 가져온다. 컨트롤러 메서드의 파라미터에 사용되며, 해당 파라미터를 유효성 검사(validation) 대상으로 표시합니다. 주로 사용자 입력 데이터의 유효성을 검사하는 데 활용 */


/*스프링 MVC 관련 어노테이션 리스트

@Controller: 컨트롤러 클래스를 선언하는 데 사용
@RequestMapping: 요청 URL과 컨트롤러 메서드를 매핑하는 데 사용 HTTP 메서드와 URL 패턴을 지정하여 특정 요청에 대한 처리를 담당하는 메서드를 지정
@GetMapping, @PostMapping, @PutMapping, @DeleteMapping: 각각 HTTP GET, POST, PUT, DELETE 요청에 대한 핸들러 메서드를 지정
@RequestParam: HTTP 요청 파라미터를 메서드 파라미터로 전달받을 때 사용
@PathVariable: URL 경로 변수를 메서드 파라미터로 전달받을 때 사용
@ModelAttribute: 요청 파라미터나 세션 등에서 객체를 바인딩하고, 뷰에 전달할 때 사용
@Valid: Bean Validation을 활용하여 요청 데이터의 유효성 검사를 수행할 때 사용*/




@Controller /* 해당 클래스는 스프링 MVC의 컨트롤러입니다. 스프링 MVC는 이 어노테이션이 달린 클래스를 컴포넌트 스캔하여 요청을 처리함*/
@AllArgsConstructor /*Lombok에서 제공하는 어노테이션, 생성자를 자동 생성해 줌 (의존성 주입을 편리하게 처리) */
public class MemberController {d
    private MemberService memberService;
/*MemberService 타입의 멤버 변수를 선언, Member 클래스의 객체를 주입받아 컨트롤러에서 사용할 수 있도록 함. 컨트롤러가 실제 비즈니스 로직을 처리하는데 사용 */


    @GetMapping("/") /*HTTP GET 메소드로 들어오는 /경로 요청을 처리하는 메소드를 정의함. 클라이언트의 요청을 처리하고 뷰를 반환 */
    public String index() {
        return "/home/index";
    }
 /*index() 메소드는 요청을 처리, 처리한 결과로 문자열을 반환하겠다. 리턴해서 home/index를 반환하여 해당 뷰로 넘어가도록 만든다 */


    @GetMapping("/member/signup")
    public String signupForm(Model model) {
        /*회원가입 폼 : GET 요청을 처리하며 /member/signup 경로를 매핑한다. */
        
        model.addAttribute("member",new MemberDto());
        //Model을 받아 회원정보를 담은 MemberDto 객체를 추가한다. 

        return "/member/signupForm";
        /*signupForm을 반환해서 회원가입 폼을 보여준다 */
        
    }

    @PostMapping("/member/signup") /*POST 요청을 처리한다 */
    public String signup(MemberDto memberDto) { /*MemberDto를 받아 회원가입을 하게끔 한다*/
        memberService.signUp(memberDto);
/*memberService를 통해 회원가입을 하고 리다이렉트한다*/
        return "redirect:/"; 
    }

    @GetMapping("/member/login") /*get 요청을 처리한다 */
    public String login() { /*로그인 */
        return "/member/loginForm"; /*로그인 폼을 보여준다 */
    }
}
