BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE plant (
    id serial PRIMARY KEY,
    api_id int NOT NULL,
    common_name varchar(250) NOT NULL UNIQUE,
    scientific_name varchar(250) NOT NULL UNIQUE,
    other_name varchar(250) NOT NULL UNIQUE,
    cycle varchar(100),
    watering varchar(100),
    sunlight varchar(100),
    image_url varchar(250),
    thumbnail_url varchar(250)
);

CREATE TABLE users_plant (
    plant_id int NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT fk_plant FOREIGN KEY (plant_id) REFERENCES plant (id),
    CONSTRAINT fk_users FOREIGN KEY (user_id) REFERENCES users(user_id)
);

COMMIT TRANSACTION;
