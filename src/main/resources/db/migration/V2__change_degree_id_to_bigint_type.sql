ALTER TABLE lectors
    DROP CONSTRAINT IF EXISTS lectors_degree_id_fkey;

ALTER TABLE lectors
    ALTER COLUMN degree_id TYPE BIGINT;

ALTER TABLE lectors
    ADD CONSTRAINT lectors_degree_id_fkey FOREIGN KEY (degree_id) REFERENCES degrees (id);