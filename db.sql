CREATE TABLE app_user (
id INT NOT NULL AUTO_INCREMENT,
first_name NVARCHAR(255) NOT NULL,
last_name NVARCHAR(255) NOT NULL,
profile_name NVARCHAR(255) NOT NULL,
phone NVARCHAR(55) NOT NULL,
email NVARCHAR(255) NULL,
dob DATE NOT NULL,
age INT NULL,
height INT NOT NULL,
hearts INT NOT NULL,
acquired_hearts INT NULL,
gender NVARCHAR(20) NOT NULL,
marital_status NVARCHAR(20) NOT NULL,
location NVARCHAR(55) NOT NULL,
status NVARCHAR(20) NOT NULL,
PRIMARY KEY (id ASC)
);

CREATE TABLE lookup_type (
id INT NOT NULL,
category NVARCHAR(55) NOT NULL,
name NVARCHAR(255) NOT NULL,
PRIMARY KEY (id ASC)
);

CREATE TABLE lookup_value (
id INT NOT NULL,
lookup_type_id INT NOT NULL,
code NVARCHAR(20) NOT NULL,
name NVARCHAR(255) NOT NULL,
sequence INT NULL,
PRIMARY KEY (id ASC),
FOREIGN KEY (lookup_type_id) REFERENCES lookup_type (id)
);

CREATE TABLE user_preference (
id INT NOT NULL AUTO_INCREMENT,
user_id INT NOT NULL,
lookup_type_id INT NOT NULL,
lookup_value_id INT NOT NULL,
PRIMARY KEY (id ASC),
FOREIGN KEY (user_id) REFERENCES app_user (id),
FOREIGN KEY (lookup_type_id) REFERENCES lookup_type (id),
FOREIGN KEY (lookup_value_id) REFERENCES lookup_value (id)
);

CREATE TABLE user_pic (
id INT NOT NULL AUTO_INCREMENT,
user_id INT NOT NULL,
pic BLOB NOT NULL,
ref_id INT NULL,
is_primary TINYINT DEFAULT (0) NOT NULL,
PRIMARY KEY (id ASC),
FOREIGN KEY (user_id) REFERENCES app_user (id)
);

CREATE TABLE user_connection (
id INT NOT NULL AUTO_INCREMENT,
user_id INT NOT NULL,
linked_user_id INT NOT NULL,
status NVARCHAR(20) NOT NULL,
PRIMARY KEY (id ASC),
FOREIGN KEY (user_id) REFERENCES app_user (id),
FOREIGN KEY (linked_user_id) REFERENCES app_user (id)
);

CREATE TABLE user_invite (
id INT NOT NULL AUTO_INCREMENT,
user_id INT NOT NULL,
invite_user_id INT NOT NULL,
hearts INT NOT NULL,
invite_date DATE NULL,
invite_time NVARCHAR(20) NULL,
location NVARCHAR(55) NULL,
status NVARCHAR(20) NOT NULL,
PRIMARY KEY (id ASC),
FOREIGN KEY (user_id) REFERENCES app_user (id),
FOREIGN KEY (invite_user_id) REFERENCES app_user (id)
);

