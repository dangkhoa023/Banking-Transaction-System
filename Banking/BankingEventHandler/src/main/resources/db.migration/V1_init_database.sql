CREATE TABLE IF NOT EXISTS account
(
    account_id LONG PRIMARY KEY,
    user_id LONG NOT NULL,
    balance DECIMAL(19, 4) NOT NULL,
)