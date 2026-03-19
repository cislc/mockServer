-- 设置客户端字符集
SET NAMES utf8mb4 COLLATE utf8mb4_unicode_ci;
SET CHARACTER SET utf8mb4;

-- 清空现有排班数据
TRUNCATE TABLE doctor_schedule;

-- 插入内科排班数据 (DEPT001)
INSERT INTO doctor_schedule (m_code, service_date, week_day, session_code, session_name, start_time, end_time, 
    department_code, department_name, clinic_room_code, clinic_room_name, doctor_code, doctor_name, 
    doctor_title_code, doctor_title, doctor_spec, doctor_sess_type_code, doctor_sess_type, 
    service_code, service_name, fee, reg_fee, checkup_fee, service_fee, other_fee, 
    available_number_str, admit_address_string, admit_time_range, note, time_range_flag, 
    schedule_status, available_total_num, available_left_num) VALUES
('SC001', '2024-01-15', '2', 'AM', '上午', '08:00', '12:00', 
    'DEPT001', '内科', 'CR101', '101诊室', 'DOC001', '张明', 
    'P01', '主任医师', '高血压病综合管理、2型糖尿病诊治、冠心病药物治疗、慢性心力衰竭、心脑血管疾病一级预防', 'ST01', '专家门诊', 
    'MED001', '内科专科', '50.00', '15.00', '25.00', '10.00', '0.00', 
    '上午余号10', '门诊大楼2楼A区', '08:00-10:00', '请携带既往病历及近期检查报告', '1', 
    '1', '30', '10'),
('SC002', '2024-01-15', '2', 'PM', '下午', '14:00', '18:00', 
    'DEPT001', '内科', 'CR102', '102诊室', 'DOC002', '李华', 
    'P03', '主治医师', '呼吸系统感染性疾病、慢性阻塞性肺疾病、支气管哮喘、社区获得性肺炎、呼吸危重症救治', 'ST03', '普通门诊', 
    'MED002', '内科普通门诊', '30.00', '8.00', '15.00', '7.00', '0.00', 
    '下午余号20', '门诊大楼2楼B区', '14:00-17:00', '肺部CT检查请提前预约', '1', 
    '1', '40', '20');

-- 插入外科排班数据 (DEPT002)
INSERT INTO doctor_schedule (m_code, service_date, week_day, session_code, session_name, start_time, end_time, 
    department_code, department_name, clinic_room_code, clinic_room_name, doctor_code, doctor_name, 
    doctor_title_code, doctor_title, doctor_spec, doctor_sess_type_code, doctor_sess_type, 
    service_code, service_name, fee, reg_fee, checkup_fee, service_fee, other_fee, 
    available_number_str, admit_address_string, admit_time_range, note, time_range_flag, 
    schedule_status, available_total_num, available_left_num) VALUES
('SC003', '2024-01-16', '3', 'AM', '上午', '08:30', '12:30', 
    'DEPT002', '外科', 'CR201', '201诊室', 'DOC003', '王强', 
    'P01', '主任医师', '甲状腺良恶性肿瘤手术治疗、乳腺肿瘤微创手术、胃肠肿瘤根治术、腹腔镜肝胆手术、急腹症诊治', 'ST01', '专家门诊', 
    'SUR001', '外科专科', '60.00', '20.00', '30.00', '10.00', '0.00', 
    '上午余号8', '门诊大楼3楼A区', '08:30-11:30', '术前检查需提前完成', '1', 
    '1', '20', '8'),
('SC004', '2024-01-17', '4', 'PM', '下午', '13:30', '17:30', 
    'DEPT002', '外科', 'CR202', '202诊室', 'DOC004', '刘建国', 
    'P02', '副主任医师', '腹壁疝修补术、阑尾炎手术、胆囊结石手术、肛肠疾病治疗、外科创伤处理', 'ST02', '特需门诊', 
    'SUR002', '外科特需', '80.00', '25.00', '35.00', '20.00', '0.00', 
    '下午余号5', '特需门诊部1楼', '13:30-16:30', '特需门诊需预约', '0', 
    '1', '15', '5');

