-- 회원
DROP TABLE IF EXISTS pet_user RESTRICT;

-- 펫
DROP TABLE IF EXISTS pet_mypet RESTRICT;

-- 병원
DROP TABLE IF EXISTS pet_hp RESTRICT;

-- 나눔장터
DROP TABLE IF EXISTS pet_mark RESTRICT;

-- 우리동네
DROP TABLE IF EXISTS pet_mytown RESTRICT;

-- 뉴스
DROP TABLE IF EXISTS pet_st_news RESTRICT;

-- 나눔장터사진
DROP TABLE IF EXISTS pet_mark_phot RESTRICT;

-- 리뷰
DROP TABLE IF EXISTS pet_hp_review RESTRICT;

-- 병원사진
DROP TABLE IF EXISTS pet_hp_phot RESTRICT;

-- 스크랩
DROP TABLE IF EXISTS pet_st_scrap RESTRICT;

-- Q&A
DROP TABLE IF EXISTS pet_qna RESTRICT;

-- 나눔장터 댓글
DROP TABLE IF EXISTS pet_mark_comt RESTRICT;

-- 우리동네 댓글
DROP TABLE IF EXISTS pet_mytown_comt RESTRICT;

-- 병원 즐겨찾기
DROP TABLE IF EXISTS pet_hp_bookmark RESTRICT;

-- 내 찜
DROP TABLE IF EXISTS pet_like RESTRICT;

-- 진찰기록
DROP TABLE IF EXISTS pet_hprecord RESTRICT;

-- 시군구
DROP TABLE IF EXISTS pet_state RESTRICT;

-- 광역시도
DROP TABLE IF EXISTS pet_city RESTRICT;

-- 회원
CREATE TABLE pet_user (
  mno   INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
  name  VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  nick  VARCHAR(50)  NOT NULL COMMENT '닉네임', -- 닉네임
  id    VARCHAR(50)  NOT NULL COMMENT '아이디', -- 아이디
  pwd   VARCHAR(100) NOT NULL COMMENT '암호', -- 암호
  email VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  phone VARCHAR(30)  NOT NULL COMMENT '휴대전화', -- 휴대전화
  role  INTEGER      NOT NULL COMMENT '역할', -- 역할
  date  DATE         NULL     DEFAULT now() COMMENT '가입일' -- 가입일
)
COMMENT '회원';

-- 회원
ALTER TABLE pet_user
  ADD CONSTRAINT PK_pet_user -- 회원 기본키
    PRIMARY KEY (
      mno -- 회원번호
    );

-- 회원
ALTER TABLE pet_user
  ADD CONSTRAINT CK_pet_user -- 회원 체크 제약
    CHECK (role = 0 or role = 1
        );

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX UIX_pet_user
  ON pet_user ( -- 회원
    nick ASC -- 닉네임
  );

-- 회원 유니크 인덱스2
CREATE UNIQUE INDEX UIX_pet_user2
  ON pet_user ( -- 회원
    phone ASC -- 휴대전화
  );

-- 회원 유니크 인덱스3
CREATE UNIQUE INDEX UIX_pet_user3
  ON pet_user ( -- 회원
    email ASC -- 이메일
  );

-- 회원 유니크 인덱스4
CREATE UNIQUE INDEX UIX_pet_user4
  ON pet_user ( -- 회원
    id ASC -- 아이디
  );

ALTER TABLE pet_user
  MODIFY COLUMN mno INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 펫
CREATE TABLE pet_mypet (
  pno    INTEGER      NOT NULL COMMENT '마이펫번호', -- 마이펫번호
  mno    INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
  pname  VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  age    INTEGER      NOT NULL COMMENT '나이', -- 나이
  birth  DATE         NOT NULL COMMENT '생년월일', -- 생년월일
  gender INTEGER      NOT NULL COMMENT '성별', -- 성별
  photo  VARCHAR(255) NULL     COMMENT '사진' -- 사진
)
COMMENT '펫';

-- 펫
ALTER TABLE pet_mypet
  ADD CONSTRAINT PK_pet_mypet -- 펫 기본키
    PRIMARY KEY (
      pno -- 마이펫번호
    );

-- 펫
ALTER TABLE pet_mypet
  ADD CONSTRAINT CK_pet_mypet -- 펫 체크 제약
    CHECK (gender = 0 or gender = 1);

ALTER TABLE pet_mypet
  MODIFY COLUMN pno INTEGER NOT NULL AUTO_INCREMENT COMMENT '마이펫번호';

