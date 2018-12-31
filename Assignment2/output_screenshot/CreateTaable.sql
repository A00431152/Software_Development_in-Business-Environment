CREATE TABLE transaction (
ID int(11) NOT NULL,
NameOnCard varchar(256) DEFAULT NULL,
CardNumber varchar(45) DEFAULT NULL,
UnitPrice decimal(10,0) DEFAULT NULL,
Quantity int(11) DEFAULT NULL,
 TotalPrice decimal(10,0) DEFAULT NULL,
   ExpDate varchar(16) DEFAULT NULL,
 CreatedOn datetime DEFAULT NULL,
 CreateBy varchar(45) DEFAULT NULL,
 CardType varchar(45),

  
    PRIMARY KEY(ID));
    
    


select * from transaction;