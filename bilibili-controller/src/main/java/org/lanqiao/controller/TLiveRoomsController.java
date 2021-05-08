package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.lanqiao.entity.TLiveRooms;
import org.lanqiao.entity.TVideos;
import org.lanqiao.service.TLiveRoomsService;
import org.lanqiao.util.result.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static org.lanqiao.util.result.ResultFactory.setResultError;
import static org.lanqiao.util.result.ResultFactory.setResultSuccess;

/**
 * 直播间(TLiveRooms)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:09
 */
@RestController
@CrossOrigin
public class TLiveRoomsController {
    /**
     * 服务对象
     */
    @Reference
    TLiveRoomsService tLiveRoomsService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @ResponseBody
    @GetMapping("Fan/getOneRoom")
    public Result selectOne(Integer room_no) {
        return setResultSuccess(tLiveRoomsService.queryById(room_no));
    }


    @ResponseBody
    @GetMapping("Fan/getAllRoom")
    public Result getAllRoomByPage(@RequestParam(defaultValue = "1") int page) {
        return setResultSuccess(tLiveRoomsService.queryAllByPage(page, 6));
    }

    @ApiOperation(value = "获取所有直播间信息")
    @ResponseBody
    @GetMapping("getAllLives")
    public Result getAllLives() {
        return setResultSuccess(tLiveRoomsService.getAllLives());
    }

    @ApiOperation(value = "主播下播（修改直播间状态为0）")
    @ResponseBody
    @GetMapping("closeLive")
    public Result closeLive(Integer room_no) {
        if (this.tLiveRoomsService.closeLive(room_no)) {
            return setResultSuccess();
        } else {
            return setResultError(500, "直播间无法关停");
        }
    }


    @ApiOperation(value = "主播开播")
    @ResponseBody
    @PostMapping("playLive")
    public Result playLive(@RequestParam("file") MultipartFile[] file, HttpServletRequest httpServletRequest)throws IOException {
        //多个文件
        if (file.length == 0) {
//            attributes.addFlashAttribute("msg", "上传的文件不能为空");
//            return "redirect:/files/fileAll";
            return setResultError(500,"上传文件为空");
        }

        //开Ftp通道
        Ftp ftp = new Ftp("49.234.77.189", 21, "13593568046", "123456");
        ftp.ftpLogin();
        TLiveRooms tLiveRooms = new TLiveRooms();
        for (MultipartFile multipartFile : file) {
            //获取原始文件名称
            String originalFilename = multipartFile.getOriginalFilename();
            //获取文件后缀名
            String extension = "." + FilenameUtils.getExtension(originalFilename);
            //获取新文件名称 命名：时间戳+UUID+后缀
            String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
                    + UUID.randomUUID().toString().substring(0, 4)
                    + extension;
            File file1 = new File(newFileName);
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file1);
            boolean b = ftp.uploadFile(file1, "/home/data/");
            if (file1.exists()) {
                boolean a = file1.delete();
            }
            //对象上传数据库
            if (extension.equals(".jpg") || extension.equals(".png")) {
                tLiveRooms.setRoom_pic("http://49.234.77.189:8080/video/" + file1.getName());
            }
//                int nameLength = multipartFile.getOriginalFilename().lastIndexOf('.');
//                String roomTitle = multipartFile.getOriginalFilename().substring(0,nameLength);
                String roomUrl = "";
                tLiveRooms.setRoom_url(roomUrl);
                String con = httpServletRequest.getParameter("con_no");
                String roomTitle = httpServletRequest.getParameter("room_title");
                String room_num = httpServletRequest.getParameter("room_num");
                tLiveRooms.setRoom_title(roomTitle);
                if(con==null || con.length()==0){
                    return (setResultError(500,"参数错误！"));
                }

                tLiveRooms.setCon_no(Integer.valueOf(con));
                tLiveRooms.setRoom_num(room_num);
//                tVideos.setCon_no(1);
                tLiveRooms.setRoom_is_legal(true);
                tLiveRooms.setIs_live(true);

        }
        tLiveRoomsService.insert(tLiveRooms);
        ftp.ftpLogOut();
        return setResultSuccess();
    }


}