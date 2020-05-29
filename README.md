# Totoro Ramen 

Totoro Ramen is a software of a selfservice mkiosk for a ramen restaurant in order to reduce the customers waiting.  
  
![ramen](https://github.com/kangkau/Totoro-Ramen/blob/master/img/ramen.jpg)


## Requirement 
* Java 11 or above
* Eclipse



## Features 
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


## Schedule 

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

##  Architecture 

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
  
## Usage 
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

## Visuals
![startup](https://github.com/kangkau/Totoro-Ramen/blob/master/img/startup.jpg)

![addramen](https://github.com/kangkau/Totoro-Ramen/blob/master/img/addramen.jpg)

![addon](https://github.com/kangkau/Totoro-Ramen/blob/master/img/addon.jpg)

![pay](https://github.com/kangkau/Totoro-Ramen/blob/master/img/pay.jpg)

![login](https://github.com/kangkau/Totoro-Ramen/blob/master/img/login.jpg)

![modify](https://github.com/kangkau/Totoro-Ramen/blob/master/img/modify.jpg)

![view](https://github.com/kangkau/Totoro-Ramen/blob/master/img/view.jpg)


## Lisense - 开源协议
MIT