-- 병원
CREATE TABLE pet_hp (
  hno     INTEGER     NOT NULL COMMENT '병원번호', -- 병원번호
  gno     INTEGER     NOT NULL COMMENT '시군구번호', -- 시군구번호
  name    VARCHAR(50) NOT NULL COMMENT '이름', -- 이름
  tel     VARCHAR(30) NOT NULL COMMENT '전화번호', -- 전화번호
  parking INTEGER     NOT NULL COMMENT '주차여부', -- 주차여부
  vet     INTEGER     NOT NULL COMMENT '수의사', -- 수의사
  time    VARCHAR(15) NULL     COMMENT '진료시간', -- 진료시간
  grade   INTEGER     NULL     COMMENT '평점', -- 평점
  lat     FLOAT       NULL     COMMENT '위도', -- 위도
  lon     FLOAT       NULL     COMMENT '경도' -- 경도
)
COMMENT '병원';

-- 병원
ALTER TABLE pet_hp
  ADD CONSTRAINT PK_pet_hp -- 병원 기본키
    PRIMARY KEY (
      hno -- 병원번호
    );

-- 병원
ALTER TABLE pet_hp
  ADD CONSTRAINT CK_pet_hp -- 병원 체크 제약
    CHECK (parking=1 or parking=0);

ALTER TABLE pet_hp
  MODIFY COLUMN hno INTEGER NOT NULL AUTO_INCREMENT COMMENT '병원번호';

-- 나눔장터
CREATE TABLE pet_mark (
  sno      INTEGER     NOT NULL COMMENT '나눔장터번호', -- 나눔장터번호
  mno      INTEGER     NOT NULL COMMENT '회원번호', -- 회원번호
  category INTEGER     NOT NULL COMMENT '분류', -- 분류
  title    VARCHAR(50) NOT NULL COMMENT '제목', -- 제목
  cont     LONGTEXT    NOT NULL COMMENT '내용', -- 내용
  date     DATETIME    NOT NULL DEFAULT now() COMMENT '작성일' -- 작성일
)
COMMENT '나눔장터';

-- 나눔장터
ALTER TABLE pet_mark
  ADD CONSTRAINT PK_pet_mark -- 나눔장터 기본키
    PRIMARY KEY (
      sno -- 나눔장터번호
    );

ALTER TABLE pet_mark
  MODIFY COLUMN sno INTEGER NOT NULL AUTO_INCREMENT COMMENT '나눔장터번호';

-- 우리동네
CREATE TABLE pet_mytown (
  tno   INTEGER     NOT NULL COMMENT '우리동네번호', -- 우리동네번호
  mno   INTEGER     NOT NULL COMMENT '회원번호', -- 회원번호
  gno   INTEGER     NOT NULL COMMENT '시군구번호', -- 시군구번호
  title VARCHAR(50) NOT NULL COMMENT '제목', -- 제목
  cont  LONGTEXT    NOT NULL COMMENT '내용(사진)', -- 내용(사진)
  date  DATETIME    NOT NULL DEFAULT now() COMMENT '작성일', -- 작성일
  view  INTEGER     NULL     DEFAULT 0 COMMENT '조회수' -- 조회수
)
COMMENT '우리동네';

-- 우리동네
ALTER TABLE pet_mytown
  ADD CONSTRAINT PK_pet_mytown -- 우리동네 기본키
    PRIMARY KEY (
      tno -- 우리동네번호
    );

ALTER TABLE pet_mytown
  MODIFY COLUMN tno INTEGER NOT NULL AUTO_INCREMENT COMMENT '우리동네번호';

-- 뉴스
CREATE TABLE pet_st_news (
  nno   INTEGER      NOT NULL COMMENT '뉴스번호', -- 뉴스번호
  title VARCHAR(50)  NOT NULL COMMENT '제목', -- 제목
  url   VARCHAR(255) NOT NULL COMMENT 'URL', -- URL
  site  VARCHAR(50)  NOT NULL COMMENT '제공사이트', -- 제공사이트
  date  DATETIME     NOT NULL DEFAULT now() COMMENT '등록일' -- 등록일
)
COMMENT '뉴스';

-- 뉴스
ALTER TABLE pet_st_news
  ADD CONSTRAINT PK_pet_st_news -- 뉴스 기본키
    PRIMARY KEY (
      nno -- 뉴스번호
    );

