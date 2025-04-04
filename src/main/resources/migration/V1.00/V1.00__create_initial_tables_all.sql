CREATE TABLE ems_region (
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    status BOOLEAN NOT NULL
);

CREATE TABLE ems_device (
    id BIGINT NOT NULL,
    origin BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    installation_date DATE NOT NULL,
    installed_by VARCHAR(255) NOT NULL,
    last_checked VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    manufacturer VARCHAR(255) NOT NULL,
    serial_id VARCHAR(255) NOT NULL,
    site_id BIGINT NOT NULL,
    power_source VARCHAR(255) NOT NULL CHECK (power_source IN ('Solar', 'WAPDA', 'Generator')),
    status BOOLEAN NOT NULL
);

CREATE TABLE consumption (
    id BIGINT PRIMARY KEY NOT NULL,
    recorded_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    consumption_unit VARCHAR(255) NOT NULL CHECK (consumption_unit IN ('kWh', 'MWh')),
    device_id BIGINT NOT NULL,
    consumption DECIMAL(8,2) NOT NULL
);

CREATE TABLE ems_state (
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    users BIGINT NOT NULL,
    regions BIGINT NOT NULL
);

CREATE TABLE ems_site (
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    region_id BIGINT NOT NULL,
    status BOOLEAN NOT NULL
);

CREATE TABLE ems_customer (
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    company VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    site_id BIGINT NOT NULL,
    status BOOLEAN NOT NULL
);

CREATE TABLE ems_tariff (
    id BIGINT PRIMARY KEY NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    power_source VARCHAR(255) NOT NULL CHECK (power_source IN ('Solar', 'WAPDA', 'Generator')),
    unit_cost DECIMAL(8,2) NOT NULL,
    status BOOLEAN NOT NULL
);

-- Step 3: Add Foreign Keys
ALTER TABLE ems_customer ADD CONSTRAINT ems_customer_site_id_fk FOREIGN KEY (site_id) REFERENCES ems_site(id);
ALTER TABLE ems_device ADD CONSTRAINT ems_device_site_id_fk FOREIGN KEY (site_id) REFERENCES ems_site(id);
ALTER TABLE ems_state ADD CONSTRAINT ems_state_regions_fk FOREIGN KEY (regions) REFERENCES ems_region(id);
ALTER TABLE consumption ADD CONSTRAINT consumption_device_id_fk FOREIGN KEY (device_id) REFERENCES ems_device(origin);
ALTER TABLE ems_site ADD CONSTRAINT ems_site_region_fk FOREIGN KEY (region_id) REFERENCES ems_region(id);
