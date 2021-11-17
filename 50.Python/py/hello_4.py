# 파일 객체 생성 : open()
f = open('C:/00.KOSMO93/50.Python/basic/py/test.txt', 'w')
print('f >>> : ', f)

# 파일 닫기 : close()
f.close()

# 파일 쓰기 : 파일모드 'w', write()
f = open('C:/00.KOSMO93/50.Python/basic/py/test.txt', 'w')
for i in range(1,6):
    data = "%d번째 줄 입니다. \n" %i
    f.write(data)
f.close()

#  파일에 내용 추가하기 : 파일모드 'a'
f = open('C:/00.KOSMO93/50.Python/basic/py/test.txt', 'a')
for i in range(6,11):
    data = "%d번째 줄 입니다. \n" %i
    f.write(data)
f.close()


# 파일 읽기 : 파일모드 'r', readline()
f = open('C:/00.KOSMO93/50.Python/basic/py/test.txt', 'r')
line = f.readline()
print('f.readline() >>> : ', line)
while True:
    line = f.readline()
    if not line: break
    print('f.readline() >>> : ', line)
f.close()

# 파일 읽기 : 파일모드 'r', readlines()
f = open('C:/00.KOSMO93/50.Python/basic/py/test.txt', 'r')
lines = f.readlines()
print('f.readlines() >>> : ', lines)
for line in lines:
    print('f.readlines() >>> : ', line)
f.close()

# 파일 읽기 : 파일모드 'r', read()
f = open('C:/00.KOSMO93/50.Python/basic/py/test.txt', 'r')
data = f.read()
print('data >>> : ', data)
f.close()

# 파일 처리후 파일 닫기(자동 처리) : with open() as 파일객체:
with open('C:/00.KOSMO93/50.Python/basic/py/test_1.txt', 'w') as f:
    f.write("Now is better than never.")

data = f.read()
print('data >>> : ', data)

