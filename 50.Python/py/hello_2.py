# 비교 연산자 : ==, !=, >, <, >=, <=
x = 3
y = 2

z = x == y
print('z >>> : ', z)

z = x != y
print('z >>> : ', z)

z = x >= y
print('z >>> : ', z)

# 조건 연산자 : and, or, not
money = 1300
if money >= 1200 and money < 3500:
    print('버스를 탈 수 있습니다.')

# 그룹 자료형의 원소인지 검사하기 : x in 리스트, x in 튜플, x in 문자열
z = 1 in [1, 2, 3]
print('z >>> : ', z)

z = x in [1, 2, 3]
print('z >>> : ', z)

z = x not in [1, 2, 3]
print('z >>> : ', z)

z = 'a' in ('a', 'b',  'c', 'd')
print('z >>> : ', z)

z = 'i' not in 'Python'
print('z >>> : ', z)

# 아무것도 하지 않게 설저 : pass
if money < 10:
    pass
else:
    print('저금하자!!!')



# for
'''
for 반복변수 in 리스트|튜플|문자열:
    실행할 명령문1
    실행할 명령문2

number = 0    
print( %number )    
% 기호를 활용하여 변수값을 출력할 수 있다.
(%d 정수, %f 실수, %s 문자열)
%5.2f처럼 출력하는 모양을 지정할 수 있다. (총 자릿수 5, 소수점 2자리까지)
    
'''
test_list = ['one', 'two','three']
for i in test_list:
    x = i + 'i'
    print(x)

number = 0
for score in [90, 25, 67, 45, 93]:
    number += 1
    if score >= 60:
        print('%d번 학생은 합격입니다 ' %number)
    else:
        print('%d번 학생은 불합격입니다 ' %number)

# while
'''
while 조건식:
    실행할 명령문1
    실행할 명려문2
'''
i = 0
while i < 5:
    i += 1
    print('*' * i)

