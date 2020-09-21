설치 및 실행 방법
--
source 다운로드  
- git clone -b master --single-branch https://github.com/liquidjoo/place-search.git

실행(프로젝트 디렉토리 안에서)  
 - ./gradlew bootRun




```$xslt
.
├── java  
│   └── com  
│       └── github  
│           └── liquidjoo  
│               └── placesearch  
│                   ├── PlaceSearchApplication.java  
│                   ├── PopularKeywordsRunner.java  
│                   ├── UserApplicationRunner.java  
│                   ├── config  
│                   ├── local  
│                   ├── search  
│                   ├── user  
│                   ├── utils  
│                   └── view  
└── resources  
    ├── application.properties  
    ├── static  
    │   ├── search  
    │   │   └── search.html  
    │   └── user  
    │       └── login.html  
    ├── templates  
    └── user.sql
```
