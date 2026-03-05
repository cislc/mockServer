-- 设置客户端字符集
SET NAMES utf8mb4 COLLATE utf8mb4_unicode_ci;
SET CHARACTER SET utf8mb4;

-- 创建数据库
CREATE DATABASE IF NOT EXISTS medical_mock DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE medical_mock;

-- 创建科室表
CREATE TABLE IF NOT EXISTS department (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    department_code VARCHAR(50) NOT NULL UNIQUE,
    department_name VARCHAR(100) NOT NULL,
    department_des VARCHAR(1000),
    department_image VARCHAR(500),
    INDEX idx_dept_code (department_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 创建医生表
CREATE TABLE IF NOT EXISTS doctor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    doctor_code VARCHAR(50) NOT NULL UNIQUE,
    doctor_name VARCHAR(100) NOT NULL,
    department_code VARCHAR(50) NOT NULL,
    title VARCHAR(50),
    specialty VARCHAR(200),
    doctor_des VARCHAR(1000),
    doctor_image VARCHAR(500),
    INDEX idx_doctor_code (doctor_code),
    INDEX idx_dept_code (department_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 创建医生排班表
CREATE TABLE IF NOT EXISTS doctor_schedule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    m_code VARCHAR(50),
    service_date VARCHAR(20),
    week_day VARCHAR(10),
    session_code VARCHAR(20),
    session_name VARCHAR(50),
    start_time VARCHAR(20),
    end_time VARCHAR(20),
    department_code VARCHAR(50),
    department_name VARCHAR(100),
    clinic_room_code VARCHAR(50),
    clinic_room_name VARCHAR(100),
    doctor_code VARCHAR(50),
    doctor_name VARCHAR(100),
    doctor_title_code VARCHAR(20),
    doctor_title VARCHAR(50),
    doctor_spec VARCHAR(500),
    doctor_sess_type_code VARCHAR(20),
    doctor_sess_type VARCHAR(50),
    service_code VARCHAR(50),
    service_name VARCHAR(100),
    fee VARCHAR(20),
    reg_fee VARCHAR(20),
    checkup_fee VARCHAR(20),
    service_fee VARCHAR(20),
    other_fee VARCHAR(20),
    available_number_str VARCHAR(100),
    admit_address_string VARCHAR(200),
    admit_time_range VARCHAR(50),
    note VARCHAR(500),
    time_range_flag VARCHAR(10),
    schedule_status VARCHAR(10),
    available_total_num VARCHAR(10),
    available_left_num VARCHAR(10),
    INDEX idx_service_date (service_date),
    INDEX idx_doctor_code (doctor_code),
    INDEX idx_dept_code (department_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 创建患者表
CREATE TABLE IF NOT EXISTS patient (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    patient_id VARCHAR(50) UNIQUE,
    patient_name VARCHAR(100),
    sex_code VARCHAR(10),
    sex VARCHAR(10),
    dob VARCHAR(20),
    document_id VARCHAR(50),
    address VARCHAR(200),
    id_type_code VARCHAR(10),
    id_type VARCHAR(50),
    id_no VARCHAR(50),
    yb_flag VARCHAR(10),
    pat_type VARCHAR(50),
    pat_type_code VARCHAR(10),
    mobile VARCHAR(20),
    insure_card_no VARCHAR(50),
    acc_info VARCHAR(100),
    acc_info_balance VARCHAR(20),
    acc_info_no VARCHAR(50),
    patient_card VARCHAR(50),
    INDEX idx_patient_id (patient_id),
    INDEX idx_id_no (id_no),
    INDEX idx_mobile (mobile),
    INDEX idx_patient_card (patient_card)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 创建物价表
CREATE TABLE IF NOT EXISTS item_price (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    serial_no VARCHAR(50),
    item_desc VARCHAR(200),
    item_code VARCHAR(50),
    prices_no VARCHAR(50),
    uom VARCHAR(20),
    price VARCHAR(20),
    special_price VARCHAR(20),
    factory VARCHAR(100),
    content_desc VARCHAR(200),
    charge_standard VARCHAR(100),
    insure_sign VARCHAR(10),
    registration_no VARCHAR(50),
    reg_exp_date VARCHAR(20),
    INDEX idx_item_code (item_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 创建医院信息表
CREATE TABLE IF NOT EXISTS hospital_info (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    hospital_name VARCHAR(200),
    hospital_code VARCHAR(50),
    hospital_level VARCHAR(50),
    hospital_type VARCHAR(50),
    address VARCHAR(500),
    phone VARCHAR(50),
    website VARCHAR(200),
    introduction TEXT,
    business_hours VARCHAR(200)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 创建挂号表
CREATE TABLE IF NOT EXISTS registration (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    patient_id VARCHAR(50),
    schedule_item_code VARCHAR(50),
    lock_queue_no VARCHAR(50),
    card_no VARCHAR(50),
    transaction_id VARCHAR(100),
    adm_doc VARCHAR(50),
    adm_date VARCHAR(20),
    adm_time VARCHAR(20),
    reg_fee VARCHAR(20),
    status VARCHAR(10),
    INDEX idx_lock_queue_no (lock_queue_no),
    INDEX idx_transaction_id (transaction_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 数据库表结构创建完成
-- 数据注入请使用独立的SQL文件(如data.sql)或通过API接口生成
