CREATE TABLE SystemUser (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
    );

CREATE TABLE Item( 
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(500),
    description TEXT,
    photoes VARCHAR(500),
    owner_id INT REFERENCES SystemUser(ID),
    point INT DEFAULT 0,
    type VARCHAR(50)
);

CREATE TABLE Trade (
    id SERIAL PRIMARY KEY NOT NULL ,
    send_item_id INT REFERENCES ITEM(ID),
    received_item_id INT REFERENCES ITEM(ID),
    traded BOOLEAN default false,
    seen BOOLEAN default false
);