-- 插入儿科排班数据 (DEPT003)
INSERT INTO doctor_schedule (m_code, service_date, week_day, session_code, session_name, start_time, end_time, 
    department_code, department_name, clinic_room_code, clinic_room_name, doctor_code, doctor_name, 
    doctor_title_code, doctor_title, doctor_spec, doctor_sess_type_code, doctor_sess_type, 
    service_code, service_name, fee, reg_fee, checkup_fee, service_fee, other_fee, 
    available_number_str, admit_address_string, admit_time_range, note, time_range_flag, 
    schedule_status, available_total_num, available_left_num) VALUES
('SC005', '2024-01-16', '3', 'AM', '上午', '08:00', '12:00', 
    'DEPT003', '儿科', 'CR301', '301诊室', 'DOC005', '周芳', 
    'P01', '主任医师', '儿童呼吸系统疾病、支气管哮喘规范化治疗、儿童重症肺炎、儿童慢性咳嗽、呼吸道感染性疾病', 'ST01', '专家门诊', 
    'PED001', '儿科呼吸专科', '45.00', '12.00', '23.00', '10.00', '0.00', 
    '上午余号12', '儿科门诊1楼A区', '08:00-11:00', '请携带儿童预防接种本', '1', 
    '1', '25', '12'),
('SC006', '2024-01-17', '4', 'AM', '上午', '09:00', '12:00', 
    'DEPT003', '儿科', 'CR302', '302诊室', 'DOC006', '陈明', 
    'P02', '副主任医师', '儿童消化系统疾病、儿童营养不良、婴儿喂养指导、儿童食物过敏、功能性胃肠病', 'ST01', '专家门诊', 
    'PED002', '儿科消化专科', '40.00', '10.00', '20.00', '10.00', '0.00', 
    '上午余号15', '儿科门诊1楼B区', '09:00-11:30', '婴幼儿请带喂养记录', '1', 
    '1', '30', '15'),
('SC007', '2024-01-18', '5', 'PM', '下午', '14:00', '18:00', 
    'DEPT003', '儿科', 'CR303', '303诊室', 'DOC007', '李娜', 
    'P03', '主治医师', '儿童生长发育评估、性早熟诊治、矮小症治疗、儿童保健、新生儿疾病筛查', 'ST03', '普通门诊', 
    'PED003', '儿科保健门诊', '35.00', '8.00', '18.00', '9.00', '0.00', 
    '下午余号18', '儿科门诊1楼C区', '14:00-17:00', '请携带儿童生长发育曲线图', '1', 
    '1', '35', '18');

-- 插入妇产科排班数据 (DEPT004)
INSERT INTO doctor_schedule (m_code, service_date, week_day, session_code, session_name, start_time, end_time, 
    department_code, department_name, clinic_room_code, clinic_room_name, doctor_code, doctor_name, 
    doctor_title_code, doctor_title, doctor_spec, doctor_sess_type_code, doctor_sess_type, 
    service_code, service_name, fee, reg_fee, checkup_fee, service_fee, other_fee, 
    available_number_str, admit_address_string, admit_time_range, note, time_range_flag, 
    schedule_status, available_total_num, available_left_num) VALUES
('SC008', '2024-01-17', '4', 'AM', '上午', '08:30', '12:30', 
    'DEPT004', '妇产科', 'CR401', '401诊室', 'DOC008', '赵丽', 
    'P01', '主任医师', '妇科肿瘤手术治疗、宫颈病变诊治、子宫内膜异位症、妇科内分泌疾病、更年期综合征管理', 'ST01', '专家门诊', 
    'GYN001', '妇科肿瘤专科', '55.00', '15.00', '25.00', '15.00', '0.00', 
    '上午余号6', '妇产科门诊3楼A区', '08:30-11:30', '需携带近期妇科B超报告', '1', 
    '1', '18', '6'),
('SC009', '2024-01-18', '5', 'PM', '下午', '13:30', '17:30', 
    'DEPT004', '妇产科', 'CR402', '402诊室', 'DOC009', '孙静', 
    'P02', '副主任医师', '高危妊娠管理、产前诊断、孕期营养指导、妊娠期糖尿病管理、分娩镇痛', 'ST02', '特需门诊', 
    'OBS001', '产科特需门诊', '70.00', '20.00', '30.00', '20.00', '0.00', 
    '下午余号4', '特需产科门诊2楼', '13:30-16:30', '请携带孕期检查记录本', '0', 
    '1', '12', '4');

