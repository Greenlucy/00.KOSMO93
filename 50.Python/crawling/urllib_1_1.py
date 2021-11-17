import urllib.request

url="http://192.168.219.112:8088/springHbe/img/img_mandu/ase.gif"
savename="./data/ase.gif"
urllib.request.urlretrieve(url, savename)
print("저장되었습니다......")