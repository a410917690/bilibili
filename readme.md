==========视频=====================
获取所有视频    getAllVideos              返回：list<TVideos>     (Get)
获取单个视频    getOneVideos(v_no)            tVideos对象	(Get)
获取视频（通过标签 ）  getVideosByTag(page[可不写，默认为1],t_no)       返回：list<TVideos>    (Get)
修改视频      updateVideos（tVideos对象）     返回修改后tVideos对象     (post)
删除视频     deleteVideos（v_no）          （Post）
  

=====================用户=========================
获取单个用户   login（name）    返回所查找用户         （Post）
获取所有用户   getAllConsumers       			           （Post）
获取用户角色   getRoleName（con_no）   返回String 用户角色       （Post）
修改用户         updateConsumers(updateConsumers)     （post）
删除用户         deleteConsumers（con_no）           （Post）

注册用户      register（name，password,tel_num）     (Post)

============标签==============
获取所有标签    getAllTag


==========管理员==============
获取一个管理员   getOneManager(name)    返回该管理员       (Post)


===========直播间============
获取一个直播间   getOneRoom(room_no) 
获取所有直播间   getAllRoom

=========礼物===========
获取所有礼物  getAllGit      (按价格升序)

=========番剧============
获取单个番剧  getOneFan(fan_no)
获取所有番剧  getAllFan
获取番剧集数信息   getSeriesFan（page[可不写，默认为1]，fan_no）
修改番剧        updateFan(TFan)     (Post)
删除番剧       deleteFan(fan_no)     (Post)

修改番剧剧集     updateSeriesFan(TFanSeries) (Post)
删除番剧剧集     deleteSeriesFan(fan_series_no)  (Post)



============弹幕=============



===========评论===============
通过v_no获取评论      getCommentsByVno(page[可不写，默认参数为1],v_no)          返回list
添加评论       insertComment （tComments对象）   
删除评论      deleteComment  (v_no,con_no)

===========收藏==============



