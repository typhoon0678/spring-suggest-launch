INSERT INTO category (name) VALUES ('한식');
INSERT INTO category (name) VALUES ('중식');
INSERT INTO category (name) VALUES ('일식');
INSERT INTO category (name) VALUES ('양식');

INSERT INTO restaurant (name, lat, lon, category_id, created_at, updated_at) VALUES ('식당1', 37.572467, 126.990367, 1, NOW(), NOW());
INSERT INTO restaurant (name, lat, lon, category_id, created_at, updated_at) VALUES ('식당2', 37.573467, 126.992367, 1, NOW(), NOW());
INSERT INTO restaurant (name, lat, lon, category_id, created_at, updated_at) VALUES ('식당3', 37.574467, 126.994367, 2, NOW(), NOW());
INSERT INTO restaurant (name, lat, lon, category_id, created_at, updated_at) VALUES ('식당4', 37.571467, 126.988367, 3, NOW(), NOW());
