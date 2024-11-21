CREATE TABLE app_user (
  id BIGINT AUTO_INCREMENT NOT NULL,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NULL,
  email VARCHAR(255) NOT NULL,
  contact VARCHAR(255) NULL,
  user_role VARCHAR(255) NULL,
  is_active BOOLEAN DEFAULT TRUE,
  CONSTRAINT pk_app_user PRIMARY KEY (id)
);

ALTER TABLE app_user ADD CONSTRAINT uc_app_user_email UNIQUE (email);
ALTER TABLE app_user ADD CONSTRAINT uc_app_user_username UNIQUE (username);
