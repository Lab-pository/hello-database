-- 2
SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;
SELECT @@SESSION.transaction_isolation;

-- 4
START TRANSACTION;

-- 6
SELECT * FROM hello.MEMBER WHERE id = 4; -- HELLO4

-- 10
UPDATE hello.MEMBER SET name = 'TX2TX2' WHERE id = 4;

-- 11
SELECT * FROM hello.MEMBER WHERE id = 4; -- TX2TX2

-- 12
COMMIT;
