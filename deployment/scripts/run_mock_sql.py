import pymysql

# Database connection parameters
db_config = {
    "host": "211.87.236.76",
    "port": 3306,
    "user": "root",
    "password": "Z2A1GNca393kXPM7n98i",
    "database": "medical_mock",
    "charset": "utf8mb4"
}

print("Connecting to database...")
connection = pymysql.connect(**db_config)
cursor = connection.cursor()

print("Reading SQL file...")
with open(r'i:\inspur_mock_server\mockServer\generate_mock.sql', 'r', encoding='utf-8') as f:
    sql_script = f.read()

# Strip lines starting with --
clean_lines = []
for line in sql_script.split('\n'):
    if not line.strip().startswith('--'):
        clean_lines.append(line)

clean_script = '\n'.join(clean_lines)

# Execute SQL statements
statements = clean_script.split(';')
executed = 0
for statement in statements:
    cmd = statement.strip()
    if cmd:
        cursor.execute(cmd)
        executed += 1

connection.commit()
cursor.close()
connection.close()
print(f"Successfully executed {executed} statements to mock tables.")
