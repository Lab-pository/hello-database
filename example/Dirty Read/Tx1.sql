-- 1
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
SELECT @@SESSION.transaction_isolation;

-- 2
START TRANSACTION;

-- 3
SELECT * FROM hello.MEMBER WHERE id = 1; -- HELLO1

-- 4
UPDATE hello.MEMBER SET name = 'UPDATE1' WHERE id = 1;

-- 이 사이에 다른 트랜잭션에서 id가 1인 회원의 이름을 보면 어떻게 될까?

-- 9
ROLLBACK;
