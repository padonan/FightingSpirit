import scrapy
from G_market.items import GMarketItem

class GmarketSpider(scrapy.Spider):
    #Spider 이름
    name = 'gmarket'

    #크롤링을 진행하게 될 사이트 URL
    start_urls = ['https://browse.gmarket.co.kr/search?keyword=%eb%85%b8%ed%8a%b8%eb%b6%81&s=8']

    def parse(self, response):
        
        #전역변수 설정
        global url
        
        #세부상품 URL 추출
        for i in range(1,101):

            # 세부사이트 URL
            URL = response.xpath(f'//*[@id="section__inner-content-body-container"]/div[2]/div[{i}]/div[1]/div[2]/div[1]/div[2]/span/a')
            
            div = response.xpath(f'//*[@id="section__inner-content-body-container"]/div[2]/div[{i}]')

            #URL이 빈칸이 아니라면 span 앞이 div[2]이다
            if (URL != []):
                
                href = div.xpath('./div[1]/div[2]/div[1]/div[2]/span/a/@href')

                url = response.urljoin(href[0].extract())
    
                yield scrapy.Request(url, callback = self.parse_page_content1)
            
            #URL이 빈칸이라면 span 앞이 div[1]이다
            if(URL == []):

                href = div.xpath('./div[1]/div[2]/div[1]/div[1]/span/a/@href')
                
                url = response.urljoin(href[0].extract())
                
                yield scrapy.Request(url, callback = self.parse_page_content2)

    
    def parse_page_content1(self, response):
        
        #item 호출
        item = GMarketItem()

        #str을 int형으로 변환
        Price_str = response.xpath('//*[@id="itemcase_basic"]/div/p/span/strong/text()')[0].extract()
        
        Price_Num = Price_str.split(',')
        
        Price_List = ''.join(Price_Num)
        
        Price = int(Price_List)

        #20만원 이상일 경우 PC 노트북임을 명시 
        if(Price >200000):

            item['Name'] = response.xpath('//*[@id="itemcase_basic"]/div/h1/text()')[0].extract()
            
            item['Price'] = Price_str
            
            item['Delivery_Charge'] = response.xpath('//*[@id="container"]/div[3]/div[2]/div[2]/ul/li[1]/div/div[2]/span/text()')[0].extract()
            
            item['URL'] = url 

        return item

    def parse_page_content2(self, response):

        item = GMarketItem()
        
        Price_str = response.xpath('//*[@id="itemcase_basic"]/div/p/span/strong/text()')[0].extract()
        
        Price_Num = Price_str.split(',')
        
        Price_List = ''.join(Price_Num)
        
        Price = int(Price_List)

        if(Price >200000):

            item['Name'] = response.xpath('//*[@id="itemcase_basic"]/div/h1/text()')[0].extract()
            
            item['Price'] = Price_str
            
            item['Delivery_Charge'] = response.xpath('//*[@id="container"]/div[3]/div[2]/div[2]/ul/li[1]/div/div[2]/span/text()')[0].extract()
            
            item['URL'] = url 

        return item