-- 插入眼科排班数据 (DEPT005)
INSERT INTO doctor_schedule (m_code, service_date, week_day, session_code, session_name, start_time, end_time, 
    department_code, department_name, clinic_room_code, clinic_room_name, doctor_code, doctor_name, 
    doctor_title_code, doctor_title, doctor_spec, doctor_sess_type_code, doctor_sess_type, 
    service_code, service_name, fee, reg_fee, checkup_fee, service_fee, other_fee, 
    available_number_str, admit_address_string, admit_time_range, note, time_range_flag, 
    schedule_status, available_total_num, available_left_num) VALUES
('SC010', '2024-01-16', '3', 'AM', '上午', '09:00', '12:00', 
    'DEPT005', '眼科', 'CR501', '501诊室', 'DOC010', '周伟', 
    'P01', '主任医师', '白内障超声乳化手术、青光眼诊治、眼底病激光治疗、屈光不正矫正、眼表疾病治疗', 'ST01', '专家门诊', 
    'OPH001', '眼科专科', '50.00', '15.00', '25.00', '10.00', '0.00', 
    '上午余号8', '眼科门诊4楼A区', '09:00-11:30', '散瞳检查请勿自行驾车', '1', 
    '1', '20', '8'),
('SC011', '2024-01-19', '6', 'AM', '上午', '08:30', '12:30', 
    'DEPT005', '眼科', 'CR502', '502诊室', 'DOC011', '吴芳', 
    'P03', '主治医师', '儿童近视防控、弱视训练、斜视矫正、验光配镜、角膜塑形镜验配', 'ST03', '普通门诊', 
    'OPH002', '眼科视光门诊', '35.00', '10.00', '18.00', '7.00', '0.00', 
    '上午余号15', '眼科门诊4楼B区', '08:30-12:00', '儿童验光需散瞳', '1', 
    '1', '25', '15');

-- 插入耳鼻喉科排班数据 (DEPT006)
INSERT INTO doctor_schedule (m_code, service_date, week_day, session_code, session_name, start_time, end_time, 
    department_code, department_name, clinic_room_code, clinic_room_name, doctor_code, doctor_name, 
    doctor_title_code, doctor_title, doctor_spec, doctor_sess_type_code, doctor_sess_type, 
    service_code, service_name, fee, reg_fee, checkup_fee, service_fee, other_fee, 
    available_number_str, admit_address_string, admit_time_range, note, time_range_flag, 
    schedule_status, available_total_num, available_left_num) VALUES
('SC012', '2024-01-17', '4', 'AM', '上午', '08:00', '12:00', 
    'DEPT006', '耳鼻喉科', 'CR601', '601诊室', 'DOC012', '郑强', 
    'P01', '主任医师', '鼻内镜手术、慢性鼻窦炎治疗、过敏性鼻炎免疫治疗、鼾症综合治疗、鼻咽癌早期诊断', 'ST01', '专家门诊', 
    'ENT001', '耳鼻喉专科', '55.00', '15.00', '25.00', '15.00', '0.00', 
    '上午余号7', '耳鼻喉门诊5楼A区', '08:00-11:00', '鼻内镜检查前需禁食', '1', 
    '1', '18', '7'),
('SC013', '2024-01-18', '5', 'PM', '下午', '14:00', '18:00', 
    'DEPT006', '耳鼻喉科', 'CR602', '602诊室', 'DOC013', '林芳', 
    'P02', '副主任医师', '儿童扁桃体腺样体手术、中耳炎治疗、听力重建手术、眩晕诊治、耳聋基因咨询', 'ST02', '特需门诊', 
    'ENT002', '耳科特需门诊', '65.00', '18.00', '28.00', '19.00', '0.00', 
    '下午余号5', '特需耳科门诊3楼', '14:00-17:00', '听力检查需预约', '0', 
    '1', '15', '5');

