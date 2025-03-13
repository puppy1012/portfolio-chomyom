package com.chomyom.portfolio.domain.entity

import jakarta.persistence.*
import jakarta.servlet.http.HttpServletRequest

@Entity // 이 클래스가 JPA 엔티티임을 지정 (DB 테이블과 매핑됨)
class HttpInterface(httpServletRequest: HttpServletRequest) : BaseEntity() {

    @Id // 해당 필드를 엔티티의 기본 키(primary key)로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB auto-increment 전략 사용하여 기본 키 자동 생성
    @Column(name = "http_interface_id") // DB 컬럼 이름을 'http_interface_id'로 지정
    var id: Long? = null
    // 요청에서 받은 쿠키들을 "이름:값" 형식의 문자열로 변환하여 저장
    var cookies: String? = httpServletRequest.cookies
        ?.map { "${it.name}:${it.value}" } //null이 아니면 실행, map으로 지정한 name과 value를 반환
        ?.toString()
    // 요청 헤더의 referer 값을 저장
    var referer: String? = httpServletRequest.getHeader("referer")
    // 서버의 로컬 IP 주소를 저장
    var localAddr: String? = httpServletRequest.localAddr
    // 클라이언트의 IP 주소를 저장
    var remoteAddr: String? = httpServletRequest.remoteAddr
    // 클라이언트의 호스트 이름을 저장
    var remoteHost: String? = httpServletRequest.remoteHost
    // 요청된 URI를 저장
    var requestUri: String? = httpServletRequest.requestURI
    // 요청 헤더의 User-Agent 값을 저장 (클라이언트 브라우저 정보 등)
    var userAgent: String? = httpServletRequest.getHeader("user-agent")
}
