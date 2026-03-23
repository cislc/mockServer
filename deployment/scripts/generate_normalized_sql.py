import json
import random
from datetime import datetime, timedelta
import os

# Load department mappings
with open('dept_mapping.json', 'r', encoding='utf-8') as f:
    dept_mappings = json.load(f)

# Professional Dept Descriptions
dept_descriptions = {
    "内科": "内科是医院的重点科室之一，拥有多名高素质医护人员。科室设有心血管、呼吸、消化、内分泌等专业组，擅长诊治高血压、糖尿病、冠心病等常见病及疑难病症，致力于为患者提供全方位的内科诊疗服务。",
    "外科": "外科是医院的技术优势科室，医术精湛。开展各类普通外科、微创及腹腔镜手术，在甲状腺、乳腺及胃肠肿瘤手术方面具有丰富经验，年手术量稳步增长，为患者健康保驾护航。",
    "儿科": "儿科专注于儿童健康，环境温馨。设有新生儿、儿童呼吸、消化等专业组。擅长诊治儿科常见病、多发病，提供预防接种、儿童保健、生长发育咨询等一站式医疗服务，陪伴孩子健康成长。",
    "妇产科": "妇产科集医疗、保健、宣教于一体。开展产前检查、围产期保健、无痛分娩及各类妇产科手术。在妇科肿瘤诊治、不孕不育、绝经期综合征管理等方面处于前沿地位。",
    "眼科": "眼科配备国际先进的眼科检查及手术设备。擅长白内障手术、青光眼防治、准分子激光手术及各类眼底病诊治。科室致力于防盲治盲，为患者重塑光明。",
    "耳鼻喉科": "耳鼻喉科专业诊治耳、鼻、咽喉及头颈部疾病。在听力损失防治、慢性鼻炎鼻窦炎微创治疗、咽喉部良恶性肿瘤切除等方面具有丰富临床经验，设备精良，技术领先。",
    "口腔科": "口腔科开展牙体牙髓病修复、牙齿矫正、种植牙、牙周病治疗及口腔颌面外科手术。秉承微创、无痛理念，结合先进数字化技术，为患者提供专业的口腔健康管理。",
    "皮肤科": "皮肤科擅长各类皮炎、湿疹、痤疮、银屑病等常见病及性传播疾病的诊治。拥有先进的激光治疗平台及光疗设备，开展医学美容、激光祛斑等特色服务，呵护您的皮肤健康。",
    "骨科": "骨科在骨折治疗、人工关节置换、脊柱微创手术及运动损伤修复领域具有卓越优势。科室配备先进手术室系统，致力于让患者早日下床行走，恢复运动功能。",
    "神经内科": "神经内科专业诊治脑血管意外（中风）、癫痫、帕金森病、周围神经病等。设有卒中单元，开展溶栓、取栓治疗，拥有雄厚的科研与临床救治实力。",
    "心内科": "心内科是治疗心脏血管疾病的核心科室。擅长冠心病介入治疗、心律失常射频消融、心脏起搏器植入。配备24小时急诊绿色通道，全天候守护心脏安全。",
    "消化内科": "消化内科拥有先进的电子胃肠镜中心。擅长胃镜、肠镜下的各类微创手术，对慢性胃炎、胃癌早期筛查、炎症性肠病及肝胆胰疾病具有精深的临床见解。",
    "呼吸内科": "呼吸内科在支气管哮喘、慢阻肺、肺炎、肺结核及肺癌的规范化诊治方面积累了大量经验。科室开展支气管镜检查及无创辅助通气，专注心肺功能康复。",
    "肾内科": "肾内科设有标准化血液透析中心。擅长各类肾炎、肾病综合征、急慢性肾功能衰竭的诊治。技术力量扎实，为肾友提供安全、高效的血液净化与慢病管理方案。",
    "内分泌科": "内分泌科专注于糖尿病、甲状腺疾病、骨质疏松及垂体肾上腺疾病的诊治。开展糖尿病强化治疗与健康大讲堂，致力于代谢疾病的长期规范化管理。",
    "泌尿外科": "泌尿外科擅长肾脏/输尿管结石微创治疗、前列腺疾病及泌尿系统肿瘤手术。开展达芬奇机器人/腹腔镜等高精尖技术，在疑难复杂泌尿疾病治疗上享誉业界。",
    "普通外科": "普通外科主要负责甲状腺、乳腺、疝气、肝胆道疾病及胃肠等手术。科室倡导围手术期加速康复理念（ERAS），技术全面，微创水平居于地区前列。",
    "精神心理科": "精神心理科专业提供心理测评、心理咨询及精神疾病诊治。擅长抑郁症、焦虑症、失眠症及青少年行为障碍的疏导与治疗，为您构建健康的心灵驿站。"
}