-- 插入口腔科排班数据 (DEPT007)
INSERT INTO doctor_schedule (m_code, service_date, week_day, session_code, session_name, start_time, end_time, 
    department_code, department_name, clinic_room_code, clinic_room_name, doctor_code, doctor_name, 
    doctor_title_code, doctor_title, doctor_spec, doctor_sess_type_code, doctor_sess_type, 
    service_code, service_name, fee, reg_fee, checkup_fee, service_fee, other_fee, 
    available_number_str, admit_address_string, admit_time_range, note, time_range_flag, 
    schedule_status, available_total_num, available_left_num) VALUES
('SC014', '2024-01-16', '3', 'AM', '上午', '08:30', '12:30', 
    'DEPT007', '口腔科', 'CR701', '701诊室', 'DOC014', '杨明', 
    'P01', '主任医师', '种植牙修复、全口义齿设计、牙列缺损修复、前牙美学修复、咬合重建', 'ST01', '专家门诊', 
    'DEN001', '口腔修复专科', '60.00', '18.00', '27.00', '15.00', '0.00', 
    '上午余号6', '口腔科门诊6楼A区', '08:30-11:30', '需携带近期口腔X光片', '1', 
    '1', '15', '6'),
('SC015', '2024-01-17', '4', 'PM', '下午', '14:00', '18:00', 
    'DEPT007', '口腔科', 'CR702', '702诊室', 'DOC015', '刘静', 
    'P02', '副主任医师', '儿童口腔疾病预防、乳牙龋病治疗、儿童牙齿外伤处理、窝沟封闭、儿童行为管理', 'ST02', '特需门诊', 
    'DEN002', '儿童口腔门诊', '55.00', '15.00', '25.00', '15.00', '0.00', 
    '下午余号5', '特需口腔门诊2楼', '14:00-17:00', '儿童需家长陪同', '0', 
    '1', '12', '5'),
('SC016', '2024-01-19', '6', 'AM', '上午', '09:00', '12:00', 
    'DEPT007', '口腔科', 'CR703', '703诊室', 'DOC016', '陈伟', 
    'P03', '主治医师', '牙周病系统治疗、牙龈成形术、牙周翻瓣手术、种植体周围炎治疗、口腔卫生指导', 'ST03', '普通门诊', 
    'DEN003', '牙周病门诊', '40.00', '12.00', '20.00', '8.00', '0.00', 
    '上午余号10', '口腔科门诊6楼C区', '09:00-11:30', '牙周治疗需多次复诊', '1', 
    '1', '20', '10');

-- 插入皮肤科排班数据 (DEPT008)
INSERT INTO doctor_schedule (m_code, service_date, week_day, session_code, session_name, start_time, end_time, 
    department_code, department_name, clinic_room_code, clinic_room_name, doctor_code, doctor_name, 
    doctor_title_code, doctor_title, doctor_spec, doctor_sess_type_code, doctor_sess_type, 
    service_code, service_name, fee, reg_fee, checkup_fee, service_fee, other_fee, 
    available_number_str, admit_address_string, admit_time_range, note, time_range_flag, 
    schedule_status, available_total_num, available_left_num) VALUES
('SC017', '2024-01-17', '4', 'AM', '上午', '08:00', '12:00', 
    'DEPT008', '皮肤科', 'CR801', '801诊室', 'DOC017', '孙芳', 
    'P01', '主任医师', '银屑病生物制剂治疗、特应性皮炎综合管理、自身免疫性大疱病、皮肤淋巴瘤、疑难皮肤病诊断', 'ST01', '专家门诊', 
    'DER001', '皮肤免疫专科', '50.00', '15.00', '25.00', '10.00', '0.00', 
    '上午余号8', '皮肤科门诊7楼A区', '08:00-11:00', '请携带既往病理报告', '1', 
    '1', '20', '8'),
('SC018', '2024-01-18', '5', 'PM', '下午', '14:00', '18:00', 
    'DEPT008', '皮肤科', 'CR802', '802诊室', 'DOC018', '赵明', 
    'P02', '副主任医师', '痤疮综合治疗、玫瑰痤疮管理、激光美容治疗、色素性疾病、皮肤年轻化治疗', 'ST02', '特需门诊', 
    'DER002', '皮肤美容门诊', '70.00', '20.00', '30.00', '20.00', '0.00', 
    '下午余号6', '美容皮肤科门诊3楼', '14:00-17:00', '激光治疗需提前咨询', '0', 
    '1', '15', '6');

