CREATE TABLE property
(
	id INT NOT NULL AUTO_INCREMENT,
	property_id INT(8) NOT NULL,
	property_name VARCHAR(100) NOT NULL,
	address VARCHAR(100) NOT NULL,
	tel1 VARCHAR(16) NOT NULL,
	email VARCHAR(100),
	created DATETIME NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE detail
(
	property_id int NOT NULL AUTO_INCREMENT,
	detail1 VARCHAR(500),
	detail2 VARCHAR(500),
	detail3 VARCHAR(500),
	detail4 VARCHAR(500),
	detail5 VARCHAR(500),
	CONSTRAINT detail_id 
		FOREIGN KEY (property_id)
		REFERENCES property (id) on delete cascade
);
