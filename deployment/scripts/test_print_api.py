import urllib.request
import urllib.error
import json

BASE_URL = "http://localhost:8080"
headers = {"Content-Type": "application/json"}

endpoints = [
    {
        "name": "3.5.1 Get EMR PDF",
        "url": "/api/document/electronic",
        "payload": {"CardNo": "123", "CardType": "1"}
    },
    {
        "name": "3.5.2 Mark EMR Printed",
        "url": "/api/document/electronic/status",
        "payload": {"ReportId": "RPT123", "PatientId": "P123"}
    },
    {
        "name": "3.5.3 Get Lab PDF",
        "url": "/api/lab/reportpdf",
        "payload": {"CardNo": "123", "CardType": "1"}
    },
    {
        "name": "3.5.4 Mark Lab Printed",
        "url": "/api/lab/reportpdf/status",
        "payload": {"ReportId": "RPT123", "PatientId": "P123"}
    },
    {
        "name": "3.5.5 Get Check PDF",
        "url": "/api/lab/checkpdf",
        "payload": {"CardNo": "123", "CardType": "1"}
    },
    {
        "name": "3.5.6 Mark Check Printed",
        "url": "/api/lab/checkpdf/status",
        "payload": {"ReportId": "RPT123", "PatientId": "P123"}
    },
    {
        "name": "3.5.7 Get Invoice PDF",
        "url": "/api/invoicing/electronic",
        "payload": {"CardNo": "123", "CardType": "1"}
    },
    {
        "name": "3.5.8 Mark Invoice Printed",
        "url": "/api/invoicing/electronic/status",
        "payload": {"ReportId": "RPT123", "PatientId": "P123"}
    }
]

print("--- Testing Print APIs ---")
for ep in endpoints:
    req = urllib.request.Request(BASE_URL + ep["url"], data=json.dumps(ep["payload"]).encode('utf-8'), headers=headers, method='POST')
    try:
        with urllib.request.urlopen(req) as response:
            res_body = response.read().decode('utf-8')
            data = json.loads(res_body)
            print(f"[{ep['name']}] SUCCESS - ResultCode: {data.get('ResultCode')}")
    except urllib.error.URLError as e:
        print(f"[{ep['name']}] FAILED - Error: {e}")
    except json.JSONDecodeError:
        print(f"[{ep['name']}] FAILED - Response was not valid JSON: {res_body}")
print("--- Test Complete ---")