-- 插入骨科排班数据 (DEPT009)
INSERT INTO doctor_schedule (m_code, service_date, week_day, session_code, session_name, start_time, end_time, 
    department_code, department_name, clinic_room_code, clinic_room_name, doctor_code, doctor_name, 
    doctor_title_code, doctor_title, doctor_spec, doctor_sess_type_code, doctor_sess_type, 
    service_code, service_name, fee, reg_fee, checkup_fee, service_fee, other_fee, 
    available_number_str, admit_address_string, admit_time_range, note, time_range_flag, 
    schedule_status, available_total_num, available_left_num) VALUES
('SC019', '2024-01-18', '5', 'AM', '上午', '08:30', '12:30', 
    'DEPT009', '骨科', 'CR901', '901诊室', 'DOC019', '周强', 
    'P01', '主任医师', '人工髋膝关节置换术、关节镜微创手术、运动损伤修复、骨关节炎阶梯治疗、关节畸形矫正', 'ST01', '专家门诊', 
    'ORT001', '关节外科专科', '60.00', '18.00', '27.00', '15.00', '0.00', 
    '上午余号7', '骨科门诊8楼A区', '08:30-11:30', '请携带X光片或MRI片', '1', 
    '1', '18', '7'),
('SC020', '2024-01-19', '6', 'PM', '下午', '14:00', '18:00', 
    'DEPT009', '骨科', 'CR902', '902诊室', 'DOC020', '李建国', 
    'P02', '副主任医师', '脊柱微创手术、椎间盘突出症治疗、脊柱侧弯矫正、骨质疏松性骨折、颈肩腰腿痛综合治疗', 'ST02', '特需门诊', 
    'ORT002', '脊柱外科门诊', '65.00', '20.00', '30.00', '15.00', '0.00', 
    '下午余号5', '特需骨科门诊4楼', '14:00-17:00', '脊柱手术需详细评估', '0', 
    '1', '15', '5');

-- 插入神经内科排班数据 (DEPT010) - 继续添加更多科室数据...
INSERT INTO doctor_schedule (m_code, service_date, week_day, session_code, session_name, start_time, end_time, 
    department_code, department_name, clinic_room_code, clinic_room_name, doctor_code, doctor_name, 
    doctor_title_code, doctor_title, doctor_spec, doctor_sess_type_code, doctor_sess_type, 
    service_code, service_name, fee, reg_fee, checkup_fee, service_fee, other_fee, 
    available_number_str, admit_address_string, admit_time_range, note, time_range_flag, 
    schedule_status, available_total_num, available_left_num) VALUES
('SC021', '2024-01-16', '3', 'AM', '上午', '09:00', '12:00', 
    'DEPT010', '神经内科', 'CR1001', '1001诊室', 'DOC021', '王伟', 
    'P01', '主任医师', '脑血管病急诊救治、缺血性卒中血管内治疗、脑出血微创手术、脑动脉狭窄支架植入、脑血管畸形诊治', 'ST01', '专家门诊', 
    'NEU001', '脑血管病专科', '55.00', '15.00', '25.00', '15.00', '0.00', 
    '上午余号8', '神经内科门诊9楼A区', '09:00-11:30', '请携带头部影像资料', '1', 
    '1', '20', '8'),
('SC022', '2024-01-17', '4', 'PM', '下午', '14:00', '18:00', 
    'DEPT010', '神经内科', 'CR1002', '1002诊室', 'DOC022', '陈芳', 
    'P02', '副主任医师', '帕金森病药物治疗、运动障碍疾病、多系统萎缩、肌张力障碍、肉毒素治疗', 'ST02', '特需门诊', 
    'NEU002', '运动障碍门诊', '70.00', '20.00', '30.00', '20.00', '0.00', 
    '下午余号4', '特需神经内科门诊5楼', '14:00-17:00', '需详细记录症状变化', '0', 
    '1', '12', '4'),
