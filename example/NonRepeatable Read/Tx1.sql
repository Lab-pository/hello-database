-- 1
SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
SELECT @@SESSION.transaction_isolation;

-- 2
START TRANSACTION;

-- 5
SELECT COUNT(*) FROM hello.MEMBER;

-- 8
SELECT COUNT(*) FROM hello.MEMBER;

-- 9
COMMIT ;
