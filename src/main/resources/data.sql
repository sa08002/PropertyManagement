INSERT INTO user_pass(user, password)
VALUES('user', '$2a$10$g/h4NtPsF2dhUOug2gxky.Op5FEsO7S1EHhAlVWF2GCfjhjV531US');


INSERT INTO property(property_id, property_name, address, tel1, email, created)
VALUES(20200001, 'アンチョビットゲームズ', '東京県アンチョビ3丁目', '99999999999', 'aaa@exampl.com', '2021-10-09 15:10:52');
INSERT INTO property(property_id, property_name, address, tel1, email, created)
VALUES(20200002, 'モズク農園', '東京県モズク農園2丁目', '99999999999', 'aaa@exampl.com', '2021-10-09 15:10:52');
INSERT INTO property(property_id, property_name, address, tel1, email, created)
VALUES(20210003, 'ガンガゼ美術館', '東京県ガンガゼ美術館4丁目', '99999999999', 'aaa@exampl.com', '2021-10-09 15:10:52');


INSERT INTO detail(property_id, detail1, detail2, detail3, detail4, detail5)
VALUES(1, 'detail1', 'detail2', 'detail3', 'detail4', 'detail5');
INSERT INTO detail(property_id, detail1, detail2, detail3, detail4, detail5)
VALUES(2, 'detail1', 'detail2', 'detail3', 'detail4', 'detail5');
INSERT INTO detail(property_id, detail1, detail2, detail3, detail4, detail5)
VALUES(3, 'detail1', 'detail2', 'detail3', 'detail4', 'detail5');