('SC023', '2024-01-19', '6', 'AM', '上午', '08:30', '12:30', 
    'DEPT010', '神经内科', 'CR1003', '1003诊室', 'DOC023', '李娜', 
    'P03', '主治医师', '癫痫规范化治疗、视频脑电图监测、难治性癫痫、头痛头晕鉴别诊断、神经系统感染性疾病', 'ST03', '普通门诊', 
    'NEU003', '癫痫头痛门诊', '45.00', '12.00', '23.00', '10.00', '0.00', 
    '上午余号12', '神经内科门诊9楼C区', '08:30-12:00', '癫痫患者需记录发作情况', '1', 
    '1', '25', '12');

-- 插入患者数据
INSERT INTO patient (patient_id, patient_name, sex_code, sex, dob, document_id, address, 
    id_type_code, id_type, id_no, yb_flag, pat_type, pat_type_code, mobile, 
    insure_card_no, acc_info, acc_info_balance, acc_info_no, patient_card) VALUES
('P00001', '张三', '1', '男', '1985-03-15', 'DOC00001', '浙江省杭州市西湖区文一路123号', 
    '01', '身份证', '330102198503150012', '0', '自费', '01', '13800138001', 
    'YB00001', '账户信息', '500.00', 'ACC00001', 'C0000000001'),
('P00002', '李四', '2', '女', '1990-07-22', 'DOC00002', '浙江省杭州市上城区解放路456号', 
    '01', '身份证', '330103199007220023', '1', '医保', '02', '13900139002', 
    'YB00002', '账户信息', '1200.50', 'ACC00002', 'C0000000002'),
('P00003', '王五', '1', '男', '1978-11-08', 'DOC00003', '浙江省杭州市拱墅区莫干山路789号', 
    '01', '身份证', '330105197811080034', '0', '自费', '01', '13700137003', 
    'YB00003', '账户信息', '300.00', 'ACC00003', 'C0000000003'),
('P00004', '赵六', '2', '女', '1995-05-18', 'DOC00004', '浙江省杭州市江干区钱江路321号', 
    '01', '身份证', '330104199505180045', '1', '医保', '02', '13600136004', 
    'YB00004', '账户信息', '800.75', 'ACC00004', 'C0000000004'),
('P00005', '孙七', '1', '男', '1982-09-30', 'DOC00005', '浙江省杭州市滨江区江南大道654号', 
    '01', '身份证', '330108198209300056', '0', '自费', '01', '13500135005', 
    'YB00005', '账户信息', '150.00', 'ACC00005', 'C0000000005');

-- 插入物价数据
INSERT INTO item_price (serial_no, item_desc, item_code, prices_no, uom, price, special_price, 
    factory, content_desc, charge_standard, insure_sign, registration_no, reg_exp_date) VALUES
('SN00001', '血常规', 'ITEM0001', 'PN000001', '次', '25.00', '22.50', 
    '上海医药集团', '血常规检查', '国家标准', '1', '国药准字H20180001', '2025-12-31'),
('SN00002', '尿常规', 'ITEM0002', 'PN000002', '次', '20.00', '18.00', 
    '北京同仁堂', '尿常规检查', '国家标准', '1', '国药准字H20180002', '2025-12-31'),
('SN00003', '肝功能', 'ITEM0003', 'PN000003', '次', '80.00', '72.00', 
    '广州医药', '肝功能检查', '国家标准', '1', '国药准字H20180003', '2025-12-31'),
('SN00004', '阿莫西林胶囊', 'ITEM0004', 'PN000004', '盒', '15.50', '13.95', 
    '江苏恒瑞', '阿莫西林胶囊 0.5g*24粒', '国家标准', '1', '国药准字H20180004', '2026-06-30'),
('SN00005', '布洛芬片', 'ITEM0005', 'PN000005', '盒', '12.00', '10.80', 
    '浙江海正', '布洛芬片 0.4g*20片', '国家标准', '1', '国药准字H20180005', '2026-08-31');

-- 插入医院信息数据
INSERT INTO hospital_info (hospital_name, hospital_code, hospital_level, hospital_type, address, 
    phone, website, introduction, business_hours) VALUES
