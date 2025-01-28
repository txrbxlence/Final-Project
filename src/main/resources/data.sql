DROP TABLE IF EXISTS task_category;
DROP TABLE IF EXISTS task;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS user;

CREATE TABLE user (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE task (
    task_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    due_date DATE,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE TABLE category (
    category_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE task_category (
    task_id BIGINT,
    category_id BIGINT,
    PRIMARY KEY (task_id, category_id),
    FOREIGN KEY (task_id) REFERENCES task(task_id),
    FOREIGN KEY (category_id) REFERENCES category(category_id)
);

INSERT INTO user (username, email) VALUES ('john_doe', 'john.doe@example.com');
INSERT INTO user (username, email) VALUES ('jane_smith', 'jane.smith@example.com');
INSERT INTO user (username, email) VALUES ('alex_brown', 'alex.brown@example.com');
INSERT INTO user (username, email) VALUES ('chris_green', 'chris.green@example.com');
INSERT INTO user (username, email) VALUES ('patricia_white', 'patricia.white@example.com');

INSERT INTO category (name) VALUES ('Work');
INSERT INTO category (name) VALUES ('School');
INSERT INTO category (name) VALUES ('Personal');
INSERT INTO category (name) VALUES ('Chores');
INSERT INTO category (name) VALUES ('Health');