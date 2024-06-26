-- 2
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
SELECT @@SESSION.transaction_isolation;

-- 4
START TRANSACTION;

-- 6
SELECT * FROM hello.MEMBER WHERE id = 4; -- HELLO4

-- 8
UPDATE hello.MEMBER SET name = 'TX2TX2' WHERE id = 4; -- 동작 X

-- 10
SELECT * FROM hello.MEMBER WHERE id = 4;

-- 12
COMMIT;
