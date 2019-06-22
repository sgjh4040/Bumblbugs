Bumblbug
========

### 개요
* 클라우드 펀드 플렛폼으로 프로젝트 게시자와 후원자 간의 원할한 후원 시스템 제공하는 사이트 입니다. 
기본적으로 게시자가 프로젝트를 업로드하고, 후원자들은 자신이 필요하거나 후원하고 싶은 프로젝트를 후원하고 그에 따른 대가를 받습니다. 
게시자는 자금 부족 현상을 회복하고 자신이 계획한 일을 원할히 진행합니다.

### 제작과정
* 프로젝트 명: Bumblbug(클라우드 펀드 사이트)
* 수행기간 : 2019년 5월6일 ~ 2019년 6월 8일 
* 프로젝트 인원 : 5명
* 담당역할: 팀장,자료 취합,로그인,회원가입,마이페이지,프로젝트 검색기능

### 제작 중점
* 프로젝트 올리기와 후원 플랫폼 구성에 초점을 둠.

### 개발환경
* 언어
JAVa8 {JSP , MVC2}
* DB
MariaDB
* HTML/CSS/JavaScript/JQuery/Ajax

### 데이터 베이스 설계





### 프로젝트 소개
담당 view
![mypart1](https://user-images.githubusercontent.com/50870603/59963816-73316b00-9533-11e9-8207-3494902d2bf5.PNG)

#### 1.이메일 존재유무 확인
Ajax를 이용하여 email input창에 입력하게 되면 onkeyup 속성에 의해 실시간으로 DB와 연동하게 되고 이메일 존재 유무를 판단합니다.

#### 2.이메일 인증번호 확인
메일 입력후 인증번호를 클릭하게 되면 Math.random()으로 나오는 임의의 인증코드가 생성됩니다. 
인증번호는 JavaMail API, 와 Goolge의 SMTP 서버를 이용해서 입력한 메일로 인증번호가 발송됩니다.
인증번호가 불일치 할경우 javascript 를 활용해서 인증되지 않았다는 메시지 또는 일치할 경우 인증되었습니다. 라는 메시지가 나오게 됩니다.


![mypart2](https://user-images.githubusercontent.com/50870603/59963839-98be7480-9533-11e9-8d03-94e33c3a89e9.PNG)

#### 3.나의 후원 현황 
하나의 프로젝트에 관한 정보를 가지고 오기 위해서는 여러 개의 table에서 정보를 가져 와야합니다. Join을 이용하여 여러 table에서 정보를 bean으로 저장하여 보여줍니다. 
결제날짜와 오늘 날짜를 비교하여 펀딩 진행중 결재완료로 나누어 보여 줄수 있도록 구현 하였습니다.
나의 후원현황 중 특정 프로젝트를 검색시 검색한 프로젝트만 볼수 있도록 하는 검색 기능을 구현 하였습니다.

#### 4.나의 후원 프로젝트 선물 수정, 취소
프로젝트 선물에 대한 list를 불러올때 if문을 활용하여 선물이 모두 소진되었을 경우 disabled 속성을 활용하여 비활성을 시키도록 하였습니다.

