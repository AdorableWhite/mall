#### 1. 添加官方号为好友 API：

https://developers.line.biz/en/docs/line-login/link-a-bot/

bot_prompt = aggressive





#### 2. 消息发送 API

 https://developers.line.biz/en/docs/messaging-api/sending-messages/#push-messages

用 sent to a single user

notificationDisabled=false

订单状态改变为finish5需推送



{"message":"The request body has 1 error(s)","details":[{"message":"Must be one of the following values: [text, image, video, audio, location, 贴图 sticker,模板 template, imagemap, 弹性消息 flex]","property":"messages[1].type"}]}





推送消息失败重试(失败发起重试，间隔3分钟，重试3次)

https://developers.line.biz/en/docs/messaging-api/retrying-api-request/

注意点： 

- X-Line-Retry-Key  有效时长 24小时



消息发送开关 (状态改变可控)





#### 4. 内容样式 

https://developers.line.biz/en/reference/messaging-api/#buttons

- 内容中包含字段:实际支付费用、租借时长、开始时间+租借商户名称、结束时间+归还商户名称，如果电池未归还，则归还地点不显示。

- 文案和内容如下:

  ```
  Title:
  
  租借完成，订单已结束
  
  Text:
  
  费用:￥162
  
  时长: 26小时34分钟41秒
  
  
  
  开始:
  
  2020/07/14 11:00:20.上品快餐
  
  结束:
  
  2020/07/15 14:34:11. 上品快餐
  Button:
  查看详情

  ```

  
  
  

#### 6. 消息统计和预警

jwt

```json
privateKey
{
  "p": "_1Y8_9BPnmSZ3FhtNPCIQyR-lDEDE2d9h9mBP1m5I8V6ivi1r84jai4NyVlN3NfCUAGy5-oy_I44Ubk7QUaSKR3dISqvOAOKQDm5zo-o-QeNQaqS7lqk9QM4f6mNLjf1k8_X5IjPEmXxmoO4lWk1CYtiAekzHUX5RG5PFsThnhk",
  "kty": "RSA",
  "q": "tgwtuA9wlCLSJsg0brqcwAK3eymtJPvw7mUCuf_GHxYPafR2cURQ5ZGoXK10FXZe1WP061PlaQQSI6Gu-PjkimXfzOXPbW2qxmTAs6tFCLGAwzvbqt0iKKGTVVXQWGjjKbzmzki8rU0ZUVK4gIAve0GZKjSwcHnSnKmMZ-GaxFE",
  "d": "U-VrFhYFA1mOUVAXM6X5SZNIqXB8AIjfBcz7Eujj47YcU9H8TGcKilZSyj8w4p2QldW60PnQFDTh1jTAmnG2p4Un270xV9jLp3rTrmQmEFk7vAWya1mPkaLK_UjQ-FxHmBExxQ1ccIxWlztKAad4Veiy3r8QzJTNSpVdnolie1heEhIRBdU8lj5-li3hj4EUWnRkB-iLZMYFeswDEmGq9KchV8TUJn0H_9fe10L624ievYQg6tr9IoYyFmav50Dx5mv4MwIxgWnnNFqe-wxRiiC6i3thAYDIZ2MuR66DTIGcfPJdP74P2xM8rjWFep_sYlOxzyb0G9TgRG1hzz_jgQ",
  "e": "AQAB",
  "use": "sig",
  "kid": "f0036195-c3d3-4beb-ae00-d5a95310141b",
  "qi": "7l6z3j-lpNoGb8sWkqk1TkRypBVs4DjK9eIA37Nc5eGQRnvFQoYxLYkfuUZwz3P1ssWgcpSZjJwBEQBvvJ8M3U8acLBIt-LMMF03z-uClnCJx_B6zo3OsML8J5EX-1JnlelYR8eRFflUHwzppAyxleuq4RjjxW6E-ka5DoqL1XI",
  "dp": "L11S8W01577nn60zjNd1n2bcqCazWF0hNxsM07CUHGOciLz8DwGhJigm3IvZWrcXT3oRMt4J2TmUjuxaZpBtunzUsTtWx4A4nBNZOU0C3jcdZ-n5WYetA9o2F9Be5QzyXBn5BWavas1IVQ5MJkMe2Idnhc05cxuw0pXXy_R3mbk",
  "alg": "RS256",
  "dq": "pHmuWMyCTySCsA1T6fLqKkSKF1mZGIATtp9GblvbWTyqInV_CWjKmg8WiN0hsz5mAe-0WWVMMKw_4zdyCXl9qljOcaXz2Y8qquJehDWqQmd0yW9sURxHf2Qz4_aLLUVeb9g-w4NODFlLFYFiNp8ZxweGZW6DNquqEGbS9wwKs3E",
  "n": "tZN1AngxhODtnpyXkFBSgjcwz9iu-cKANFB1ASQY9jOfEG3WV1wMWs4JfYkTntT0A_E6R8fw5qvJ4sDuMn2noXslc3NDt9HWDYfcB4onLkN7UHhftbRtfcaADBIlDlcgx5eXBLxFAIFf_kHm7teUpN1WDNDhlmMu1teiFyw_yMZDMq-YUFhkeMEx2_ZbK0XHharMhtlnKNBfGonxCLcuAyoJNQRk3lpchaOOIcI1p79Z0F8DZbGYIa82Lq5S8060ugVezN-RpdIb7yNZa1Li9kYEQmdu-t9RuQPYrIV64rqimkmGlDJgbBz4AceGz0F-SOCX-TRPVsDl7nitHHgp6Q"
}


message channel :1654800078
header: 
{
  "alg": "RS256",
  "typ": "JWT",
  "kid": "f0036195-c3d3-4beb-ae00-d5a95310141b"
}

payLoad:
{
  "iss": "1654800078",
  "sub": "1654800078",
  "aud": "https://api.line.me/",
  "exp": 1600398463,
  "token_exp": 2592000
}
```





