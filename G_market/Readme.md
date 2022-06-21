# **Scrapy 사용법**

<br/>

## **Scrapy 설치하기**

<br/>

터미널을 열어 Scrapy 설치를 진행한다. 설치를 진행하기 전 Linux에서 pip를 최신버전으로 업데이트를 진행해주자


```
# pip 업그레이드

pip install --upgrade pip

# Scrapy 설치

pip install scrapy

# Scrapy 버전확인

scrapy version
```

<br/>

## **1. Scrapy 시작하기**

<br/>

scrapy 설치 완료가 되었으면 본격적으로 프로젝트를 진행해봅시다. 진행해볼 프로젝트는 **<G마켓 키워드 - 노트북, 상품명, 가격, 배송료, 판매URL 크롤링 후 CSV 파일 저장>** 입니다.

<br/>

G마켓 노트북(판매인기순 정렬)

https://browse.gmarket.co.kr/search?keyword=%eb%85%b8%ed%8a%b8%eb%b6%81&s=8

해당 사이트의 세부상품정보 및 판매 사이트를 크롤링 해봅시다.

<br/>

## **2. Scrapy 프로젝트 생성**

<br/>

scrapy 프로젝트를 생성해보자. 프로젝트 생성방법은 **scrapy startproject [프로젝트명]** 명령어로 프로젝트를 생성할 수 있다

<br/>

```
scrapy startproject G_market
```

아래는 scrapy 프로젝트 구조이다. 프로젝트 생성후 spiders 폴더 안에 크롤링을 진행하게 될 spider 파일을 생성해야 된다. 잠시 구조를 보자면 items파일은 크롤링한 데이터를 정의할 수 있고 pipline은 크롤링한 데이터를 사후 처리하고 저장할 수 있다.

```
G_market
   ├── G_market
   │   ├── __init__.py
   │   ├── items.py
   │   ├── middlewares.py
   │   ├── pipelines.py
   │   ├── settings.py
   │   └── spiders
   │       └── __init__.py
   └── scrapy.cfg
```

<br/>

## **3. Spider 파일 생성**

<br/>

크롤링을 진행하게 될 spider 파일을 생성하자. spider 파일은 spiders 폴더안으로 이동해 다음 명령어로 파일을 생성해야 된다. **spider genspider [스파이더 이름] [크롤링URL]** 이때 url은 가급적 https:/를 빼고 붙여넣자. 왜냐하면 spider 파일이 https를 자동적으로 붙여주기 떄문이다.

<br/>

```
spider genspider gmarket browse.gmarket.co.kr/search?keyword=%eb%85%b8%ed%8a%b8%eb%b6%81&s=8
```

<br/>

## **4. Scrapy Shell 사용법**

<br/>

크롤링을 원하는 사이트에 개발자콘솔을 열어 추출을 원하는 부분의 html 파일의 xpath or css를 복사한다. 복사후 원하는 부분이 나오는지 테스트를 원할경우 터미널을 열어 **scrapy shell** 명령어로 scrapy shell을 열고 추출을 시도한 사이트의 url 주소를 **fetch('사이트 URL')** 명렁어로 연결을 시켜준 후 **response.xpath('복사한 xpath') 또는 response.css('복사한 css')** 명령어도 실행을 시키면 원하는 데이터 값이 나온다. 또한 scrapy shell은 python 문법이기에 테스트 코드를 입력하기 좋다. 

<br/>

```
#scrapy shell open
scrapy shell


#사이트 URL 연결

fetch('https://browse.gmarket.co.kr/search?keyword=%eb%85%b8%ed%8a%b8%eb%b6%81&s=8')

#xpath 사용

response.xpath('//*[@id="section__inner-content-body-container"]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/span/a')

#scrapy shell 빠져나오기

exit
```

<br/>

## **5. Scrapy robot.txt 무시하기**

<br/>

robots.txt는 웹사이트에 웹 크롤러같은 로봇들의 접근을 제어하기 위한 규약이다. 아직 권고안이라 꼭 지킬 의무는 없다. robot.txt를 무시하기 위해 settings 파일로 들어가 **ROBOTSTXT_OBEY = True부분을 ROBOTSTXT_OBEY = False**로 변경하자.

<br/>

## **6. Scrapy 실행하기**

<br/>

spider 파일에 코드를 다 작성했으면 spider 파일을 실행시켜보자 터미널에서 **scrapy crawl [스파이더 이름]** 명령어로 실행시킬 수 있다

<br/>

```
scrapy crawl gmarket
```

<br/>

## **7. LOG파일 생성하기**

<br/>

scrapy를 실행시킨다면 실행창에 log가 주르륵 나올거다. 이 로그들을 실행시킬 때 터미널에서 보이지 않고 하나의 파일안에 쌓이도록 하기 위해 log 파일을 생성하자. settings 파일안으로 들어가 **LOG_FILE = '[로그 파일 명].log'**를 추가하자 그럼 scrapy를 실행 시킬 때 로그들이 해당 파일에 저장이 된다. 만약 log파일 없이 log를 없애고 싶다면 scrapy 실행을 시킬 때  **--nolog** 를 붙여 실행하면 log 파일 생성 없이 log가 나오지 않는다

<br/>

```
#로그파일 생성

LOG_FILE = 'G_Market.log'

#로그파일 생성없이 로그 없애기

scrapy crawl gmarket --nolog
```

<br/>

## **8. 크롤링 데이터 CSV 파일에 저장하기**

<br/>

크롤링한 데이터를 CSV파일에 저장시키려면 scrapy를 실행할 때 **-o [csv 파일 명].csv**을 추가 해서 실행시키자 그럼 실행 값들이 csv파일로 저장이 된다.

<br/>

```
scrapy crawl gmarket -o G_market.csv 

#csv 파일 저장 + --nolog

scrapy crawl gmarket -o G_market.csv --nolog

```

<br/>

## **참고하면 좋은 사이트**

<br/>

[크롤링 방법 1](https://excelsior-cjh.tistory.com/entry/04-Scrapy%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EB%89%B4%EC%8A%A4%ED%81%AC%EB%A1%A4%EB%A7%81-%ED%95%98%EA%B8%B0)

[크롤링 방법 2](https://www.hanumoka.net/2020/07/07/python-20200707-python-scrapy-example/)

[크롤링 방법 3](https://pycoding.tistory.com/entry/scrapy%EC%8A%A4%ED%81%AC%EB%9E%98%ED%94%BC-%ED%81%AC%EB%A1%A4%EB%A7%81-%EC%8B%A4%EC%A0%84-csv-%EC%A0%80%EC%9E%A5%EA%B9%8C%EC%A7%80)

[Xpath 사용방법](https://nittaku.tistory.com/136)




