# 押品动态监控管理系统

[TOC]

## 用例描述

[大宗商品](http://index.mysteel.com/xpic/detail.ms?tabName=pugang)：商用油、钢材、铜材、棉花等

一个企业一个监管人员的号



### 监管机构

查看竞价邀请通知、报价

查看出质通知单、反馈仓单和回执（生成公司账号）；查看结清通知书、确认（删除公司账号）

查看盘货核对报告、 如有问题则需要反馈调查原因

查看台账和月报告（监管机构名下所有；按公司账号、时间等）

修改公司账号的密码、查看登录状态

查看、发送预警信息



### 监管员

每天提交台账（备注）；查看台账和月报告（名下所有；按时间等）

查看进货通知书、反馈确认进货；

查看出货通知书、反馈确认出货；

> 每月底自动生成月报表



### 客户经理

录入押品信息（根据合同号）、提交审核申请

提交出货通知书、进货通知书的审核申请

提交月盘货报告的审核申请

修改押品状态、录入押品处置结果（变现价）；提交审核申请

查看申请的退回意见、删除或重新提交申请

查看台账、月报告和核对报告（自己名下、按公司、时间等）

查看、发送预警信息



### 公司部主管

复核申请、同意或反馈退回意见

查看台账、月报告和核对报告（自己名下、按公司、时间、客户经理等）

查看、发送预警信息

统计分析：

- 客户经理业绩（奖金分配依据、排名）、客户公司

  ​

### 授信执行部

查看台账、月报告和核对报告（全辖范围内、按监管机构、客户公司、时间、客户经理、存货种类等）

查看、发送预警信息

统计分析：

- 监管机构评分（核对误差率、反馈间隔时间）

- 存货类别推荐（价格走势、跌价预警次数、波动幅度）

- 存货类别的质押率推荐

- 警戒线推荐（存货类别和客户信用）

- 客户经理培训（各支行的业务量、业务种类等）

  ​

### 系统管理员

管理客户、权限、组织结构、日志、监管机构、押品等

设置参数：警戒线（价值、数量）、质押率、时限、监管最高费用等



### 系统自动

自动更新大宗商品价格（爬虫）--> 发出预警

根据台账自动生成月报表 --> 与盘货报告核对



## DB

### √→ 机构st_organization

机构id、  `auto`

name   

级别（总行、分行、支行）

地址address、电话phone

上级机构id   `organization表`

负责人id        `staff表`

备注note



### √→ 部门st_department

部门id、  `auto`

部门名称、

银行机构id      `organization表`

负责人id          `staff表`

备注



### √→ 员工ex_staff

工号id、(入职年月+计数)

name、

身份证号id_card、

联系方式telephone、

入职时间hire_date、

职级、

职位(行政级别)post、

部门id、      `department表`

备注note（档案记录id）



### √→ 企业客户 ex_company

企业id、`auto`

name、

类别、

地址address、联系人contact、电话telephone、

评分score、

备注note



### √→ 合同表ex_contract

合同id、 

合同类型type、

企业客户company_id、    `company表`

客户经理account_manager_id、协办co_manager_id、    `staff表`

起始日期from_date、截止日期to_date、

贷款价值loan、

状态status、

备注note



### √→ 存货gage

存货id、  `auto`

name、类别、

最高质押率max_pledge_rate、

警戒线warning_line、

处置线dispose_line、

备注



### √→ 存货单价（爬虫）gage_price

id、  `auto`

存货id、  `gage表`

单价、单位、

更新时间、

来源、

备注



### √→ 合同—存货contract_gage

id、    `auto`

合同id、   `contract表`

公司id（合同表的公司属性）、      `company表`

存货id、       `gage表`

数量quantity、 

规格specifications、

状态、（入库待复核，已入库，出库待复核，已出库）

备注



### √→ 用户user

用户id， `auto`

用户名name、  （员工s+id，监管机构r+id，监管员=客户企业c+id）

角色role_id、    `role表`

密码password，

电话telephone，

注册时间register_time，

登录状态status，

上一次登录时间last_login_time，

上一次修改密码时间last_change_time，

备注note



### √→ 监管公司regulators

监管公司ID、

name、

地址address、联系人contact、电话telephone、邮箱email

评分（误差率）、

备注



### √→ 监管公司（监管员）—企业客户regulators_company

监管员账号（企业id+监管公司id+开始时间，自动加到user表，密码为监管公司密码，角色为监管员）regulator_uid、

企业客户id、  ` company表`

监管公司id、    `regulators表`

开始时间from_date、到期时间to_date、

监管费（百分比）fee、

状态、

备注



### √→ 仓单（月报告、盘货报告）warehouse_list

id、  `auto`

*公司id*、    `company表`   

*存货id*、    `gage表`

数量quantity、

规格specification、

*权属owner*、（银行还是自己公司）

记录时间timestamp、

提交人id（监管员id或者客户经理id）submitter_id、    `user表`或者是null（系统自动生成）

备注



### √→ 监管台账 regulate_account

台账id、       `auto`

公司id、    `company表`

存货id、     `gage表`

出入货数量(正负)quantity、 

时间、 

备注



### 日志log

ID、  `auto`

操作、

描述、

> 合同ID、  

操作人ID、  `user表`

操作时间、

备注



### ？√ 邮件mail

邮件id、  `auto`

标题、描述、

发件人id、             `user表`

收件人id（;分隔，varchar）、 `user表`

发送时间、

紧急程度urgency、

类别(预警、普通)、

状态、

备注



### √→ 预警warning

id、 `auto`

company_id、  `company表`

> gage_id、（不填表明是整个公司）、  `gage表`

type（数量、价值、监管预警）、

发出人id、（不填表明是系统自动发起） `user表`

严重程度、

发送范围、

状态（未处理、处理中、已处理）

受理人id、  `user表`

备注



> 比对报告结果：比对日期、监管公司id、企业公司id、核对错误总数、备注

> 竞价记录：合同id、监管公司id（中标）、出价（中标）、监管公司id、出价、监管公司id、出价、竞价时间



### 抵押品处置

记录id、企业ID，存货ID，数量、规格、处置方式、成交价格、处置时间，处置原因，回收款项、备注



### √= 角色_role

id、`auto`

角色名称、

功能模块（导航栏展示功能）



### △√ 功能模块_view

id   `auto`

name

parent_name

level

url



### △√ role_view

id、 `auto`

*role_id*

*view_id*



### √→ 系统配置_config

id、  `auto`

key、value



### notice 通知

id,

type  ——出入库、出质通知、结清

gage_id

amount

监管机构id

客户经理id

主管id

状态   ——待审批、待确认、已确认、已执行

timestamp

check_time 监管公司确认时间

note




## model

### → 用户User

？int id， `auto`

name、  （员工s+id，监管机构r+id，监管员=客户企业c+id）

role、    （enum直接映射为int型）

密码password，电话telephone，

注册时间registerTime，

登录状态int status，(0-未登录；1-登录；-1无效)

上一次登录时间lastLoginTime，上一次修改密码时间lastChangeTime，

备注note、

***receiveWarnings***

***sendWarnings***

***handleWarnings***



### → 系统配置Config--AdminService

id、  `auto`

name、value



### → 企业客户 Company

？企业id、  `auto`

name、

？类别int type、（enum，产业分类：A—农、牧、林、渔业，B—采矿和采石，C—制造业，D—电、煤气、蒸气和空调供应，等等）

地址address、联系人contact、电话telephone、

评分score、

备注note

***contracts***



### → 存货Gage

？存货id、  `auto`

name、

？类别int type、 （enum）

最高质押率max_pledge_rate、

警戒线warning_line、

处置线dispose_line、

备注



### → 预警Warning

id、 `auto`

**company**--无（单向）、 

type预警类型、 (enum:0其他、 1数量、2价值、3监管预警)

发出人**sender**--User、（不填表明是系统自动发起）

？严重程度、（）

> ？发送范围sendRange、（）

？状态int status、（enum：0未处理、1处理中、2已处理）

受理人**handler**--User、 

备注

***reveivers***(多对多，warning_user表，映射User的receivelist)



**Warning_User**

warning_id,

user_id



### → 机构Organization

？机构id、  `auto` 

name   、

级别level（总行、分行、支行）

地址address、电话phone

上级机构Organization **parentOrg**--无（单向）、（null则为总行）

备注note

*text，tags* （不映射数据库，treeview属性）

***nodes***(子机构列表)



### → 部门Department

部门id、  `auto`

部门名称、

银行机构**organization**--无（单向）

备注



### → 员工Staff

工号id、(入职年月201601+计数000+毫秒0)

name、身份证号id_card、联系方式telephone、

入职时间hireDate、

职级level、职位(行政级别)post、

部门**department**--无（单向）、     

备注note（档案记录id）

***contracts***

***coContracts***



### → 存货单价（爬虫）gage_price--GageService

id、  `auto`

**gage**

单价、单位、

更新时间、

来源、

备注



### → 合同表ex_contract

合同id、 

？合同类型type、

企业客户**company**--Company

客户经理**accountManager**--Staff、

协办**coManager**--Staff、

起始日期from_date、截止日期to_date、

贷款价值loan、

？状态status、（0进行中，-1已结清，1逾期未结清，2处置中，3已处置）

备注note

***contractGages***



### → 合同—存货contract_gage--ContractService

id、    `auto`

合同**contract**--Contract

存货**gage**--无

数量quantity、 规格specifications、

状态、（1入库待复核，2已入库，-1出库待复核，-2已出库）

备注



### → 监管公司regulators

监管公司ID、`auto`

name、

地址address、联系人contact、电话telephone、邮箱email

评分（误差率）、

备注

***companies***



### → 监管公司（监管员）—企业客户regulators_company--regulatorsService

监管员账号（“1” + 企业id+监管公司id+“0”，自动加到user表，密码为监管公司密码，角色为监管员）id、

企业客户**company**--无

监管公司**regulators**--Regulators

开始时间from_date、到期时间to_date、

监管费（百分比）fee、

状态、（进行中，未开始，已结束）

备注

***regulateAccounts***



### → 监管台账 regulate_account--regulatorsService

台账id、       `auto`

监管员**regulator**-- `regulators_company表`

存货**gage**--无

出入货数量(正负)quantity、 

时间、 

备注



### → 仓单（月报告、盘货报告）warehouse_list

id、  `auto`

公司**company**

存货**gage**

数量quantity、

规格specification、

*权属owner*、（0银行，1自己公司，其他-1）

记录时间timestamp、

提交人（监管员id或者客户经理id）**submitter**、    `user表`或者是null（系统自动生成）

备注

