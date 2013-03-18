/* Mesa de registro */
SET NAMES 'latin1';

ALTER TABLE preregister_information ADD date_register TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE information_account MODIFY password VARCHAR(50);

insert into information_account(email, password, token, reference_key, enabled) 
values ('captura3@utvm.edu.mx', 'captura', '', '', 1);
insert into information_account(email, password, token, reference_key, enabled) 
values ('captura4@utvm.edu.mx', 'captura', '', '', 1);
insert into information_account(email, password, token, reference_key, enabled) 
values ('captura5@utvm.edu.mx', 'captura', '', '', 1);
insert into information_account(email, password, token, reference_key, enabled) 
values ('captura6@utvm.edu.mx', 'captura', '', '', 1);
insert into information_account(email, password, token, reference_key, enabled) 
values ('captura7@utvm.edu.mx', 'captura', '', '', 1);
insert into information_account(email, password, token, reference_key, enabled) 
values ('captura8@utvm.edu.mx', 'captura', '', '', 1);
insert into information_account(email, password, token, reference_key, enabled) 
values ('captura9@utvm.edu.mx', 'captura', '', '', 1);
insert into information_account(email, password, token, reference_key, enabled) 
values ('captura10@utvm.edu.mx', 'captura', '', '', 1);
insert into information_account(email, password, token, reference_key, enabled) 
values ('captura11@utvm.edu.mx', 'captura', '', '', 1);
insert into information_account(email, password, token, reference_key, enabled) 
values ('captura12@utvm.edu.mx', 'captura', '', '', 1);
insert into information_account(email, password, token, reference_key, enabled) 
values ('captura13@utvm.edu.mx', 'captura', '', '', 1);
insert into information_account(email, password, token, reference_key, enabled) 
values ('captura14@utvm.edu.mx', 'captura', '', '', 1);
insert into information_account(email, password, token, reference_key, enabled) 
values ('captura15@utvm.edu.mx', 'captura', '', '', 1);


insert into user_roles (user_id, authority) values ('captura3@utvm.edu.mx', 'ROLE_CAPTURA');
insert into user_roles (user_id, authority) values ('captura4@utvm.edu.mx', 'ROLE_CAPTURA');
insert into user_roles (user_id, authority) values ('captura5@utvm.edu.mx', 'ROLE_CAPTURA');
insert into user_roles (user_id, authority) values ('captura6@utvm.edu.mx', 'ROLE_CAPTURA');
insert into user_roles (user_id, authority) values ('captura7@utvm.edu.mx', 'ROLE_CAPTURA');
insert into user_roles (user_id, authority) values ('captura8@utvm.edu.mx', 'ROLE_CAPTURA');
insert into user_roles (user_id, authority) values ('captura9@utvm.edu.mx', 'ROLE_CAPTURA');
insert into user_roles (user_id, authority) values ('captura10@utvm.edu.mx', 'ROLE_CAPTURA');
insert into user_roles (user_id, authority) values ('captura11@utvm.edu.mx', 'ROLE_CAPTURA');
insert into user_roles (user_id, authority) values ('captura12@utvm.edu.mx', 'ROLE_CAPTURA');
insert into user_roles (user_id, authority) values ('captura13@utvm.edu.mx', 'ROLE_CAPTURA');
insert into user_roles (user_id, authority) values ('captura14@utvm.edu.mx', 'ROLE_CAPTURA');
insert into user_roles (user_id, authority) values ('captura15@utvm.edu.mx', 'ROLE_CAPTURA');