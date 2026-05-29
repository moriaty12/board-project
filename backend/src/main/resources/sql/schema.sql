-- schema.sql
CREATE TABLE board (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(200),
                       content TEXT,
                       writer VARCHAR(100),
                       created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE `board_post` (
                              `id` bigint(20) NOT NULL AUTO_INCREMENT,
                              `title` varchar(255) DEFAULT NULL,
                              `content` text DEFAULT NULL,
                              `created_at` timestamp NULL DEFAULT current_timestamp(),
                              `writer` varchar(100) DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS FUND_FEE_HIST;
DROP TABLE IF EXISTS FUND_PERF_HIST;
DROP TABLE IF EXISTS FUND_MST;
DROP TABLE IF EXISTS MNG_CO_MST;

CREATE TABLE MNG_CO_MST (
                            MNG_CO_CD        VARCHAR(20)  NOT NULL COMMENT '운용사코드',
                            MNG_CO_NM        VARCHAR(100) NOT NULL COMMENT '운용사명',
                            DATA_CRT_DTM     TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '데이터생성일시',
                            DATA_CRT_USR_ID  VARCHAR(50) COMMENT '데이터생성자ID',
                            DATA_CHG_USR_ID  VARCHAR(50) COMMENT '최종변경자ID',
                            LAST_SRC_NM      VARCHAR(100) COMMENT '최종데이터출처명',
                            CONSTRAINT PK_MNG_CO_MST PRIMARY KEY (MNG_CO_CD)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE FUND_MST (
                          FUND_CD          VARCHAR(20)  NOT NULL COMMENT '상품코드',
                          FUND_NM          VARCHAR(200) NOT NULL COMMENT '상품명',
                          FUND_TP_CD       VARCHAR(20) COMMENT '상품유형코드(ETF/FUND)',
                          MNG_CO_CD        VARCHAR(20) COMMENT '운용사코드',
                          RISK_GRD_CD      VARCHAR(10) COMMENT '위험등급',
                          LIST_DT          DATE COMMENT '상장일',
                          CUR_CD           VARCHAR(10) COMMENT '통화코드',
                          DATA_CRT_DTM     TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '데이터생성일시',
                          DATA_CRT_USR_ID  VARCHAR(50) COMMENT '데이터생성자ID',
                          DATA_CHG_USR_ID  VARCHAR(50) COMMENT '최종변경자ID',
                          LAST_SRC_NM      VARCHAR(100) COMMENT '최종데이터출처명',
                          CONSTRAINT PK_FUND_MST PRIMARY KEY (FUND_CD),
                          CONSTRAINT FK_FUND_MST_01
                              FOREIGN KEY (MNG_CO_CD)
                                  REFERENCES MNG_CO_MST(MNG_CO_CD)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE FUND_PERF_HIST (
                                FUND_CD          VARCHAR(20) NOT NULL COMMENT '상품코드',
                                BASE_DT          DATE        NOT NULL COMMENT '기준일',
                                CLS_PRC          DECIMAL(18,4) COMMENT '종가',
                                NAV              DECIMAL(18,4) COMMENT '순자산가치',
                                RTN_1M           DECIMAL(9,4) COMMENT '1개월수익률',
                                RTN_3M           DECIMAL(9,4) COMMENT '3개월수익률',
                                RTN_6M           DECIMAL(9,4) COMMENT '6개월수익률',
                                RTN_12M          DECIMAL(9,4) COMMENT '12개월수익률',
                                DATA_CRT_DTM     TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '데이터생성일시',
                                DATA_CRT_USR_ID  VARCHAR(50) COMMENT '데이터생성자ID',
                                DATA_CHG_USR_ID  VARCHAR(50) COMMENT '최종변경자ID',
                                LAST_SRC_NM      VARCHAR(100) COMMENT '최종데이터출처명',
                                CONSTRAINT PK_FUND_PERF_HIST
                                    PRIMARY KEY (FUND_CD, BASE_DT),
                                CONSTRAINT FK_FUND_PERF_HIST_01
                                    FOREIGN KEY (FUND_CD)
                                        REFERENCES FUND_MST(FUND_CD)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE FUND_FEE_HIST (
                               FUND_CD          VARCHAR(20) NOT NULL COMMENT '상품코드',
                               BASE_DT          DATE        NOT NULL COMMENT '적용기준일',
                               TOT_FEE_RT       DECIMAL(9,6) COMMENT '총보수율',
                               MNG_FEE_RT       DECIMAL(9,6) COMMENT '운용보수율',
                               SELL_FEE_RT      DECIMAL(9,6) COMMENT '판매보수율',
                               DATA_CRT_DTM     TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '데이터생성일시',
                               DATA_CRT_USR_ID  VARCHAR(50) COMMENT '데이터생성자ID',
                               DATA_CHG_USR_ID  VARCHAR(50) COMMENT '최종변경자ID',
                               LAST_SRC_NM      VARCHAR(100) COMMENT '최종데이터출처명',
                               CONSTRAINT PK_FUND_FEE_HIST
                                   PRIMARY KEY (FUND_CD, BASE_DT),
                               CONSTRAINT FK_FUND_FEE_HIST_01
                                   FOREIGN KEY (FUND_CD)
                                       REFERENCES FUND_MST(FUND_CD)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;