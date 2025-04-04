ALTER TABLE consumption
    ALTER COLUMN consumption TYPE TEXT;


UPDATE consumption
SET consumption =
    CASE
        WHEN consumption_unit = 'kWh' THEN CAST(consumption AS TEXT) || ' kWh'
        WHEN consumption_unit = 'MWh' THEN CAST(consumption AS TEXT) || ' MWh'
        ELSE CAST(consumption AS TEXT)
    END;
