CREATE TABLE requests (
    id IDENTITY NOT NULL PRIMARY KEY,
    amount DECIMAL NOT NULL,
    terms INTEGER NOT NULL,
    rate DECIMAL NOT NULL
);
CREATE TABLE responses (
    id IDENTITY NOT NULL PRIMARY KEY,
    requestid INTEGER NOT NULL,
    payment_number INTEGER NOT NULL,
    amount DECIMAL NOT NULL ,
    payment_date DATE NOT NULL ,
    FOREIGN KEY (requestid) REFERENCES requests(id)
);