doc_specialties = {
    "内科": ["高血压防治", "糖尿病管理", "心衰康复", "内科疑难杂症", "老年慢性病"],
    "外科": ["微创胆囊切除", "急腹症救治", "腹腔镜手术", "甲状腺结节手术", "疝气分级修补"],
    "儿科": ["小儿哮喘", "新生儿黄疸治疗", "发育迟缓康复", "儿科感染性疾病", "儿童营养与发育"],
    "妇产科": ["产前遗传咨询", "难产处理", "不孕不育症", "子宫肌瘤微创治疗", "围产期并发症管理"],
    "眼科": ["白内障超声乳化", "青少年近视防控", "视网膜脱离", "角膜眼表疾病", "青光眼早期筛查"],
    "耳鼻喉科": ["突发性耳聋", "过敏性鼻炎", "打鼾综合征", "中耳炎显微手术", "喉癌早期筛查"],
    "口腔科": ["牙齿隐形矫正", "单颗/全口种植牙", "牙周病序列治疗", "口腔黏膜排查", "儿童齿科保护"],
    "皮肤科": ["银屑病管理", "湿疹皮炎诊疗", "医学纹绣/激光祛斑", "荨麻疹根治", "脱发与头皮管理"],
    "骨科": ["人工髋/膝关节置换", "腰椎间盘突出微创", "复杂骨科创伤救治", "交叉韧带重建", "骨质疏松综合管理"],
    "神经内科": ["中风急性救治", "癫痫规律管控", "失眠与认知障碍", "帕金森综合征", "周围神经压迫修复"],
    "心内科": ["心脏冠脉介入", "心律失常射频消融", "心脏起搏器植入", "顽固性高血压治疗", "结构性心脏病"],
    "消化内科": ["消化道早期肿瘤筛查", "炎症性肠病管理", "肝硬化失代偿期救治", "幽门螺杆菌根除", "胃肠镜微创手术"],
    "呼吸内科": ["慢阻肺(COPD)管理", "支气管哮喘规范治疗", "肺结节辅助诊断", "支气管镜介入", "间质性肺病"],
    "肾内科": ["腹膜透析管理", "急慢性肾炎防治", "糖尿病肾病早筛", "狼疮性肾炎", "继发性高血压诊断"],
    "内分泌科": ["甲状腺结节穿刺", "痛风与高尿酸血症", "矮小症/发育管理", "特发性肥胖干预", "内分泌性高血压"],
    "泌尿外科": ["输尿管结石激光碎石", "精索静脉曲张微创", "前列腺切除术", "泌尿系肿瘤根治", "男科生殖医学"],
    "普通外科": ["乳腺癌综合保乳术", "结直肠癌规范化诊治", "肝胆结石微创", "复杂腹壁疝修补", "下肢静脉曲张微创"],
    "精神心理科": ["青少年厌学心理疏导", "产后抑郁干预", "难治性失眠管理", "社交恐惧障碍", "双相情感障碍治疗"]
}

doctor_surnames = ["张", "李", "王", "赵", "陈", "刘", "杨", "黄", "周", "吴", "徐", "孙", "胡", "朱", "高", "林", "何", "郭", "马", "罗"]
doctor_names = ["伟", "芳", "娜", "敏", "静", "强", "磊", "洋", "艳", "勇", "军", "杰", "娟", "涛", "明", "超", "秀英", "霞", "平", "刚"]
titles = [("主任医师", "01"), ("副主任医师", "02"), ("主治医师", "03")]
sessions = [("上午", "1", "08:00", "12:00"), ("下午", "2", "13:30", "17:30")]

