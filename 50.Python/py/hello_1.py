"""
리스트 자료형
    list : () 안에 원소를 순서대로 나열
"""

# 리스트 만들기
a = [1, 2, 3]
print(a)
print('type(a) >>> : ', type(a))

b = ['Life', 'is', 'too', 'short']
print(b)
print('type(b) >>> : ', type(b))

c = [1, 2, 'Life', 'is', 'too', 'short']
print(c)
print('type(c) >>> : ', type(c))

d = [1, 2, [3, 4], 'Life', 'is']
print(d)
print('type(d) >>> : ', type(d))

# 리스트 인덱싱
print(d[0])
print(d[2])
print(d[3])
print(d[3][-1])

# 리스트 슬라이싱
print(d[0:3])

# 리스트 연결 : +
print('a + b >>> : ', a + b)
print(b[0] + " hi~~~ ^^")
# print(a[0] + " hi~~~ ^^") # int + str 은 에러
'''
Traceback (most recent call last):
  File "C:/00.KOSMO93/50.Python/basic/py/hello_1.py", line 35, in <module>
    print(a[0] + " hi~~~ ^^")
TypeError: unsupported operand type(s) for +: 'int' and 'str'
'''

# 리스트 반복 : *
print(a * 3)

# 리스트 수정
a[2] = 99
print(a)

a[1:2] = ['a', 'b', 'c']
print(a)

a[-1] = ['d', 'e', 'f']
print(a)

# 삭제 : del
print(a)
del a[-1]
print(a)

# 원소 추가 : append()
a.append(5)
print(a)

# 원소 정렬 : short()
print(b)
b.sort()
print(b)

# 원소 순서 뒤집기 : reverse()
a = [3, 4, 1, 9]
a.reverse()
print(a)

# 원소 위치 확인 : index()
print(a.index(9))

# 원소 삽입 :  insert(index, x)
a.insert(0, 99)
print(a)

# 원소 삭제 : remove(x), pop(), pop(i)
a.remove(99)
print(a)

b = [1, 2, 3]
b.pop()
print(b)

b.pop(0)
print(b)

# 특정 원소값의 개수 : count(x)
a = [2, 1, 0, 2, 3, 2, 4,  2]
print(a.count(2))


"""
튜플 자료형
    tuple : () 안에 원소를 순서대로 나열, 원소값 변경 불가 
"""

# 튜플 만들기
t1 = (1,)
print(t1)
print('type(t1) >>> : ', type(t1))

t2 = (1, 2, 3)
print(t2)
print('type(t2) >>> : ', type(t2))

t3 = 1, 2, 3
print(t3)
print('type(t3) >>> : ', type(t3))

t4 = (1, 2, (3, 4), ('Life', 'is'))
print(t4)
print('type(t4) >>> : ', type(t4))

# 튜플 인덱싱
print(t4[0])
print(t4[3][-1])

# 튜플 슬라이싱
print(t4[0:3])

# 튜플 연결 : +
tt = t1 + t2
print(tt)

# print(t1 + "hi~~~ ^^")
'''
Traceback (most recent call last):
  File "C:/00.KOSMO93/50.Python/basic/py/hello_1.py", line 131, in <module>
    tt = t1 + "hi~~~ ^^"
TypeError: can only concatenate tuple (not "str") to tuple
'''

# 튜플 반복 : *
tt = t2 * 4
print(tt)

# 튜플 수정(불가능)
# t2[2] = 99
"""
Traceback (most recent call last):
  File "C:/00.KOSMO93/50.Python/basic/py/hello_1.py", line 144, in <module>
    t2[2] = 99
TypeError: 'tuple' object does not support item assignment
"""

"""
딕션너리 자료형 
    dictionary : {} 브레이스안에 key:value 
"""

# 딕셔너리 만들기
dic = {'name':'Hong', 'phone':'01012341234', 'birth':'0814'}
print(dic)
print('type(dic) >>> : ', type(dic))

# 원소 추가
dic[1] = 'a'
print(dic)

dic['pet'] = 'dog'
print(dic)

# 원소 삭제 : del
print(dic)
del dic[1]
print(dic)

# 원소의 value 구하기
print(dic['pet'])
print(dic['name'])

# key의 리스트 만들기 : keys()
dk = dic.keys()
print('dk >>> : ', dk)

dklist = list(dic.keys())
print('dklist >>> : ', dklist)

# value의 리스트 만들기 : values()
dv = dic.values()
print('dv >>> : ', dv)

dvlist = list(dic.values())
print('dvlist >>> : ', dvlist)

# key, value 쌍 구하기  : items()
di = dic.items()
print('di >>> : ', di)

# 원소 삭제 : clear()
dic.clear()
print('dic >>> : ', dic)


"""
집합 자료형 
    set: {} 안에 key 만 가지고 있는 형태    
    집합 자료형의 원소는 중복없이 유일해야 하고 
    원소들의 순서를 가지지 않기 때문에 인덱스를 사용할 수 없다.
    리스트나 문자열에 set() 함수(생성자)를 사용하면 집합 자료형을 만들수 있다. 
"""

# 집합 만들기
s1 = {1, 2, 'a', 5}
print("s1 >>> : ", s1)
print("type(s1) >>> : ", type(s1))

s2 = set([1, 2, 3, 4, 5, 6])
print("s2 >>> : ", s2)
print("type(s2) >>> : ", type(s2))

s3 = set([4, 5, 6, 7, 8, 9])
print("s3 >>> : ", s3)
print("type(s3) >>> : ", type(s3))

# 교집합 : & : intersection()
ss = s2 & s3
print("ss >>> : ", ss)

ss1 = s2.intersection(s3)
print("ss1 >>> : ", ss1)

# 합집합 : | : union()
ss = s2 | s3
print("ss >>> : ", ss)

ss1 = s2.union(s3)
print("ss1 >>> : ", ss1)

# 차집합 : - : difference()
ss = s2 - s3
print("ss >>> : ", ss)

ss1 = s2.difference(s3)
print("ss1 >>> : ", ss1)

ss2 = s3.difference(s2)
print("ss2 >>> : ", ss2)

# 원소 한개 추가 : add(x)
s11 = {1, 2, 3, 4}
print(s11)
s11 = s11.add(5)
print('s11 >>> : ', s11)

# 원소 여러 개 추가 : update()
print(s2)
s2.update([5, 6, 7, 8, 9, 10])
print(s2)

# 특정 원소 제거 : remove()
print(s2)
s2.remove(7)
print(s2)

