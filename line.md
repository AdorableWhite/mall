#### 1. 添加官方号为好友 API：

https://developers.line.biz/en/docs/line-login/link-a-bot/

bot_prompt = aggressive



#### 2. 消息发送 API

 https://developers.line.biz/en/docs/messaging-api/sending-messages/#push-messages

用 sent to a single user

订单状态改变为finish5需推送



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
  
  ```

  

  

#### 6. 消息统计和预警

- 获取当月消息余额    https://developers.line.biz/en/reference/messaging-api/#get-quota

- 获取当月消息发送数量     https://developers.line.biz/en/reference/messaging-api/#get-consumption

- 统计昨日的消息到达数(overview.delivered) 、 消息查看数(overview.uniquelmpression)、 消息点击数(overview.uniqueClick) ，

   https://developers.ine.biz/en/reference/messaging-api/#get-message-event

- 上午9点，发送消息到统计邮箱列表

  邮件标题： LINE 消息日报 0908

  内容：

  {month}月份消息余额：84848

  {month}月份消息发送数量：84848

  昨日消息到达数: 323

  昨日消息查看数: 234

  昨日消息点击数: 111

