create table activities (
      id UUID PRIMARY KEY UNIQUE NOT NULL,
      title VARCHAR(255) NOT NULL,
      occurs_at TIMESTAMP NOT NULL,
      trip_id UUID,
      FOREIGN KEY (trip_id) REFERENCES trips(id) ON DELETE CASCADE
);