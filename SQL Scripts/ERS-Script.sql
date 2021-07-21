--Table for Reimbursement_Status
CREATE TABLE ers_reimbursement_status(
	reimb_status_id serial PRIMARY KEY, 
	reimb_status varchar(10) NOT NULL UNIQUE
);



--Table for Reimbursement_type
CREATE TABLE ers_reimbursement_type(
	reimb_type_id serial PRIMARY KEY,
	reimb_type varchar(10) NOT NULL UNIQUE 
);


--Table for User_roles
CREATE TABLE ers_user_roles(  
	ers_user_role_id serial PRIMARY KEY,
	user_role varchar(10) NOT NULL UNIQUE
);

--Table for Reimbursement
CREATE TABLE ers_reimbursement(
	reimb_id SERIAL PRIMARY KEY,
	reimb_amount INT NOT NULL,
	reimb_submitted TEXT NOT NULL,
	reimb_resolved TEXT,
	reimb_description VARCHAR(250),
	reimb_author INT REFERENCES ers_users(ers_users_id) NOT NULL,
	reimb_resolver INT REFERENCES ers_users(ers_users_id) NOT NULL,
	reimb_status_id INT REFERENCES ers_reimbursement_status(reimb_status_id) NOT NULL,
	reimb_type_id INT REFERENCES ers_reimbursement_type(reimb_type_id) NOT NULL
	);

--Table for users
CREATE TABLE ers_users(
	ers_users_id SERIAL PRIMARY KEY,
	ers_username VARCHAR(50) NOT NULL UNIQUE,
	ers_password VARCHAR(50) NOT NULL,
	user_first_name VARCHAR(100) NOT NULL,
	user_last_name VARCHAR(100) NOT NULL,
	user_email VARCHAR(150) NOT NULL,
	user_role_id INT REFERENCES ers_user_roles(ers_user_role_id)
);

INSERT INTO ers_reimbursement_status(reimb_status) VALUES ('Pending');
INSERT INTO ers_reimbursement_status(reimb_status) VALUES ('Denied');
INSERT INTO ers_reimbursement_status(reimb_status) VALUES ('Approved');

SELECT * FROM ers_reimbursement_status;

-----------------------------------------------------------------------------------------------------------------
INSERT INTO ers_reimbursement_type(reimb_type) VALUES ('Lodging');
INSERT INTO ers_reimbursement_type(reimb_type) VALUES ('Travel');
INSERT INTO ers_reimbursement_type(reimb_type) VALUES ('Food');
INSERT INTO ers_reimbursement_type(reimb_type) VALUES ('Other');

SELECT * FROM ers_reimbursement_type;

-----------------------------------------------------------------------------------------------------------------

INSERT INTO ers_user_roles(user_role) VALUES ('Manager');
INSERT INTO ers_user_roles(user_role) VALUES ('Employee');

SELECT * FROM ers_user_roles;

-----------------------------------------------------------------------------------------------------------------

INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES ('nlefevre', 'password', 'Nick', 'LeFevre', 'nlefevre@widener.edu', 1);
INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES ('johncena', 'hello12', 'John', 'Cena', 'johncena@aol.com', 1);
INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES ('master1', 'iownyou', 'Over', 'Lord', 'overlord@castle.net', 2);
INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES ('master2', 'youaremine', 'Master', 'Master', 'master@gmail.com', 2);

SELECT * FROM ers_users;

-----------------------------------------------------------------------------------------------------------------

INSERT INTO ers_reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (160, '2021-07-20', '2021-07-20', 'gas', 4, 4, 3, 2);
INSERT INTO ers_reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (1, '2021-07-10', '2021-07-10', 'test', 4, 4, 3, 4);

SELECT * FROM ers_reimbursement;


--Table drops so in case of mess up, I can easily drop and re create the tables
DROP TABLE ers_reimbursement_status;
DROP TABLE ers_reimbursement_type;
DROP TABLE ers_user_roles;
DROP TABLE ers_reimbursement;
DROP TABLE ers_users;