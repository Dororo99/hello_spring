package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

// 1. 자동으로 스프링 빈 등록하기

//@Repository
//public class MemoryMemberRepository implements MemberRepository{
//
//    private static Map<Long, Member> store = new HashMap<>();
//    private static long sequence = 0L;
//
//    @Override
//    public Member save(Member member) {
//        member.setId(++sequence);
//        store.put(member.getId(),member);
//        return member;
//    }
//
//    @Override
//    public Optional<Member> findById(Long id) {
//        return Optional.ofNullable(store.get(id)); // null이라도 감싸서 반환
//    }
//
//    @Override
//    public Optional<Member> findByName(String name) {
//        return store.values().stream()
//                .filter(member -> member.getName().equals(name))
//                .findAny(); // 하나라도 찾으면 바로 걔가 그냥 반환 되는 것이여!
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return new ArrayList<>(store.values());
//    }
//
//    public void clearStore(){
//        store.clear();
//    }
//}
//
//// 이 과정이 제대로 동작하는지 확인 하는 방법이 test case 작성이다!!!


// 2. 수동으로 스프링 빈 등록하기
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null이라도 감싸서 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // 하나라도 찾으면 바로 걔가 그냥 반환 되는 것이여!
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}

// 이 과정이 제대로 동작하는지 확인 하는 방법이 test case 작성이다!!!