- 获取channelAccessToken

  https://developers.line.biz/en/reference/messaging-api/#oauth

- 获取当月消息余额（需设定目标限制）    https://developers.line.biz/en/reference/messaging-api/#get-quota

- 获取当月消息发送数量（获取的为近似值）     https://developers.line.biz/en/reference/messaging-api/#get-consumption

- 统计昨日的消息到达数(overview.delivered) 、 消息查看数(overview.uniquelmpression)、 消息点击数(overview.uniqueClick) ，

   https://developers.line.biz/en/reference/messaging-api/#get-message-event

   （接口或许不可用）

- 上午9点，发送消息到统计邮箱列表

  邮件标题： LINE 消息日报 0908

  内容：

  {month}月份消息余额：84848

  {month}月份消息发送数量：84848

  昨日消息到达数: 323

  昨日消息查看数: 234

  昨日消息点击数: 111

邮箱列表是否固定



curl -x socks5://127.0.0.1:1080 -X GET http://www.google.com

```sh
curl -x 127.0.0.1:1080 -k -X curl -X POST https://api.line.me/oauth2/v2.1/token -H 'Content-Type: application/x-www-form-urlencoded' --data-urlencode 'grant_type=client_credentials' --data-urlencode 'client_assertion_type=urn:ietf:params:oauth:client-assertion-type:jwt-bearer' --data-urlencode 'client_assertion=eyJhbGciOiJSUzI1NiIsImtpZCI6ImYwMDM2MTk1LWMzZDMtNGJlYi1hZTAwLWQ1YTk1MzEwMTQxYiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MDA2NTU5MjgsImlzcyI6IjE2NTQ4MDAwNzgiLCJzdWIiOiIxNjU0ODAwMDc4IiwiYXVkIjoiaHR0cHM6Ly9hcGkubGluZS5tZS8iLCJ0b2tlbl9leHAiOjg2NDAwfQ.dRcLJKkvTB4MDEaL5iEiLg9Svr43Pv88LVnyPsw70ev5wE1kYAWAFqc53RbmIV8XnQqWGe7GXBD6cOgrjkcYKOm1pxaVz4Wa01la8bXs5-YokCwOVzhCQM-2BrQW4aQ1ownG717YvwCNN7juB9N9s2EhYRGGnbDxl2ADHhsf3MnqVKH93TXcVGpQZYrqVMAkvi74m2gS9IJgrg1M1Wwxt3NXnom0UGMuMtbxux44zmXp2i2ErDfT-YqPsCNt7kRTP5yS7NhOaIy4BzpG7oUWNXx8E1R_0z7uF5MKj7QmX_AdCJQJ3DiqRUfx1StDVJHrlAYbLqDh_vu7KcTwZ820HA'
```

```java
{
    "access_token": "eyJhbGciOiJIUzI1NiJ9.m0FwZbT9MNPTf_ZP1gPHhiVWD3kGtOjihkjuyAN2s8pgj7bRxnAaAj0I-FThb4RmBokghllO6ldUqka_1Alh6obABGfotMTb6C6-7a5kk0_Y_viT6sont4gDgBLu1qfc.LMAOn2KblXgeP5Ad4WM3I7ugnTFz8haNGCnBhW7EQ9E",
    "token_type": "Bearer",
    "expires_in": 86400,
    "key_id": "oI5t5nVaspWA_OL_2sdX5w"
}
```

eyJhbGciOiJIUzI1NiJ9.1gXR6dKiklackMF4Ni3MutZxLMME9GC1Ok9TSBS9H_5RXYN40qaRAmYA9e54H21i2kQRg9THmaI1iCxlXXN3eJQwKuOrLydptkU0Dj_c2qMTHmIc8WHladEssyxoBNz3.6zP750XywGIhTo9W3tAakf0NfeqVrd6Z6leg8DuHB5s















