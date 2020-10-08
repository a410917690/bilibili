==========视频=====================
获取所有视频    getAllVideos              返回：list<TVideos>
获取单个视频    getOneVideos(v_title)            tVideos对象


========用户=============
获取单个用户   login（username,password）    返回所查找用户         （Post）
获取所有用户   getAllConsumers       			           （Post）
获取用户角色   getRoleName（con_no）   返回String 用户角色       （Post）

注册用户      register（name,password,tel_num）  返回ture false


============标签==============
获取所有标签    getAllTag


==========管理员==============
获取一个管理员   getOneManager(name)    返回该管理员

===========直播间============
获取一个直播间   getOneRoom(room_title) 
获取所有直播间   getAllRoom

=========礼物===========
获取所有礼物  getAllGit      (按价格升序)

=========番剧============
获取单个番剧  getOneFan(fan_title)
获取所有番剧  getAllFan

============弹幕=============


