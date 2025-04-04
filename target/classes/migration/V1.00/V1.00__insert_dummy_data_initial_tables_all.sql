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
(1, 1, 'Device A', 'Description of Device A', '2024-01-01', 'Tech A', '2024-01-01', 'Model A', 'Manufacturer A', 'Serial A', 1, 'Solar', true),
(2, 2, 'Device B', 'Description of Device B', '2024-01-02', 'Tech B', '2024-01-02', 'Model B', 'Manufacturer B', 'Serial B', 2, 'WAPDA', true),
(3, 3, 'Device C', 'Description of Device C', '2024-01-03', 'Tech C', '2024-01-03', 'Model C', 'Manufacturer C', 'Serial C', 3, 'Generator', false);

-- Insert data into ems_customer
INSERT INTO ems_customer (id, name, last_name, company, address, site_id, status) VALUES
(1, 'Customer A', 'LastName A', 'Company A', '123 Customer St', 1, true),
(2, 'Customer B', 'LastName B', 'Company B', '456 Customer St', 2, true),
(3, 'Customer C', 'LastName C', 'Company C', '789 Customer St', 3, false);

-- Insert data into ems_state
INSERT INTO ems_state (id, name, users, regions) VALUES
(1, 'Active', 10, 1),
(2, 'Inactive', 5, 2),
(3, 'Pending', 3, 3);

-- Insert data into consumption
INSERT INTO consumption (id, recorded_time, consumption_unit, device_id, consumption) VALUES
(1, '2024-01-10 10:00:00', 'kWh', 1, 10),
(2, '2024-01-11 10:00:00', 'kWh', 2, 15),
(3, '2024-01-12 10:00:00', 'kWh', 3, 20);