ALTER TABLE pet_st_news
  MODIFY COLUMN nno INTEGER NOT NULL AUTO_INCREMENT COMMENT '뉴스번호';

-- 나눔장터사진
CREATE TABLE pet_mark_phot (
  spno  INTEGER      NOT NULL COMMENT '사진번호', -- 사진번호
  sno   INTEGER      NOT NULL COMMENT '나눔장터번호', -- 나눔장터번호
  photo VARCHAR(255) NOT NULL COMMENT '사진' -- 사진
)
COMMENT '나눔장터사진';

-- 나눔장터사진
ALTER TABLE pet_mark_phot
  ADD CONSTRAINT PK_pet_mark_phot -- 나눔장터사진 기본키
    PRIMARY KEY (
      spno -- 사진번호
    );

ALTER TABLE pet_mark_phot
  MODIFY COLUMN spno INTEGER NOT NULL AUTO_INCREMENT COMMENT '사진번호';

-- 리뷰
CREATE TABLE pet_hp_review (
  rno     INTEGER      NOT NULL COMMENT '리뷰번호', -- 리뷰번호
  hno     INTEGER      NOT NULL COMMENT '병원번호', -- 병원번호
  mno     INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
  service INTEGER      NOT NULL COMMENT '서비스', -- 서비스
  clean   INTEGER      NOT NULL COMMENT '청결도', -- 청결도
  cost    INTEGER      NOT NULL COMMENT '비용', -- 비용
  cont    LONGTEXT     NOT NULL COMMENT '한줄평가', -- 한줄평가
  date    DATETIME     NOT NULL DEFAULT now() COMMENT '작성일', -- 작성일
  rphoto  VARCHAR(255) NOT NULL COMMENT '영수증사진' -- 영수증사진
)
COMMENT '리뷰';

-- 리뷰
ALTER TABLE pet_hp_review
  ADD CONSTRAINT PK_pet_hp_review -- 리뷰 기본키
    PRIMARY KEY (
      rno -- 리뷰번호
    );

ALTER TABLE pet_hp_review
  MODIFY COLUMN rno INTEGER NOT NULL AUTO_INCREMENT COMMENT '리뷰번호';

-- 병원사진
CREATE TABLE pet_hp_phot (
  hpno  INTEGER      NOT NULL COMMENT '사진번호', -- 사진번호
  hno   INTEGER      NOT NULL COMMENT '병원번호', -- 병원번호
  photo VARCHAR(255) NOT NULL COMMENT '사진' -- 사진
)
COMMENT '병원사진';

-- 병원사진
ALTER TABLE pet_hp_phot
  ADD CONSTRAINT PK_pet_hp_phot -- 병원사진 기본키
    PRIMARY KEY (
      hpno -- 사진번호
    );

ALTER TABLE pet_hp_phot
  MODIFY COLUMN hpno INTEGER NOT NULL AUTO_INCREMENT COMMENT '사진번호';

-- 스크랩
CREATE TABLE pet_st_scrap (
  nno  INTEGER NOT NULL COMMENT '뉴스번호', -- 뉴스번호
  mno  INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
  date DATE    NOT NULL DEFAULT now() COMMENT '등록일' -- 등록일
)
COMMENT '스크랩';

-- 스크랩
ALTER TABLE pet_st_scrap
  ADD CONSTRAINT PK_pet_st_scrap -- 스크랩 기본키
    PRIMARY KEY (
      nno, -- 뉴스번호
      mno  -- 회원번호
    );

-- Q&A
CREATE TABLE pet_qna (
  qno   INTEGER     NOT NULL COMMENT 'Q&A번호', -- Q&A번호
  mno   INTEGER     NOT NULL COMMENT '회원번호', -- 회원번호
  title VARCHAR(50) NOT NULL COMMENT '제목', -- 제목
  cont  LONGTEXT    NOT NULL COMMENT '내용', -- 내용
  date  DATETIME    NOT NULL DEFAULT now() COMMENT '작성일', -- 작성일
  ans   LONGTEXT    NULL     COMMENT '답변', -- 답변
  date2 DATETIME    NULL     DEFAULT now() COMMENT '답변일' -- 답변일
)
COMMENT 'Q&A';

-- Q&A
ALTER TABLE pet_qna
  ADD CONSTRAINT PK_pet_qna -- Q&A 기본키
    PRIMARY KEY (
      qno -- Q&A번호
    );

ALTER TABLE pet_qna
  MODIFY COLUMN qno INTEGER NOT NULL AUTO_INCREMENT COMMENT 'Q&A번호';

