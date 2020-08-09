package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// 보통 SQL Mapper(MyBatis같은)에서 Dao라고 불리는 DB Layer 접근자
// JPA에서는 Repository 라고 부르며 인터페이스로 생성
// 단순히 인터페이스 생성 후, JpaRepository<Entity 클래스, PK타입>를 상속하면 기본적인 CRUD메소드가 자동으로 생성
// @Repository 추가할 필요 없음
// Entity클래스와 기본 Entity Repository는 가은 위치에 있어야 함
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
