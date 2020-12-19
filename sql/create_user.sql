CREATE USER 'SG'@'localhost' IDENTIFIED BY 'password' ; 

// Production
CREATE USER 'SG'@'localhost' IDENTIFIED BY 'P@$$w0rd' ; 


GRANT ALL privileges ON * . * TO 'SG'@'localhost';


SELECT user,host FROM mysql.user;

// NEXT 
// 1. CLICK + BUTTON 
// 2. Insert details