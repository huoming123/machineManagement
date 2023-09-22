# 基于JAVA机房管理系统  

#  接计算机毕业设计（代码注释详细+做完会录制视频讲解 需要加微信13650154582）  
#b站代码视频讲解地址链接：https://www.bilibili.com/video/BV1r14y1n7pv/?spm_id_from=333.337.search-card.all.click  
# 项目文件
![Image text](https://github.com/huoming123/machineManagement/blob/main/%E9%A1%B9%E7%9B%AE%E9%A1%B5%E9%9D%A2%E6%88%AA%E5%9B%BE/%E9%A1%B9%E7%9B%AE%E6%96%87%E4%BB%B6.png)  
# 项目功能  
![Image text](https://github.com/huoming123/machineManagement/blob/main/%E9%A1%B9%E7%9B%AE%E9%A1%B5%E9%9D%A2%E6%88%AA%E5%9B%BE/%E5%8A%9F%E8%83%BD%E5%9B%BE.png)  
本项目主要分为管理员跟教师两个角色;各个模块具体功能如下：  
（1）教师管理：管理员添加教师基本信息，这一功能是必要的，通过登记教师的基本信息，可以在关键时刻快速的查阅资料，找到教师人员。  
（2）课程管理：管理员录入课程信息，在排课表时可以选择课程进行课表录入。  
（3）课表管理：管理员在后台录入课表信息，教师登录成功之后可以查看课表信息。  
（4）机房管理：管理员录入各个机房的基本信息，比如机房号、房间容纳人数等信息。  
（5）维修管理：管理员查看教师提交的电脑维修申请，如果维修之后，管理员可以修改该维修单的维修状态。  
（6）个人中心：教师登录之后可以在个人中心查看个人信息以及修改密码。  
（7）机房借用申请：教师登录之后在机房管理模块选择机房号、申请理由以及申请的时间段，然后点击提交。  
（8）维修申请：教师在维修模块对有故障的电脑进行维修申请，输入机房号、电脑编号、电脑问题之后点击确定完成电脑维修申请。  
# 技术路线  
本系统采用IDEA,JAVA，MySQL等相关的数据库并采用SpringBoot+Vue前后端分离的框架对系统进行开发。研究B/S的基本架构，搭建好IDEA开发环境，基于win10操作系统来搭建服务器，根据系统设计文档进行编程开发。从而实现机房管理系统的主体功能。  

# 项目功能截图
![Image text](https://github.com/huoming123/machineManagement/blob/main/%E9%A1%B9%E7%9B%AE%E9%A1%B5%E9%9D%A2%E6%88%AA%E5%9B%BE/%E7%99%BB%E5%BD%95%E9%A1%B5%E9%9D%A2.png)  
![Image text](https://github.com/huoming123/machineManagement/blob/main/%E9%A1%B9%E7%9B%AE%E9%A1%B5%E9%9D%A2%E6%88%AA%E5%9B%BE/%E4%B8%AA%E4%BA%BA%E4%B8%AD%E5%BF%83.png)  
![Image text](https://github.com/huoming123/machineManagement/blob/main/%E9%A1%B9%E7%9B%AE%E9%A1%B5%E9%9D%A2%E6%88%AA%E5%9B%BE/%E6%95%99%E5%B8%88%E5%BD%95%E5%85%A5.png)  
![Image text](https://github.com/huoming123/machineManagement/blob/main/%E9%A1%B9%E7%9B%AE%E9%A1%B5%E9%9D%A2%E6%88%AA%E5%9B%BE/%E6%95%99%E5%B8%88%E6%9F%A5%E8%AF%A2.png)  
![Image text](https://github.com/huoming123/machineManagement/blob/main/%E9%A1%B9%E7%9B%AE%E9%A1%B5%E9%9D%A2%E6%88%AA%E5%9B%BE/%E6%9C%BA%E6%88%BF%E5%BD%95%E5%85%A5.png)  
![Image text](https://github.com/huoming123/machineManagement/blob/main/%E9%A1%B9%E7%9B%AE%E9%A1%B5%E9%9D%A2%E6%88%AA%E5%9B%BE/%E6%9C%BA%E6%88%BF%E7%94%B3%E8%AF%B7.png)  
![Image text](https://github.com/huoming123/machineManagement/blob/main/%E9%A1%B9%E7%9B%AE%E9%A1%B5%E9%9D%A2%E6%88%AA%E5%9B%BE/%E6%9C%BA%E6%88%BF%E5%AE%A1%E6%A0%B8.png)  
![Image text](https://github.com/huoming123/machineManagement/blob/main/%E9%A1%B9%E7%9B%AE%E9%A1%B5%E9%9D%A2%E6%88%AA%E5%9B%BE/%E8%AF%BE%E7%A8%8B%E5%BD%95%E5%85%A5.png)  
![Image text](https://github.com/huoming123/machineManagement/blob/main/%E9%A1%B9%E7%9B%AE%E9%A1%B5%E9%9D%A2%E6%88%AA%E5%9B%BE/%E8%AF%BE%E8%A1%A8%E5%BD%95%E5%85%A5.png)  
![Image text](https://github.com/huoming123/machineManagement/blob/main/%E9%A1%B9%E7%9B%AE%E9%A1%B5%E9%9D%A2%E6%88%AA%E5%9B%BE/%E8%AF%BE%E8%A1%A8%E6%9F%A5%E8%AF%A2.png)  
![Image text](https://github.com/huoming123/machineManagement/blob/main/%E9%A1%B9%E7%9B%AE%E9%A1%B5%E9%9D%A2%E6%88%AA%E5%9B%BE/%E7%BB%B4%E4%BF%AE%E7%94%B3%E8%AF%B7.png)  
![Image text](https://github.com/huoming123/machineManagement/blob/main/%E9%A1%B9%E7%9B%AE%E9%A1%B5%E9%9D%A2%E6%88%AA%E5%9B%BE/%E7%BB%B4%E4%BF%AE%E7%99%BB%E8%AE%B0.png)  
