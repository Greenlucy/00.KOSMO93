# 함수
'''
인수 개수삭 정해진 경우
def 함수(인수):
    명령문 1
    명령문 2

인수 개수삭 정해지지 않은 경우
def 함수명(*인수):
    명령문 1
    명령문 2
'''

# 함수 정의


def sum1(a, b):
    x = a + b
    return x


def sum2(*args):
    x = 0
    for i in args:
        x += i
    return x



# 함수 호출 : 함수명(인수 )
a = 5
b = 3

x = sum1(a, b)
print('x >>> : ', x)

x = sum1(3, 5)
print('x >>> : ', x)

x = sum2(1, 2, 3, 4, 5)
print('x >>> : ', x)

x = sum2(2, 3.5, 10)
print('x >>> : ', x)


# 내장함수
z = chr(97)
print('z >>> : ', z)
z = chr(48)
print('z >>> : ', z)

z = ord('a')
print('z >>> : ', z)
z = ord('0')
print('z >>> : ', z)

z = oct(8)
print('z >>> : ', z)
z = oct(234)
print('z >>> : ', z)

z = hex(16)
print('z >>> : ', z)
z = hex(234)
print('z >>> : ', z)

a = 3
z = id(a)
print('z >>> : ', z)

z = int('3')
print('z >>> : ', z)
z = str(3)
print('z >>> : ', z)

z = list('Python')
print('z >>> : ', z)
z = list((1, 2, 3))
print('z >>> : ', z)

z = tuple('Python')
print('z >>> : ', z)
z = tuple([1, 2, 3])
print('z >>> : ', z)

sum = lambda a,b: a+b
print('sum >>> : ', sum)
print('sum(3, 5) >>> : ', sum(3, 5))

z = (lambda a,b: a+b)(10, 20)
print('z >>> : ', z)

z = max('Python')
print('z >>> : ', z)
z = max([1, 2, 3])
print('z >>> : ', z)

z = min('Python')
print('z >>> : ', z)
z = min([1, 2, 3])
print('z >>> : ', z)


# c = input()
# c = input('정수를 입력하시오: ')
# print('c >>> : ', c)

z = range(5)
print('z >>> : ', z)

z = list(range(5))
print('z >>> : ', z)

z = list(range(5, 10))
print('z >>> : ', z)

z = list(range(5, 10, 2))
print('z >>> : ', z)

z = list(range(5, 10, 3))
print('z >>> : ', z)

z = len('Python')
print('z >>> : ', z)

s = 'Python is  hell  '
z = len(s)
print('z >>> : ', z)

z = sorted([3, 0, 2, 1])
print('z >>> : ', z)

z = sorted('Python')
print('z >>> : ', z)


'''
모듈 module 
    함수나 변수 또는 객체를 정의하는 클래스를 모아놓은 파일
패키지 package 
    모듈을 모아놓은 디렉토리 
파이썬에서 기본으로 제공하는 내장함수 외에 추가 기능을 위한 함수나 변수, 클래스는 
모듈이나 패키지로 제공되므로 필요한 것은 다운로드한 뒤 임포트 import해서 사용한다.         
'''

import urllib.request
z = urllib.request.Request('http://www.naver.com')
print('z >>> : ', z)

from datetime import datetime
z = datetime.now()
print('z >>> : ', z)