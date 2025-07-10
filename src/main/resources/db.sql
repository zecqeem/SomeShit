CREATE TABLE IF NOT EXISTS users (
                                     id SERIAL PRIMARY KEY,
                                     username VARCHAR(50) UNIQUE NOT NULL,
                                     password VARCHAR(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS login_attempts (
                                              id SERIAL PRIMARY KEY,
                                              username VARCHAR(255) NOT NULL,
                                              attempts INT NOT NULL,
                                              blocked BOOLEAN NOT NULL,
                                              blocked_at TIMESTAMP NOT NULL
);