schema_ddl = """-- 设置客户端字符集
SET NAMES utf8mb4 COLLATE utf8mb4_unicode_ci;
SET CHARACTER SET utf8mb4;

-- 创建数据库
CREATE DATABASE IF NOT EXISTS medical_mock DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE medical_mock;

-- 如果有旧表，先清空 (为防止外键冲突，先删有依赖关系的表)
DROP TABLE IF EXISTS registration;
DROP TABLE IF EXISTS item_price;
DROP TABLE IF EXISTS hospital_info;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS doctor_schedule;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS clinic_room;
DROP TABLE IF EXISTS department;

-- 1. 创建科室表
CREATE TABLE department (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    department_code VARCHAR(50) NOT NULL UNIQUE,
    department_name VARCHAR(100) NOT NULL,
    department_des VARCHAR(1000),
    department_image VARCHAR(500),
    INDEX idx_dept_code (department_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 2. 创建诊室表 (NEW)
CREATE TABLE clinic_room (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    room_code VARCHAR(50) NOT NULL UNIQUE,
    room_name VARCHAR(100) NOT NULL,
    department_code VARCHAR(50) NOT NULL,
    FOREIGN KEY (department_code) REFERENCES department(department_code),
    INDEX idx_room_dept_code (department_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 3. 创建医生表 (MODIFIED)
CREATE TABLE doctor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    doctor_code VARCHAR(50) NOT NULL UNIQUE,
    doctor_name VARCHAR(100) NOT NULL,
    department_code VARCHAR(50) NOT NULL,
    doctor_title_code VARCHAR(20),
    title VARCHAR(50),
    specialty VARCHAR(200),
    doctor_des VARCHAR(1000),
    doctor_image VARCHAR(500),
    FOREIGN KEY (department_code) REFERENCES department(department_code),
    INDEX idx_doctor_code (doctor_code),
    INDEX idx_doctor_dept_code (department_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 4. 创建医生排班表 (MODIFIED)
CREATE TABLE doctor_schedule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    m_code VARCHAR(50) UNIQUE,
    service_date VARCHAR(20),
    week_day VARCHAR(10),
    session_code VARCHAR(20),
    session_name VARCHAR(50),
    start_time VARCHAR(20),
    end_time VARCHAR(20),
    department_code VARCHAR(50),
    clinic_room_code VARCHAR(50),
    doctor_code VARCHAR(50),
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
    FOREIGN KEY (department_code) REFERENCES department(department_code),
    FOREIGN KEY (doctor_code) REFERENCES doctor(doctor_code),
    FOREIGN KEY (clinic_room_code) REFERENCES clinic_room(room_code),
    INDEX idx_sched_service_date (service_date),
    INDEX idx_sched_doctor_code (doctor_code),
    INDEX idx_sched_dept_code (department_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 5. 创建患者表
CREATE TABLE patient (
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

-- 6. 创建挂号表 (MODIFIED)
CREATE TABLE registration (
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
    FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
    FOREIGN KEY (schedule_item_code) REFERENCES doctor_schedule(m_code),
    INDEX idx_lock_queue_no (lock_queue_no),
    INDEX idx_transaction_id (transaction_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 7. 创建物价表
CREATE TABLE item_price (
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

-- 8. 创建医院信息表
CREATE TABLE hospital_info (
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

-- ================= 数据注入区 ================= --
"""

sql_statements = [schema_ddl]

# We need a stable base date for demo correctness
base_date = datetime(2026, 3, 16)

# 1. Generate Departments
sql_statements.append("\n-- 插入科室数据")
for dept_name, dept_code in dept_mappings.items():
    desc = dept_descriptions.get(dept_name, f"{dept_name}简介信息")
    sql = f"INSERT INTO department (department_code, department_name, department_des, department_image) VALUES ('{dept_code}', '{dept_name}', '{desc}', 'img_{dept_code}.png');"
    sql_statements.append(sql)

