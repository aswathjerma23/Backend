-- 1. User Table 

CREATE TABLE users (
  user_id UUID PRIMARY KEY,

  email VARCHAR(255),
  phone_number VARCHAR(15),

  password_hash VARCHAR(255) NOT NULL,

  full_name VARCHAR(255),
  avatar VARCHAR(255),

  address TEXT,
  suburb VARCHAR(50),
  state VARCHAR(30),
  post_code VARCHAR(7),

  is_active BOOLEAN NOT NULL DEFAULT TRUE,
  is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
  is_signup_confirmed BOOLEAN NOT NULL DEFAULT FALSE,
  is_phone_verified BOOLEAN NOT NULL DEFAULT FALSE,
  is_email_verified BOOLEAN NOT NULL DEFAULT FALSE,

  confirm_code_hash CHAR(64),

  registration_ids JSON,

  current_ip VARCHAR(45),
  customer_id VARCHAR(255),

  version BIGINT NOT NULL DEFAULT 0,

  push_notification BOOLEAN NOT NULL DEFAULT TRUE,
  sms_alert BOOLEAN NOT NULL DEFAULT TRUE,

  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Unique constraints
CREATE UNIQUE INDEX uk_users_email ON users(email);
CREATE UNIQUE INDEX uk_users_phone ON users(phone_number);

-- Normal indexes
CREATE INDEX idx_users_active_deleted ON users(is_active, is_deleted);
CREATE INDEX idx_users_created_at ON users(created_at);

--2. roles table
CREATE TABLE roles (
  role_id SMALLINT PRIMARY KEY,
  role_name VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO roles (role_id, role_name) VALUES
(1, 'PATIENT'),
(2, 'DOCTOR'),
(3, 'ADMIN');

--3 Mapping roles with user id Table 
CREATE TABLE user_roles (
  user_id UUID NOT NULL,
  role_id SMALLINT NOT NULL,

  PRIMARY KEY (user_id, role_id),

  CONSTRAINT fk_user_roles_user
    FOREIGN KEY (user_id)
    REFERENCES users(user_id)
    ON DELETE CASCADE,

  CONSTRAINT fk_user_roles_role
    FOREIGN KEY (role_id)
    REFERENCES roles(role_id)
    ON DELETE RESTRICT
);


