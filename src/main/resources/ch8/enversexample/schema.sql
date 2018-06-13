CREATE TABLE MESSAGE (
    ID INT NOT NULL AUTO_INCREMENT
  , TEXT VARCHAR(60) NOT NULL
  , DIRECTION VARCHAR(60) NOT NULL
  , VERSION INT NOT NULL DEFAULT 0
  , CREATED_BY VARCHAR(20)
  , CREATED_DATE TIMESTAMP
  , LAST_MODIFIED_BY VARCHAR(20)
  , LAST_MODIFIED_DATE TIMESTAMP
  , PRIMARY KEY (ID)
);

CREATE TABLE MESSAGE_H (
    ID INT NOT NULL
  , TEXT VARCHAR(60) NOT NULL
  , DIRECTION VARCHAR(60) NOT NULL
  , VERSION INT NOT NULL DEFAULT 0
  , CREATED_BY VARCHAR(20)
  , CREATED_DATE TIMESTAMP
  , LAST_MODIFIED_BY VARCHAR(20)
  , LAST_MODIFIED_DATE TIMESTAMP
  , AUDIT_REVISION INT NOT NULL
  , ACTION_TYPE INT
  , AUDIT_REVISION_END INT
  , AUDIT_REVISION_END_TS TIMESTAMP
  , PRIMARY KEY (ID, AUDIT_REVISION)
);

CREATE TABLE REVINFO (
    REVTSTMP BIGINT NOT NULL
  , REV INT NOT NULL AUTO_INCREMENT
  , PRIMARY KEY (REVTSTMP, REV)
);
