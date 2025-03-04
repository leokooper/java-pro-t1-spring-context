CREATE TABLE "products"
(
    "id"             BIGSERIAL PRIMARY KEY,
    "account_number" VARCHAR(255) NOT NULL UNIQUE,
    "balance"        NUMERIC      NOT NULL,
    "product_type"   VARCHAR      NOT NULL,
    "user_id"        BIGINT       NOT NULL,
    FOREIGN KEY ("user_id") REFERENCES "users" ("id")
);
