-- 1
SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
SELECT @@SESSION.transaction_isolation;

-- 2
START TRANSACTION;

-- 5
SELECT balance FROM hello.ACCOUNTS WHERE id = 1;

-- 8
SELECT balance FROM hello.ACCOUNTS WHERE id = 2;

-- 10
COMMIT ;
