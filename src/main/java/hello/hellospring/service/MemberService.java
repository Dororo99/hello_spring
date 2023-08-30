package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 1. 자동으로 스프링 빈 등록하기
//@Service
//public class MemberService {
//    private final MemberRepository memberRepository;
//
//    @Autowired
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    } // @Service가 있으면 spring이 자동으로 등록해줌
//
//    //회원가입
//    public Long join(Member member){
//        // 같은 이름의 회원은 안된다! (중복 방지)
////        Optional<Member> result = memberRepository.findByName(member.getName());
////        result.ifPresent(m -> {
////            throw new IllegalStateException("Already Exist");
////        }); // 이미 존재하면 동작을 하도록 하는 애!
//
//        // 다른 방법 Optional을 안쓰고 정의 하는 방법
////        memberRepository.findByName(member.getName())
////                        .ifPresent(member1 ->
////                        {
////                            throw new IllegalStateException("Already Exist");
////                        });
////        // 이런 경우 메서드로 뽑아내는게 좋음!!
////        // ctrl + t
//
//        // 메서드로 뽑아내기!
//        validateDuplicateMember(member);
//        memberRepository.save(member);
//        return member.getId();
//
//    }
//
//    private void validateDuplicateMember(Member member) {
//        memberRepository.findByName(member.getName())
//                .ifPresent(member1 ->
//                {
//                    throw new IllegalStateException("Already Exist");
//                });
//    }
//
//    /*
//    전체 회원 조회!!
//     */
//    public List<Member> findMembers(){
//        return memberRepository.findAll();
//    }
//
//    public Optional<Member> findOne(Long memberId){
//        return  memberRepository.findById(memberId);
//    }
//}
//
//// 이제 이걸 test에서 해보자!!


// 2. 수동으로 스프링 빈 등록하기
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } // @Service가 있으면 spring이 자동으로 등록해줌

    //회원가입
    public Long join(Member member){
        // 같은 이름의 회원은 안된다! (중복 방지)
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("Already Exist");
//        }); // 이미 존재하면 동작을 하도록 하는 애!

        // 다른 방법 Optional을 안쓰고 정의 하는 방법
//        memberRepository.findByName(member.getName())
//                        .ifPresent(member1 ->
//                        {
//                            throw new IllegalStateException("Already Exist");
//                        });
//        // 이런 경우 메서드로 뽑아내는게 좋음!!
//        // ctrl + t

        // 메서드로 뽑아내기!
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(member1 ->
                {
                    throw new IllegalStateException("Already Exist");
                });
    }

    /*
    전체 회원 조회!!
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return  memberRepository.findById(memberId);
    }
}

// 이제 이걸 test에서 해보자!!