# 2. Generate Clinic Rooms
sql_statements.append("\n-- 插入诊室数据")
for dept_name, dept_code in dept_mappings.items():
    for room_num in range(1, 6):
        room_code = f"ROOM_{dept_code}_{room_num}"
        room_name = f"{dept_name}门诊{room_num}诊室"
        sql = f"INSERT INTO clinic_room (room_code, room_name, department_code) VALUES ('{room_code}', '{room_name}', '{dept_code}');"
        sql_statements.append(sql)

# 3. Generate Doctors & Schedules
sql_statements.append("\n-- 插入医生和排班数据")
random.seed(42)  # For reproducible demo data

for dept_name, dept_code in dept_mappings.items():
    specs = doc_specialties.get(dept_name, [f"{dept_name}常见病"])
    # 5 doctors per department
    for i in range(5):
        doc_name = random.choice(doctor_surnames) + random.choice(doctor_names)
        doc_code = f"DOC_{dept_code}_{i+1}"
        title_name, title_code = random.choice(titles)
        specialty = specs[i % len(specs)]
        
        years = random.randint(5, 30)
        adjectives = ["经验丰富", "医术精湛", "待人亲切", "专业严谨", "具备深厚的临床背景"]
        doc_des = f"{doc_name}{title_name}，从事{dept_name}临床工作{years}年，{random.choice(adjectives)}。{random.choice(['他','她'])}{random.choice(['专注于','长期致力于','擅长'])}{specialty}的诊疗，已成功治愈数千例相关患者。"

        # Added doctor_title_code here!
        sql_doc = f"INSERT INTO doctor (doctor_code, doctor_name, department_code, doctor_title_code, title, specialty, doctor_des, doctor_image) VALUES ('{doc_code}', '{doc_name}', '{dept_code}', '{title_code}', '{title_name}', '{specialty}', '{doc_des}', 'doc_{doc_code}.png');"
        sql_statements.append(sql_doc)
        
        for days_ahead in range(14):
            if random.random() < 0.2: continue
            sched_date = base_date + timedelta(days=days_ahead)
            date_str = sched_date.strftime('%Y-%m-%d')
            week_day = str(sched_date.weekday() + 1)
            daily_sessions = random.sample(sessions, random.choice([1, 2]))
            
            for session_name, session_code, start_t, end_t in daily_sessions:
                m_code = f"SCH_{doc_code}_{date_str.replace('-','')}_{session_code}"
                fee = random.choice(["15.00", "20.00", "50.00"])
                total_num = random.randint(15, 40)
                left_num = total_num - random.randint(0, int(total_num*0.8))
                avail_numbers = ",".join([str(n) for n in range(1, total_num+1) if random.random() > 0.3])
                if not avail_numbers: avail_numbers = "1"; left_num = 1
                
                room_num = random.randint(1, 5)
                room_code = f"ROOM_{dept_code}_{room_num}"
                
                # Removed the big redundant string fields from insert!
                sql_sched = f"""INSERT INTO doctor_schedule (
                    m_code, service_date, week_day, session_code, session_name, start_time, end_time, 
                    department_code, clinic_room_code, doctor_code, doctor_sess_type_code, doctor_sess_type, service_code, service_name, 
                    fee, reg_fee, checkup_fee, service_fee, other_fee, available_number_str, 
                    admit_address_string, admit_time_range, note, time_range_flag, schedule_status, 
                    available_total_num, available_left_num
                ) VALUES (
                    '{m_code}', '{date_str}', '{week_day}', '{session_code}', '{session_name}', '{start_t}', '{end_t}',
                    '{dept_code}', '{room_code}', '{doc_code}',
                    '1', '专家门诊', 'SRV_001', '{title_name}挂号费',
                    '{fee}', '{fee}', '0.00', '0.00', '0.00', '{avail_numbers}',
                    '主楼{random.randint(1,6)}层{dept_name}候诊区', '{start_t}-{end_t}', '请提前15分钟候诊', '0', '1',
                    '{total_num}', '{left_num}'
                );"""
                sql_statements.append(sql_sched.replace('\n', ' ').replace('    ', ''))

output_path = r'i:\inspur_mock_server\mockServer\deployment\db\medical_mock_init.sql'
with open(output_path, 'w', encoding='utf-8') as f:
    f.write('\n'.join(sql_statements))

print(f"Normalized Mock SQL successfully written to {output_path}")
