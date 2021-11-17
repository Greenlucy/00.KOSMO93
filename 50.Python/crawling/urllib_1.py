import urllib.request

url="http://uta.pw/shodou/img/28/214.png"
savename="./data/test.png"
urllib.request.urlretrieve(url, savename)
print("저장되었습니다......")