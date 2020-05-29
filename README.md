# Totoro Ramen 

Totoro Ramen is a software of a selfservice mkiosk for a ramen restaurant in order to reduce the customers waiting.  
  
![ramen](https://github.com/kangkau/Totoro-Ramen/raw/master/img/ramen.jpg)


## Requirement - 需求
* Java 11 or above
* Eclipse



## Features - 特点
#### For customer
* order set meal of ramen
* customize ingredients based on your taste
* register to have loyalty service
* pay in diffrent ways
#### For administrator
* login & logout
* retrieve password
* modify the price of ingredients
* check ingredients inventories
* check sales in the past week


## Schedule - 时间表

```mermaid
gantt
  dateFormat YYYY-MM-DD
  section iteration1
  T1: 2020-03-23, 11d
  section iteration2
  T2: 2020-04-06, 11d
  section iteration3
  T3: 2020-04-20, 11d
  section iteration4
  T4: 2020-05-04, 11d
```

##  Architecture - 架构


```
graph TD
Group_98-->lib
Group_98-->src

lib-->jxl.jar
lib-->jfreechart.jar
lib-->jcommon.jar

src-->code
src-->img
src-->xls

code-->Startup.java
code-->...

xls-->inventory.xls
xls-->order.xls
xls-->user.xls

```
  


## Usage - 用法
**Startup** is a module that allows you to start using this software. To start the software, you only need to open this project in eclipse, enter the path *Group_98/src/code* and ++run++ this class.  


class | function
---|---
Startup     | initial menu to choose customer or administrator
Ramen     | the entity of set meal of ramen
AddRamen | customer's home menu
AddOn | customize ingredients of the meal
ModifyOrder | customers check shopping cart
UserRegister & UserPwdQuestion | register new member
UserLogin | members login
UserForgetPwd & UserReset | members reset their password based on security questions
Pay | check the total price
PayFinish | choose a way to pay
AdmForgetPwd & AdmReset | administrators reset their accounts
AdmFunction | administrators choose the function they want
AdmModify | administrators modify the price of ingredients and check inventories
BarChart | check sales in the past week
ExcelHandler | all the operations involves with excel




## Visuals - 视觉效果
![617a49513b4cbd3e65c6d4920155a55](1D6ECA80F422422DAA5A3074E9B40715)  

![167f6ae301898752040fd98ce559f71](AD00893391C94F1D90FBC8D2D6AC95DC)  

![4696d08d8ccd410ce5c58c0c8463e22](B45837932D194C99BBD7BB3FC6FE7829)  

![379805e54d2fd4665ccea9819ac4352](E93A0F730CF04EF081B763914772833D)  

![0f28566ccc3ecc0a21f3952addee271](B7C0C0A99BB740C3922A8923516BEDF3)


## Lisense - 开源协议
MIT