-- 나눔장터 댓글
CREATE TABLE pet_mark_comt (
  srno INTEGER  NOT NULL COMMENT '번호', -- 번호
  sno  INTEGER  NOT NULL COMMENT '나눔장터번호', -- 나눔장터번호
  mno  INTEGER  NOT NULL COMMENT '회원번호', -- 회원번호
  cont LONGTEXT NOT NULL COMMENT '내용', -- 내용
  date DATETIME NOT NULL DEFAULT now() COMMENT '작성일' -- 작성일
)
COMMENT '나눔장터 댓글';

-- 나눔장터 댓글
ALTER TABLE pet_mark_comt
  ADD CONSTRAINT PK_pet_mark_comt -- 나눔장터 댓글 기본키
    PRIMARY KEY (
      srno -- 번호
    );

ALTER TABLE pet_mark_comt
  MODIFY COLUMN srno INTEGER NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 우리동네 댓글
CREATE TABLE pet_mytown_comt (
  trno INTEGER  NOT NULL COMMENT '번호', -- 번호
  tno  INTEGER  NULL     COMMENT '우리동네번호', -- 우리동네번호
  mno  INTEGER  NOT NULL COMMENT '회원번호', -- 회원번호
  cont LONGTEXT NOT NULL COMMENT '내용', -- 내용
  date DATETIME NOT NULL DEFAULT now() COMMENT '작성일' -- 작성일
)
COMMENT '우리동네 댓글';

-- 우리동네 댓글
ALTER TABLE pet_mytown_comt
  ADD CONSTRAINT PK_pet_mytown_comt -- 우리동네 댓글 기본키
    PRIMARY KEY (
      trno -- 번호
    );

ALTER TABLE pet_mytown_comt
  MODIFY COLUMN trno INTEGER NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 병원 즐겨찾기
CREATE TABLE pet_hp_bookmark (
  mno INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
  hno INTEGER NOT NULL COMMENT '병원번호' -- 병원번호
)
COMMENT '병원 즐겨찾기';

-- 병원 즐겨찾기
ALTER TABLE pet_hp_bookmark
  ADD CONSTRAINT PK_pet_hp_bookmark -- 병원 즐겨찾기 기본키
    PRIMARY KEY (
      mno, -- 회원번호
      hno  -- 병원번호
    );

-- 내 찜
CREATE TABLE pet_like (
  mno INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
  sno INTEGER NOT NULL COMMENT '나눔장터번호' -- 나눔장터번호
)
COMMENT '내 찜';

-- 내 찜
ALTER TABLE pet_like
  ADD CONSTRAINT PK_pet_like -- 내 찜 기본키
    PRIMARY KEY (
      mno, -- 회원번호
      sno  -- 나눔장터번호
    );

-- 진찰기록
CREATE TABLE pet_hprecord (
  exno    INTEGER  NOT NULL COMMENT '진찰기록번호', -- 진찰기록번호
  pno     INTEGER  NOT NULL COMMENT '마이펫번호', -- 마이펫번호
  hno     INTEGER  NOT NULL COMMENT '병원번호', -- 병원번호
  state   INTEGER  NOT NULL COMMENT '입원상태', -- 입원상태
  history LONGTEXT NOT NULL COMMENT '진찰내역' -- 진찰내역
)
COMMENT '진찰기록';

-- 진찰기록
ALTER TABLE pet_hprecord
  ADD CONSTRAINT PK_pet_hprecord -- 진찰기록 기본키
    PRIMARY KEY (
      exno -- 진찰기록번호
    );

-- 진찰기록
ALTER TABLE pet_hprecord
  ADD CONSTRAINT CK_pet_hprecord -- 진찰기록 체크 제약
    CHECK (state = 1 or state = 0);

ALTER TABLE pet_hprecord
  MODIFY COLUMN exno INTEGER NOT NULL AUTO_INCREMENT COMMENT '진찰기록번호';

-- 시군구
CREATE TABLE pet_state (
  gno   INTEGER     NOT NULL COMMENT '시군구번호', -- 시군구번호
  cno   INTEGER     NOT NULL COMMENT '광역시도번호', -- 광역시도번호
  gname VARCHAR(50) NULL     COMMENT '시군구명' -- 시군구명
)
COMMENT '시군구';

-- 시군구
ALTER TABLE pet_state
  ADD CONSTRAINT PK_pet_state -- 시군구 기본키
    PRIMARY KEY (
      gno -- 시군구번호
    );

