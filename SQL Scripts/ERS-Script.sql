--Table for Reimbursement_Status
CREATE TABLE ers_reimbursement_status(
	reimb_status_id int PRIMARY KEY, 
	reimb_status varchar(10)
);



--Table for Reimbursement_type
CREATE TABLE ers_reimbursement_type(
	reimb_type_id int PRIMARY KEY,
	reimb_type varchar(10)
);


--Table for User_roles
CREATE TABLE ers_user_roles(  
	ers_user_role_id int PRIMARY KEY,
	user_role varchar(10)
);

--Table for Reimbursement
CREATE TABLE ers_reimbursement(
	reimb_id int PRIMARY KEY,
	reimb_amount int,
	reimb_submitted timestamp,
	reimb_resolved timestamp,
	reimb_description varchar(250),
	reimb_receipt blob,
	reimb_author int,
	reimb_resolver int,
	reimb_status_id int,
	reimb_type_id int,
	CONSTRAINT ers_users_fk_auth FOREIGN KEY (reimb_author) REFERENCES ers_users (ers_users_id),
	CONSTRAINT ers_users_fk_reslvr FOREIGN KEY (reimb_resolver) REFERENCES ers_users (ers_users_id),
	CONSTRAINT ers_reimbursement_status_fk FOREIGN KEY (reimb_status_id) REFERENCES ers_reimbursement_status(reimb_status_id),
	CONSTRAINT ers_reimbursement_type_fk FOREIGN KEY (reimb_type_id) REFERENCES ers_reimbursement_type(reimb_type_id)
);

--Table for users
CREATE TABLE ers_users(
	ers_user_id int PRIMARY KEY,
	ers_username varchar(50),
	ers_password varchar(50),
	user_first_name varchar(100),
	user_last_name varchar(100)
	user_email varchar(150),
	user_role_id int,
	CONSTRAINT user_roles_fk FOREIGN KEY (user_role_id) REFERENCES ers_user_roles (ers_user_role_id),
);


--Table drops so in case of mess up, I can easily drop and re create the tables
DROP TABLE ers_reimbursement_status;
DROP TABLE ers_reimbursement_type;
DROP TABLE ers_user_roles;
DROP TABLE ers_reimbursement
DROP TABLE ers_users