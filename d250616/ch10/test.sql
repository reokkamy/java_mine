-- 샘플 시퀀스 만들기. 
-- 세미 콜론으로 문장 구분을 안했을 경우, 해당 문장 직접 드래그해서, ctrl + enter 로 실행 해주세요.
create sequence member501_seq start with 1 increment by 1;
drop sequence member501_seq
drop table member501;
--샘플 확인용 테이블 만들기
create table member501 (
   id       number primary key,
   name     varchar2(100),
   password varchar2(100),
   email    varchar2(100),
   reg_date varchar2(50)
)
-- 샘플 데이터 하나 넣기. 
insert into member501 (
   id,
   name,
   password,
   email,
   reg_date
) values ( member501_seq.nextval,
           '이상용',
           '1234',
           'lsy@naver.com',
           '2025년6월16일12시9분' );

commit;

-- 테이블 조회 
select *
  from member501;

-- 한명 회원 조회 sql 
select *
  from member501
 where id = 2;

 -- 검색 조회. 
select *
  from member501
 where name like '%이상용%';

 -- 전체 조회, 아이디 기준으로 내림차순, 최신 등록일 순으로 
select *
  from member501
 order by id desc;