-- 시군구 인덱스
CREATE INDEX IX_pet_state
  ON pet_state( -- 시군구
    gname ASC -- 시군구명
  );

ALTER TABLE pet_state
  MODIFY COLUMN gno INTEGER NOT NULL AUTO_INCREMENT COMMENT '시군구번호';

-- 광역시도
CREATE TABLE pet_city (
  cno   INTEGER     NOT NULL COMMENT '광역시도번호', -- 광역시도번호
  cname VARCHAR(50) NOT NULL COMMENT '시도명' -- 시도명
)
COMMENT '광역시도';

-- 광역시도
ALTER TABLE pet_city
  ADD CONSTRAINT PK_pet_city -- 광역시도 기본키
    PRIMARY KEY (
      cno -- 광역시도번호
    );

-- 광역시도 인덱스
CREATE INDEX IX_pet_city
  ON pet_city( -- 광역시도
    cname ASC -- 시도명
  );

ALTER TABLE pet_city
  MODIFY COLUMN cno INTEGER NOT NULL AUTO_INCREMENT COMMENT '광역시도번호';

-- 펫
ALTER TABLE pet_mypet
  ADD CONSTRAINT FK_pet_user_TO_pet_mypet -- 회원 -> 펫
    FOREIGN KEY (
      mno -- 회원번호
    )
    REFERENCES pet_user ( -- 회원
      mno -- 회원번호
    );

-- 병원
ALTER TABLE pet_hp
  ADD CONSTRAINT FK_pet_state_TO_pet_hp -- 시군구 -> 병원
    FOREIGN KEY (
      gno -- 시군구번호
    )
    REFERENCES pet_state ( -- 시군구
      gno -- 시군구번호
    );

-- 나눔장터
ALTER TABLE pet_mark
  ADD CONSTRAINT FK_pet_user_TO_pet_mark -- 회원 -> 나눔장터
    FOREIGN KEY (
      mno -- 회원번호
    )
    REFERENCES pet_user ( -- 회원
      mno -- 회원번호
    );

-- 우리동네
ALTER TABLE pet_mytown
  ADD CONSTRAINT FK_pet_user_TO_pet_mytown -- 회원 -> 우리동네
    FOREIGN KEY (
      mno -- 회원번호
    )
    REFERENCES pet_user ( -- 회원
      mno -- 회원번호
    );

-- 우리동네
ALTER TABLE pet_mytown
  ADD CONSTRAINT FK_pet_state_TO_pet_mytown -- 시군구 -> 우리동네
    FOREIGN KEY (
      gno -- 시군구번호
    )
    REFERENCES pet_state ( -- 시군구
      gno -- 시군구번호
    );

-- 나눔장터사진
ALTER TABLE pet_mark_phot
  ADD CONSTRAINT FK_pet_mark_TO_pet_mark_phot -- 나눔장터 -> 나눔장터사진
    FOREIGN KEY (
      sno -- 나눔장터번호
    )
    REFERENCES pet_mark ( -- 나눔장터
      sno -- 나눔장터번호
    );

-- 리뷰
ALTER TABLE pet_hp_review
  ADD CONSTRAINT FK_pet_hp_TO_pet_hp_review -- 병원 -> 리뷰
    FOREIGN KEY (
      hno -- 병원번호
    )
    REFERENCES pet_hp ( -- 병원
      hno -- 병원번호
    );

-- 리뷰
ALTER TABLE pet_hp_review
  ADD CONSTRAINT FK_pet_user_TO_pet_hp_review -- 회원 -> 리뷰
    FOREIGN KEY (
      mno -- 회원번호
    )
    REFERENCES pet_user ( -- 회원
      mno -- 회원번호
    );

-- 병원사진
ALTER TABLE pet_hp_phot
  ADD CONSTRAINT FK_pet_hp_TO_pet_hp_phot -- 병원 -> 병원사진
    FOREIGN KEY (
      hno -- 병원번호
    )
    REFERENCES pet_hp ( -- 병원
      hno -- 병원번호
    );

-- 스크랩
ALTER TABLE pet_st_scrap
  ADD CONSTRAINT FK_pet_st_news_TO_pet_st_scrap -- 뉴스 -> 스크랩
    FOREIGN KEY (
      nno -- 뉴스번호
    )
    REFERENCES pet_st_news ( -- 뉴스
      nno -- 뉴스번호
    );

