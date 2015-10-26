# CarManager 汽车4S店管理系统

1. 先将WebContent/doc/目录下的carmanager.sql数据导入到数据库中  
数据库的用户名密码在config目录下的config.properties中修  改，在jdbc.username,jdbc.password后面修改数据库的用户名和密码。  
默认数据库为MySQL。
     
2. mail.username="这里填写你邮箱的用户名，"mail.password="这里填写你邮箱的密码。  
填写完成后在用户注册时会自动向该用户填写的邮箱发送账户激活邮件  
mail.host 默认是腾讯QQ的邮箱服务器地址，邮件的模版在 WebContent/WEB-INF/vm/ 目录下。
     
3. 网站前台URL：**https://localhost:8443/CarManager**  
前台用户名：**admin**  密码：**123456**  用户名：**yuqirong**  密码：**yuqirong**  
网站后台URL：**https://localhost:8443/CarManager/admin**  
后台用户名：**admin**  密码：**123456**
     
4. 在使用UEditor时确保WebContent/ueditor/jsp/config.json中的 xxxUrlPrefix 为当前网站的URL，否则会出现图片无法上传等问题
     
5. 该网站许多功能尚未完成，敬请谅解。