package com.hooong.simpleMember.Service;

import com.hooong.simpleMember.Domain.Member;
import com.hooong.simpleMember.Dto.MemberDto;
import com.hooong.simpleMember.Repository.MemberRepository;
import lombok.AllArgsConstructor;


import org.springframework.security.core.GrantedAuthority;
/*스프링 시큐리티에서 사용되는 인터페이스 : GrantedAuthority , 사용자의 권한을 나타냄*/

import org.springframework.security.core.authority.SimpleGrantedAuthority;
/*GrantedAuthority 인터페이스의 구현 클래스, 사용자에게 부여된 권한을 간단하게 나타내는 클래스 */

import org.springframework.security.core.userdetails.User;
/*User :  스프링 시큐리티에서 제공하는 사용자 정보를 담는 클래스 */

import org.springframework.security.core.userdetails.UserDetails;
/*UserDetails : 스프링 시큐리티에서 사용자 정보를 로드하는 인터페이스, 사용자 인증을 위해 필요한 사용자 정보를 제공 */

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
/*UsernameNotFoundException :  사용자 이름을 찾을 수 없을 때 발생하는 예외*/


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/*BCryptPasswordEncoder : BCrypt를 사용하여 비밀번호를 암호화  */

import org.springframework.stereotype.Service;
/*@service : 서비스 클래스를 나타내는 어노테이션, 스프링의 컴포넌트 스캔에 의해 스프링빈으로 이동 */

import org.springframework.transaction.annotation.Transactional;
/*Transactional :  메서드에 트랜잭션 기능을 부여. 이 어노테이션이 달린 메서드는 트랜잭션 내에서 실행된다*/
//트랜잭션 : 데이터베이스의 상태를 변화시키기 해서 수행하는 작업의 단위 (예를 들어 DB 쿼리문)

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {
    private MemberRepository memberRepository;

    // 회원가입
    @Transactional
    public Long signUp(MemberDto memberDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        // password를 암호화 한 뒤 dp에 저장

        return memberRepository.save(memberDto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 로그인을 하기 위해 가입된 user정보를 조회하는 메서드
        Optional<Member> memberWrapper = memberRepository.findByusername(username);
        Member member = memberWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if("admin".equals(username)){
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        // 아이디, 비밀번호, 권한리스트를 매개변수로 User를 만들어 반환해준다.
        return new User(member.getUsername(), member.getPassword(), authorities);
    }
}
/*
BCryptPasswordEncoder를 사용하여 비밀번호를 해시화하고 저장하는 방법

1)사용자가 회원가입할 때 입력한 비밀번호를 BCryptPasswordEncoder를 사용하여 해시화합니다.
2) 해시화된 비밀번호를 DB에 저장합니다.
3) 사용자가 로그인할 때 입력한 비밀번호를 같은 방법으로 해시화하여 DB에 저장된 해시화된 비밀번호와 비교합니다. */
