print('hello 최현준 파이썬 책 읽으셔요 ~~~~')
print('이다희 파이썬 책 읽으세요 >>>> : ')

# 주석
''' 주석 '''
""" 주석 """
"""
파이썬 공부하기 
1. 파이썬은 스크립트 언어이다. 
2. 데이터 타입을 선언하지 않는다. 

변수 와 객체

자료형 
----------------
기본자료형
    숫자 : 정수, 실수, 복소수, 8진수, 16진수 
    논리 : True , False
문자열 자료형
    string : 한개 이상의 문자열 '', "", ''' ''', """ """
리스트 자료형 
    list : () 안에 원소를 순서대로 나열
튜플 자료형
    tuple : () 안에 원소를 순서대로 나열, 원소값 변경 불가 
딕션너리 자료형 
    dictionary : {} 브레이스안에 key:value 
집합 자료형 
    set: {} 안에 key 만 가지고 있는 형태     
"""

# 정수
a = 123
print(a)
print("정수 >>> : ",  type(a))

a = -123
print(a)

# 실수
a = 12.23
print(a)
print(type(a))
print("실수 >>> : ",  type(a))

# 8진수
'''
0 : 숫자 0
o : 알파벳 소문자 o, 대문자 O
'''
a = 0o12
print(a)
print("8진수 >>> : ",  type(a))

# 16진수
'''
0 : 숫자 0
x : 알파벳 소문자 x, 대문자 X
'''
a = 0x12A
print(a)
print("16진수 >>> : ",  type(a))

# 논리형
b = True
print(b)
print("논리형 >>> : ",  type(b))
b = False
print(b)
print("논리형 >>> : ",  type(b))

# 문자열
s1 = 'Hello Python'
print(s1)
print("문자열 >>> : ",  type(s1))

s1 = "Hello Python"
print(s1)
print("문자열 >>> : ",  type(s1))

s1 = '''Hello Python'''
print(s1)
print("문자열 >>> : ",  type(s1))

s1 = """Hello Python"""
print(s1)
print("문자열 >>> : ",  type(s1))

# 문자열 연결
head = "python"
tail = " is fun"
print(head + tail)

# 문자열 곱하기 
a = head * 2
print(a)
print("=" * 20)


'''
0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18  19  20  21  22  23
N  o  w     i  s     b  e  t  t   e   r       t   h   a   n       n   e   v   e   r
'''
# 문자열 인덱싱
a = "Now is better than never"
print(a[0])
print(a[4])
print(a[-1])
print(a[-2])

# 문자열 슬라이싱
b = a[0] + a[1] + a[2]
print(b)
print(a[0:3])
print(a[4:6])
print(a[19:])
print(a[:3])
print(a[:])
print(a[7:-11])

# 문자 갯수 계산 : count()
a = "Python"
b = a.count('p')
print('갯수 ', b)
b = a.count('P')
print('갯수 ', b)

# 문자열 위치 : find(), index()
b = a.find('y')
print('문자열 위치 ', b)
b = a.find('p')
print('문자열 위치 ', b)
b = a.index('y')
print('문자열 위치 ', b)

# b = a.index('p')
# print('문자열 위치 ', b)
"""
Traceback (most recent call last):
  File "C:/00.KOSMO93/50.Python/basic/py/hello.py", line 134, in <module>
    b = a.index('p')
ValueError: substring not found
"""

# 문자 삽입 : join()
b = ","
c = b.join('Abcd')
print('''b.join('Abcd') >>> : ''', c)

# 대문자 변환 : upper()
print(a)
print(a.upper())

# 소문자 변환 : lower()
print(a.lower())

# 공백 제거 : lstrip(), rstrip(), strip()
d = "    py     "
print('lstrip() >>> :', d.lstrip())
print('rstrip() >>> :', d.rstrip())
print('strip() >>> :', d.strip())

# 문자열 수정
a = "Pithon"
print(a[1])
# 문자열 수정 불가능 : immutablity
# a[1] = 'y'
# print(a[1])
"""
Traceback (most recent call last):
  File "C:/00.KOSMO93/50.Python/basic/py/hello.py", line 165, in <module>
    a[1] = 'y'
TypeError: 'str' object does not support item assignment
"""

# 문자열 바꾸기 : replase()
a = "Python is difficult."
print(a.replace("difficult", "funny"))

# 문자열 나누기 : split()
b = a.split()
print(b)

c = "a,b,c,d"
print(c.split(','))


