# PurchaseApi
==============
## 구매 데이터 관리 API
## REST API 요구사항 
1. 상품 관리 CRUD API : 상품 데이터에 대한 조회 / 생성 / 수정 / 삭제 기능
2. 구매 정보 저장 API : 사용자 번호 + 상품 아이디 + 주문 번호를 입력 받아 구매 정보를 저장
3. 구매 통계 출력 API : 구매 정보를 기반으로 사용자 / 상품별 구매 합계를 출력

## 응답규격
<pre><code> 
// 성공 : 별도의 공통 규격 없이 요구 조건의 데이터를 출력
ex) 상품 조회 
{ 
 "product" : { 
 "id" : 123 
 , "name" : "상품1" 
 } 
} 
// 실패 : error code 및 message를 정의하여 출력
{ 
 "code" : "xxx" 
 , "message" : "실패하였습니다." 
} 
</code></pre>

##data structure
<pre><code> 
@startuml
entity Product {
*id: int
--
*name: String
*price: int
}
entity Purchase {
*id: int
--
*user_id: int
*product_id: int
*price : int구매 데이터 관리 API 2
}
entity User {
*id: int
--
*name: String
}
Purchase }|-- Product
Purchase }|-- User
@enduml
</code></pre>

## 제약조건
Spring boot 를 바탕으로 java 또는 kotlin 을 이용하여 작성
Request / Response 대한 log를 한 줄로 출력
요구사항에 정의 된 응답 규격을 만족
in-memory 또는 docker 등을 이용하여 persistence-layer를 구성하고 해당 layer
에 데이터를 저장 및 조회
application 기동 시 제공 되는 csv 파일을 이용하여 구매 데이터 초기 로딩
기능에 대한 단위 / 통합 테스트 작성

## 추가요구사항(선택)
1. 필수 요구 사항 3 추가 기능 : 캐싱 및 페이징 처리, 캐시는 일정 주기 (주기는 임의로 지정 가능)로 캐시를 갱신하도록 스케쥴링
2. 필수 요구 사항 2 추가 기능 : Oauth 를 이용하여 회원가입 / 로그인을 구현하고, 사용자 번호 대신 oauth token을 사용. 요청은 oauth 표준인 Authorization Header 를 사용

## 개발 및 문제해결 현황
상품 관리 CURD API ( post, get, put, delete, list )
구매 정보 저장 API 
구매 통계 출력 API ( 사용자, 상품별 구매 합계 및 카운트 )
Spring boot를 바탕으로 java를 이용한 코드작성
필터와 인터셉터를 이용한 Request / response 에 대한 log를 한줄씩 출력
요구사항에 정의된 요청/응답 (Json) 규격
H2 DB를 이용한 in-memory DB 사용
application 기동시 정의된 schema, data를 initialization
기본 기능에 대한 Junit Test 코드 작성
Ehcache3를 이용한 캐싱처리 (600초 주기 만료, 상품관리는 갱신 발생시 cache갱신)

## 프로젝트 빌드 및 실행 방법
### 개발 환경 
- JAVA 1.8
- Eclipse Java EE IDE for Web Developers Photon (STS plugin)
- Dependencies : spring-boot, JPA, H2, lombok, ehcache ..

### 빌드 및 실행 방법
- Git Repositoires 에 https://github.com/kwonpc/PurchaseApi.git 등록 후 Import Projects 로 내려받기
- 내려받은 프로젝트를 Maven 빌드
- Run AS > Junit Test 진행하여 테스트 결과 확인
