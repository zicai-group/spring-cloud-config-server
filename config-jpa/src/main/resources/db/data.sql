
DELETE FROM app;

INSERT INTO app (app_name, app_env, create_time) VALUES ('config-sample', 'test', now());



DELETE FROM app_props;

INSERT INTO app_props (prop_key, prop_value, app_id, create_time) VALUES
('k_a', 'k_a_1', 1, now()),
('k_b', 'k_b_1', 1, now());



DELETE FROM published;

INSERT INTO published (app_id, props_data, publish_time, create_time) VALUES (1, '{"k_a":"k_a_1","k_b":"k_b_1"}', now(), now());