-- 스크랩
ALTER TABLE pet_st_scrap
  ADD CONSTRAINT FK_pet_user_TO_pet_st_scrap -- 회원 -> 스크랩
    FOREIGN KEY (
      mno -- 회원번호
    )
    REFERENCES pet_user ( -- 회원
      mno -- 회원번호
    );

-- Q&A
ALTER TABLE pet_qna
  ADD CONSTRAINT FK_pet_user_TO_pet_qna -- 회원 -> Q&A
    FOREIGN KEY (
      mno -- 회원번호
    )
    REFERENCES pet_user ( -- 회원
      mno -- 회원번호
    );

-- 나눔장터 댓글
ALTER TABLE pet_mark_comt
  ADD CONSTRAINT FK_pet_mark_TO_pet_mark_comt -- 나눔장터 -> 나눔장터 댓글
    FOREIGN KEY (
      sno -- 나눔장터번호
    )
    REFERENCES pet_mark ( -- 나눔장터
      sno -- 나눔장터번호
    );

-- 나눔장터 댓글
ALTER TABLE pet_mark_comt
  ADD CONSTRAINT FK_pet_user_TO_pet_mark_comt -- 회원 -> 나눔장터 댓글
    FOREIGN KEY (
      mno -- 회원번호
    )
    REFERENCES pet_user ( -- 회원
      mno -- 회원번호
    );

-- 우리동네 댓글
ALTER TABLE pet_mytown_comt
  ADD CONSTRAINT FK_pet_user_TO_pet_mytown_comt -- 회원 -> 우리동네 댓글
    FOREIGN KEY (
      mno -- 회원번호
    )
    REFERENCES pet_user ( -- 회원
      mno -- 회원번호
    );

-- 우리동네 댓글
ALTER TABLE pet_mytown_comt
  ADD CONSTRAINT FK_pet_mytown_TO_pet_mytown_comt -- 우리동네 -> 우리동네 댓글
    FOREIGN KEY (
      tno -- 우리동네번호
    )
    REFERENCES pet_mytown ( -- 우리동네
      tno -- 우리동네번호
    );

-- 병원 즐겨찾기
ALTER TABLE pet_hp_bookmark
  ADD CONSTRAINT FK_pet_user_TO_pet_hp_bookmark -- 회원 -> 병원 즐겨찾기
    FOREIGN KEY (
      mno -- 회원번호
    )
    REFERENCES pet_user ( -- 회원
      mno -- 회원번호
    );

-- 병원 즐겨찾기
ALTER TABLE pet_hp_bookmark
  ADD CONSTRAINT FK_pet_hp_TO_pet_hp_bookmark -- 병원 -> 병원 즐겨찾기
    FOREIGN KEY (
      hno -- 병원번호
    )
    REFERENCES pet_hp ( -- 병원
      hno -- 병원번호
    );

-- 내 찜
ALTER TABLE pet_like
  ADD CONSTRAINT FK_pet_user_TO_pet_like -- 회원 -> 내 찜
    FOREIGN KEY (
      mno -- 회원번호
    )
    REFERENCES pet_user ( -- 회원
      mno -- 회원번호
    );

-- 내 찜
ALTER TABLE pet_like
  ADD CONSTRAINT FK_pet_mark_TO_pet_like -- 나눔장터 -> 내 찜
    FOREIGN KEY (
      sno -- 나눔장터번호
    )
    REFERENCES pet_mark ( -- 나눔장터
      sno -- 나눔장터번호
    );

-- 진찰기록
ALTER TABLE pet_hprecord
  ADD CONSTRAINT FK_pet_mypet_TO_pet_hprecord -- 펫 -> 진찰기록
    FOREIGN KEY (
      pno -- 마이펫번호
    )
    REFERENCES pet_mypet ( -- 펫
      pno -- 마이펫번호
    );

-- 진찰기록
ALTER TABLE pet_hprecord
  ADD CONSTRAINT FK_pet_hp_TO_pet_hprecord -- 병원 -> 진찰기록
    FOREIGN KEY (
      hno -- 병원번호
    )
    REFERENCES pet_hp ( -- 병원
      hno -- 병원번호
    );

-- 시군구
ALTER TABLE pet_state
  ADD CONSTRAINT FK_pet_city_TO_pet_state -- 광역시도 -> 시군구
    FOREIGN KEY (
      cno -- 광역시도번호
    )
    REFERENCES pet_city ( -- 광역시도
      cno -- 광역시도번호
    );