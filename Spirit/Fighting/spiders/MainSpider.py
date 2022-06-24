import scrapy

Associate_Degree = '4' # 2~3년제
Bachelor_Degree = '5' # 4년제
Master_Degree = '6' # 석사
Doctor_Degree = '7' # 박사
HighSchool_Degree = '3' # 고졸
NO_CARE_Degree = '0' # 학력무관

KEYWORD = input('찾고 싶은 키워드를 입력해주세요 (키워드는 띄어쓰기로 구분 됩니다) : ')
INPUTKEYWORD = ''.join(KEYWORD)
CARRER = '&careerType=2' + '&careerMin=' + input('요구경력최소:') + '&careerMax=' + input('요구경력최대:')
INPUTCARRER = ''.join(CARRER)
EDU = '&edu=' + input('학력입력 (3)고졸 (4)전문대 (5)4년제 (6)석사 (7)박사 (0)학력무관 : ')
INPUTEDU = ''.join(EDU)
PAY = '&payType=1' + '&payMin=' + input('원하는 최소연봉:') + '&payMax=' + input('원하는 최대연봉:')
INPUTPAY = ''.join(PAY)

class MainSpider(scrapy.Spider):
    name = 'MainSpider'

    start_urls = ['https://www.jobkorea.co.kr/Search/?stext=' + INPUTKEYWORD + INPUTCARRER + INPUTEDU + INPUTPAY]

    def parse(self, response):
        print(response)
