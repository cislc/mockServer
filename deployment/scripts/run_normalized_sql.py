import pymysql
from pymysql.constants import CLIENT

db_config = {
    "host": "211.87.236.76",
    "port": 3306,
    "user": "root",
    "password": "Z2A1GNca393kXPM7n98i",
    "charset": "utf8mb4",
    "client_flag": CLIENT.MULTI_STATEMENTS
}

# Connect without database first, in case it doesn't exist
print("Connecting to MySQL...")
conn = pymysql.connect(**db_config)
cursor = conn.cursor()

print("Executing SQL file...")
with open(r'i:\inspur_mock_server\mockServer\deployment\db\medical_mock_init.sql', 'r', encoding='utf-8') as f:
    # Read everything
    sql = f.read()

cursor.execute(sql)
conn.commit()

cursor.close()
conn.close()
print("Successfully loaded normalized SQL schema and mock data.")
