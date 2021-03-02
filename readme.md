t-collections-controller

POST
/deleteCollections
deleteCollections
GET
/getCollections
getCollections
POST
/insertCollections
insertCollections
POST
/isCollections
isCollections
t-com-comment-controller

POST
/getComNo
得到评论编号
POST
/getComReply
获取对评论的回复集合
POST
/insertComReply
对评论进行回复
t-comments-controller

POST
/deleteComment
deleteComment
POST
/getCommentsByVno
queryAllByVno
POST
/insertComment
insertComment
t-con-v-likes-controller

POST
/isLike
likeVideo
t-consumers-controller

POST
/conReport
用户举报
POST
/conToIllegal
用户账号异常
POST
/decrMemberDeadline
会员到期检测
POST
/deleteConsumers
通过用户id删除用户
POST
/Fan/register
验证码注册
POST
/findPwd
通过用户名获取密码<验证码验证>
POST
/getAllConsumers
获取所有用户
POST
/getConByToken
通过token获取用户信息
POST
/getConsumersByName
通过<唯一字段>用户名获取用户信息
POST
/getConsumersByNo
通过用户id获取用户信息
GET
/getPhoto
通过用户id获取用户头像
POST
/getRoleName
通过用户id获取角色名称
POST
/login
账号密码登录
POST
/loginByMail
验证码登录
POST
/send
发送验证码
POST
/updateConsumers
修改用户信息
POST
/updateDetail
修改用户信息
POST
/updatePwd
更新密码
POST
/uploadPic
上传图片
t-dan-mu-controller

GET
/Fan/getDanMu
getDanMu
POST
/insertDanMu
insertDanMu
t-fan-controller

POST
/deleteFan
deleteFan
GET
/Fan/getAllFan
queryAllFanByPage
GET
/Fan/getOneFan
selectOne
POST
/updateFan
updateFan
t-fan-series-controller

POST
/deleteSeriesFan
deleteSeriesFan
GET
/Fan/getOneSeriesFan
getOneSeriesFan
GET
/Fan/getSeriesFan
querySeries
POST
/updateSeriesFan
updateSeriesFan
t-focus-controller

POST
/addFocus
关注
POST
/deleteFocus
取消关注
POST
/getAllFocusConsumerByCon
获取所有关注用户
POST
/getFocus
获取指定的关注用户信息
GET
/getNumBF
获取被关注数
GET
/getNumF
获取关注数
GET
/getNumL
获取被点赞数
t-gift-controller

GET
/Fan/getAllGit
queryAll
t-history-controller

POST
/deleteHistory
deleteHistory
POST
/insertHistory
insertHistory
t-history-vo-controller

POST
/getHistory
getHistory
t-items-controller

POST
/getAllItems
queryAll
POST
/getItemMoney
queryMoney
POST
/getItemName
queryName
T Live Rooms Controller

GET
/Fan/getAllRoom
getAllRoomByPage
GET
/Fan/getOneRoom
selectOne
T Orders Controller

POST
/deleteOrders
生成订单
POST
/getAllOrders
queryAll
POST
/insertOrder
生成订单
POST
/queryOrder
通过订单号查询订单
GET
/secKill
秒杀
HEAD
/secKill
秒杀
POST
/secKill
秒杀
PUT
/secKill
秒杀
DELETE
/secKill
秒杀
OPTIONS
/secKill
秒杀
PATCH
/secKill
秒杀
POST
/setSecKill
开始秒杀活动
POST
/updateOrder
修改订单
t-tag-controller
T Tag Controller

GET
/Fan/getAllTag
getAllTag
t-videos-controller

POST
/deleteVideos
delete
GET
/Fan/getAllVideos
getAllVideosByPage
GET
/Fan/getOneVideos
selectOne
GET
/Fan/getVideosByTag
getVideosByTag
POST
/getLikesNum
giveLikesNum
POST
/giveLike
giveLike
POST
/updateVideos
update
Update Coins Controller

POST
/giveCoins
投币接口