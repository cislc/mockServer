import urllib.request
import urllib.error
import json
import traceback

BASE_URL = "http://localhost:8080"
headers = {"Content-Type": "application/json"}

api_tests = [
    {"name": "3.1.1 门诊患者查询", "url": "/api/search/outpatient", "payload": {"CardNo": "370", "CardType": "1"}},
    {"name": "3.1.2 门诊患者建档", "url": "/api/save/patient", "payload": {"PatientType": "01", "PatientCard": "130", "Sex": "1", "PatientName": "王", "IDType": "01", "Mobile": "139", "CardTypeCode": "02", "DOB": "1941-11-28", "IDNo": "130"}},
    {"name": "3.1.3 物价查询", "url": "/api/search/item/price", "payload": {"Alias": "jzrmyqdb", "ItemType": "1"}},
    {"name": "3.1.4 医院简介查询", "url": "/api/search/hospital/info", "payload": {}},
    {"name": "3.1.5 科室简介查询", "url": "/api/search/department/info", "payload": {}},
    {"name": "3.1.6 医生简介查询", "url": "/api/search/doctor/info", "payload": {"DepartmentCode": "DEPT001"}},
    {"name": "3.2.1 科室排班信息获取", "url": "/api/search/department/schedule", "payload": {"DepartmentCode": "DEPT001", "StartDate": "2026-03-16", "EndDate": "2026-03-24"}},
    {"name": "3.2.2 医生排班信息获取", "url": "/api/search/doctor/schedule", "payload": {"DoctorCode": "DOC_DEPT001_1", "StartDate": "2026-03-16", "EndDate": "2026-03-24"}},
    # Printing APIs
    {"name": "3.5.1 获取电子病历PDF", "url": "/api/document/electronic", "payload": {"CardNo": "123", "CardType": "1", "RegId": "REG001"}},
    {"name": "3.5.2 标记电子病历已打印", "url": "/api/document/electronic/status", "payload": {"ReportId": "RPT123", "PatientId": "P123"}},
    {"name": "3.5.3 获取检验报告PDF", "url": "/api/lab/reportpdf", "payload": {"CardNo": "123", "CardType": "1", "RegId": "REG001"}},
    {"name": "3.5.4 标记检验已打印", "url": "/api/lab/reportpdf/status", "payload": {"ReportId": "RPT123", "PatientId": "P123"}},
    {"name": "3.5.5 获取检查报告PDF", "url": "/api/lab/checkpdf", "payload": {"CardNo": "123", "CardType": "1", "RegId": "REG001"}},
    {"name": "3.5.6 标记检查已打印", "url": "/api/lab/checkpdf/status", "payload": {"ReportId": "RPT123", "PatientId": "P123"}},
    {"name": "3.5.7 获取电子发票", "url": "/api/invoicing/electronic", "payload": {"CardNo": "123", "CardType": "1", "RegId": "REG001"}},
    {"name": "3.5.8 标记发票已打印", "url": "/api/invoicing/electronic/status", "payload": {"ReportId": "RPT123", "PatientId": "P123"}}
]

with open('test_results.log', 'w', encoding='utf-8') as f:
    def log(msg):
        print(msg)
        f.write(msg + '\n')

    log("--- Start Comprehensive API Testing ---")
    results = []
    for test in api_tests:
        body = test["payload"]
        req = urllib.request.Request(BASE_URL + test["url"], data=json.dumps(body).encode('utf-8'), headers=headers, method='POST')
        try:
            with urllib.request.urlopen(req) as resp:
                content = resp.read().decode('utf-8')
                res_body = json.loads(content)
                
                if 'ResultCode' not in res_body:
                    err = f"MISSING ResultCode in body: {list(res_body.keys())}"
                    log(f"✖ [{test['name']}] FAILED: {err} -> URL: {test['url']}")
                    results.append((test['name'], False, err))
                    continue
                    
                code = res_body['ResultCode']
                log(f"✔ [{test['name']}] SUCCESS (ResultCode: {code}) -> URL: {test['url']}")
                results.append((test['name'], True, "OK"))
        except urllib.error.HTTPError as e:
            err = f"HTTP Error {e.code}"
            if e.code == 400:
                err += " (Bad Request - might be missing envelope parsing on backend!)"
            log(f"✖ [{test['name']}] FAILED: {err} -> URL: {test['url']}")
            results.append((test['name'], False, err))
        except Exception as e:
            err = f"Exception: {str(e)}"
            log(f"✖ [{test['name']}] FAILED: {err} -> URL: {test['url']}")
            results.append((test['name'], False, err))

    passed = sum(1 for r in results if r[1])
    log(f"\nCompleted: {passed}/{len(results)} passed.")
