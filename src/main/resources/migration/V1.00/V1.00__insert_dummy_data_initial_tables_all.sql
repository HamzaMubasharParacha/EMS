-- Insert data into ems_region
INSERT INTO ems_region (id, name, status) VALUES
(1, 'North Region', true),
(2, 'South Region', true),
(3, 'East Region', false);

-- Insert data into ems_site
INSERT INTO ems_site (id, name, address, city, region_id, status) VALUES
(1, 'Site A', '123 Main St', 'New York', 1, true),
(2, 'Site B', '456 Elm St', 'Los Angeles', 2, true),
(3, 'Site C', '789 Oak St', 'Chicago', 3, false);

-- Insert data into ems_device
INSERT INTO ems_device (id, origin, name, description, installation_date, installed_by, last_checked, model, manufacturer, serial_id, site_id, power_source, status) VALUES
(1, 1001, 'Device 1', 'Device description 1', '2025-01-01', 'Installer A', '2025-02-01', 'Model A', 'Manufacturer A', 'SERIAL123', 1, '', true),
(2, 1002, 'Device 2', 'Device description 2', '2025-02-01', 'Installer B', '2025-03-01', 'Model B', 'Manufacturer B', 'SERIAL124', 2, '', false),
(3, 1003, 'Device 3', 'Device description 3', '2025-03-01', 'Installer C', '2025-04-01', 'Model C', 'Manufacturer C', 'SERIAL125', 3, '', true);

-- Insert data into ems_customer
INSERT INTO ems_customer (id, name, last_name, company, address, site_id, status) VALUES
(1, 'John', 'Doe', 'Company A', '101 Business St', 1, true),
(2, 'Jane', 'Smith', 'Company B', '202 Corporate Rd', 2, true),
(3, 'Mike', 'Johnson', 'Company C', '303 Industrial Ave', 3, false);

-- Insert data into ems_state
INSERT INTO ems_state (id, name, users, regions) VALUES
(1, 'State A', 100, 1),
(2, 'State B', 200, 2),
(3, 'State C', 150, 3);

-- Insert data into ems_tariff
INSERT INTO ems_tariff (id, start_date, end_date, power_source, unit_cost, status) VALUES
(1, '2025-01-01', '2025-12-31', '', 0.10, true),
(2, '2025-02-01', '2025-12-31', '', 0.12, true),
(3, '2025-03-01', '2025-12-31', '', 0.15, false);

-- Insert data into consumption
INSERT INTO consumption (id, recorded_time, consumption_unit, device_id, consumption) VALUES
(1, '2025-01-01 10:00:00', '', 1001, 10.5),
(2, '2025-02-01 10:00:00', '', 1002, 15.0),
(3, '2025-03-01 10:00:00', '', 1003, 7.8);