('浪潮智慧医疗医院', 'HOSP001', '三级甲等', '综合医院', 
    '浙江省杭州市西湖区文三路199号', '0571-88888888', 'http://www.inspur-hospital.com',
    '浪潮智慧医疗医院是一所集医疗、教学、科研、预防保健为一体的三级甲等综合性医院。医院占地面积10万平方米，建筑面积15万平方米，开放床位1200张。拥有先进的医疗设备和优秀的医疗团队，设有内科、外科、妇产科、儿科、骨科、神经内科等30余个临床科室。医院秉承"以患者为中心"的服务理念，致力于为广大患者提供优质、高效、便捷的医疗服务。',
    '周一至周日 08:00-17:30（急诊24小时）');

-- 插入科室简介数据
INSERT INTO department (department_code, department_name, department_des, department_image) VALUES
('DEPT001', '内科', '内科是医院的重点科室之一，拥有主任医师5名、副主任医师8名。科室设有心血管内科、呼吸内科、消化内科、内分泌科等专业组，配备先进的诊疗设备，擅长诊治高血压、糖尿病、冠心病、慢性阻塞性肺疾病等常见病及疑难病症。', '/images/dept/internal.jpg'),
('DEPT002', '外科', '外科是医院的传统优势科室，技术力量雄厚。科室开展各类普通外科手术、微创手术、腹腔镜手术等，在甲状腺手术、乳腺手术、胃肠肿瘤手术等方面具有丰富经验。年手术量超过2000台次。', '/images/dept/surgery.jpg'),
('DEPT003', '儿科', '儿科是医院的特色科室，专注于儿童健康。科室设有新生儿科、儿童呼吸科、儿童消化科等专业组。擅长诊治小儿呼吸系统疾病、消化系统疾病、新生儿疾病等，提供儿童保健、预防接种等服务。', '/images/dept/pediatrics.jpg'),
('DEPT004', '妇产科', '妇产科是集医疗、教学、科研为一体的综合性科室。科室开展产前检查、孕期保健、无痛分娩、剖宫产等服务，在妇科肿瘤、不孕不育、妇科内分泌疾病等方面具有专业优势。', '/images/dept/obstetrics.jpg'),
('DEPT005', '骨科', '骨科是医院的重点建设科室，拥有先进的骨科手术设备。科室擅长骨折治疗、关节置换、脊柱手术、运动损伤治疗等。开展微创骨科手术，为患者提供精准、安全的骨科诊疗服务。', '/images/dept/orthopedics.jpg');

-- 插入医生简介数据
INSERT INTO doctor (doctor_code, doctor_name, department_code, title, specialty, doctor_des, doctor_image) VALUES
('DOC001', '张明', 'DEPT001', '主任医师', '心血管内科', '张明主任医师，从事心血管内科临床工作30余年，擅长高血压、冠心病、心力衰竭等疾病的诊治。主持多项省级科研课题，发表学术论文50余篇。坐诊时间：周一、周三上午。', '/images/doctor/doc001.jpg'),
('DOC002', '李华', 'DEPT001', '主治医师', '呼吸内科', '李华主治医师，毕业于浙江大学医学院，擅长慢性阻塞性肺疾病、支气管哮喘、肺部感染等呼吸系统疾病的诊治。具有丰富的临床经验。坐诊时间：周二、周四下午。', '/images/doctor/doc002.jpg'),
('DOC003', '王强', 'DEPT002', '主任医师', '普通外科', '王强主任医师，外科学博士，擅长甲状腺手术、乳腺手术、胃肠肿瘤手术。完成各类手术5000余例，手术技术精湛。坐诊时间：周一、周五上午。', '/images/doctor/doc003.jpg'),
('DOC004', '刘建国', 'DEPT002', '副主任医师', '骨外科', '刘建国副主任医师，从事骨外科工作20年，擅长骨折治疗、关节疾病诊治。对复杂骨折的治疗有独到见解。坐诊时间：周三、周五下午。', '/images/doctor/doc004.jpg'),
('DOC005', '周芳', 'DEPT003', '主任医师', '儿科', '周芳主任医师，儿科学硕士，擅长儿童呼吸系统疾病、消化系统疾病的诊治。对儿童哮喘、慢性咳嗽有丰富的治疗经验。坐诊时间：周一至周五上午。', '/images/doctor/doc005.jpg');

COMMIT;
