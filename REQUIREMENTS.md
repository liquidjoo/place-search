- 사용자(user)
    - id, password를 상태 값으로 가진다.
    - password는 암호화 한다.
    - 정보를 비교하여 로그인 여부를 판단 할 수 있다.
- 장소(place)
    - 검색한 장소들의 정보를 가지고 있다.
    - 한 장소에 대한 정보를 가지고 있다.
    - 정보를 보여 준다.
- 검색(search)
    - 검색을 할 수 있다.
    - 키워드를 상태 값으로 가진다.
    - 상태 값으로 외부 API 를 통해 데이터를 가져올 수 있다.

---

- 사용자(user)
    - 로그인 기능
        - userId, password(encryption)
        - password 모듈? 아니면 직접..?
        - 사용자 데이터는 어플리케이션 시작 시점 (ApplicationRunner 활용)
        - 세션 만들기 (인터셉터 활용)
            - 세션 유지
            - 세션 만료

- 지역(local)
    - 장소(place)
        - query를 래핑한 객체 (Keyword)
        - Keyword를 가지고 검색할 수 있다.
        - Request
        - Searchable 역할
            - Search Service에 요청
            - AddressResponse 반환
            
- 검색(search)
    - 검색 인터페이스, 다른 api로 언제든 교체 가능
    - 인터페이스를 통해 공통 api 생성, 내부로직 캡슐화
        - kakao (api별 context 분리)
            - address context
                - anti corruption pattern (infra 구현체)  
                
        - 각 api에 대한 response 맵핑
        
- 화면(view)
    - 별도의 Context로 분리
    - 클라이언트 구현에 Javascript 사용
