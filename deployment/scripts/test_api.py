import json
import urllib.request

req1 = urllib.request.Request("http://localhost:8080/api/search/department/info", data=json.dumps({"head": {"token": "123"}}).encode('utf-8'), headers={'Content-Type': 'application/json'})
with urllib.request.urlopen(req1) as response:
    print("Dept Info (First item):")
    data = json.loads(response.read().decode('utf-8'))
    print(json.dumps(data['body']['Departments'][0], indent=2, ensure_ascii=False))

req2 = urllib.request.Request("http://localhost:8080/api/search/doctor/info", data=json.dumps({"head": {"token": "123"}, "body": {"DepartmentCode": "DEPT001"}}).encode('utf-8'), headers={'Content-Type': 'application/json'})
with urllib.request.urlopen(req2) as response:
    print("\nDoctor Info Samples (DEPT001):")
    data = json.loads(response.read().decode('utf-8'))
    for doc in data['body']['Doctors'][:3]:
        print(f"Name: {doc['DoctorName']}, Specialty: {doc['Specialty']}")
        print(f"Description: {doc['DoctorDes']}")
        print("-" * 20)
