package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.lanqiao.entity.TVideos;
import org.lanqiao.service.TConVLikesService;
import org.lanqiao.service.TVideosService;
import org.lanqiao.util.RedisUtil;
import org.lanqiao.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


import java.util.concurrent.TimeUnit;

import static org.lanqiao.util.result.ResultFactory.setResultError;
import static org.lanqiao.util.result.ResultFactory.setResultSuccess;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 视频(TVideos)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:09
 */
@Controller
@CrossOrigin
public class TVideosController {
    /**
     * 服务对象
     */
    @Reference
    TVideosService tVideosService;

    @Reference
    TConVLikesService tConVLikesService;

//    @Resource
//    TVideos tVideos;

    @Autowired
    RedisUtil redisUtil;


    /**
     * 获取单个视频信息
     *
     * @return 单条数据
     */
    @ApiOperation(value = "获取单个视频信息")
    @ResponseBody
    @GetMapping("getOneVideos")
    public Result selectOne(Integer v_no) {
        return setResultSuccess(tVideosService.queryById(v_no));
    }


    /**
     * 获取所有视频
     *
     * @param page
     * @return
     */
    @ApiOperation(value = "获取所有视频")
    @ResponseBody
    @GetMapping("getAllVideos")
    public Result getAllVideosByPage(@RequestParam(defaultValue = "1") int page) {
        return setResultSuccess(tVideosService.getAllVideosByPage(page, 7));
    }


    /**
     * 获取所有视频（不分页）
     */
    @ApiOperation(value = "获取所有视频（不分页）")
    @ResponseBody
    @GetMapping("getAllVideosNotPage")
    public Result getAllVideosNotPage(){
        return setResultSuccess(tVideosService.getAllVideosNotPage());
    }


    /**
     * 模糊查找视频结果
     */
    @ApiOperation(value = "搜索视频")
    @ResponseBody
    @PostMapping("serchVideos")
    public Result serchVideos(String v_title){
        return setResultSuccess(tVideosService.serchVideos(v_title));
    }

    /**
     * 通过标签获取其下的所有视频
     *
     * @param page
     * @param t_no
     * @return
     */
    @ApiOperation(value = "通过标签获取其下的所有视频")
    @ResponseBody
    @GetMapping("getVideosByTag")
    public Result getVideosByTag(@RequestParam(defaultValue = "1") int page, int t_no) {
        return setResultSuccess(tVideosService.getVideosByTag(page, 6, t_no));
    }


    /**
     * 通过标签获取其下所有视频（不分页）
     */
    @ApiOperation(value = "通过标签获取其下的所有视频(不分页)")
    @ResponseBody
    @GetMapping("getVideosByTagNotPage")
    public Result getVideosByTag(Integer t_no) {
        return setResultSuccess(tVideosService.getVideosByTagNotPage(t_no));
    }

    /**
     * 获取用户投稿的视频
     */
    @ApiOperation(value = "通过con_no 获取用户投稿的所有视频")
    @ResponseBody
    @GetMapping("getListByConNo")
    public Result getListByConNo(Integer con_no){
        return setResultSuccess(tVideosService.getListByConNo(con_no));
    }


    /**
     * 修改视频信息
     *
     * @param tVideos
     * @return
     */
    @ApiOperation(value = "修改视频信息")
    @ResponseBody
    @PostMapping("updateVideos")
    public Result update(TVideos tVideos) {
        return setResultSuccess(tVideosService.update(tVideos));
    }

    /**
     * 删除视频
     *
     * @param v_no
     * @return
     */
    @ApiOperation(value = "删除视频")
    @ResponseBody
    @PostMapping("deleteVideos")
    public Result delete(Integer v_no) {
        return setResultSuccess(tVideosService.deleteById(v_no));
    }

    /**
     * 给视频点赞
     *
     * @param con_no
     * @param v_no
     * @return
     */
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @ApiOperation("点赞视频")
    @ResponseBody
    @PostMapping("giveLike")
    public Result giveLike(@RequestParam("con_no") Integer con_no, @RequestParam("v_no") Integer v_no) {

//        boolean flag = tConVLikesService.queryByVnoCno(con_no,v_no);
//        if (flag ==true) {
//            redisUtil.incr("v_likes"+v_no,1);
//            tConVLikesService.insert(con_no,v_no);
//            return setResultSuccess("点赞成功！");
//        }else {
//            return setResultError(400,"点赞失败！");
//        }
        boolean flag = tConVLikesService.queryByVnoCno(con_no, v_no);
        if (flag) {
            int like0 = tVideosService.getLike(v_no);
            stringRedisTemplate.opsForValue().set(v_no+con_no.toString(),String.valueOf(like0+1),30, TimeUnit.SECONDS);
            String l = stringRedisTemplate.opsForValue().get(v_no + con_no.toString());
            int like1 = Integer.parseInt(l);
            int i = tVideosService.updateLikeNum(v_no, like1);
            if (i > 0 && this.tConVLikesService.insert(con_no, v_no)) {
                int like = tVideosService.getLike(v_no);
                return setResultSuccess(200,"点赞成功！",like);
            } else {
                return setResultError(400, "点赞失败,您已给该视频点过赞了！");
            }
        } else {
            return setResultError(400, "点赞失败,您已给该视频点过赞了！");
        }
    }

    /**
     * 举报视频
     */
    @ApiOperation(value = "举报视频")
    @ResponseBody
    @PostMapping("reportVideo")
    public Result reportVideo(@RequestParam("con_no") Integer con_no, @RequestParam("v_no") Integer v_no,@RequestParam("reason") String reason) {
        if (this.tVideosService.updateReportVideo(con_no, v_no,reason) == true) {
            return setResultSuccess("举报成功！");
        } else {
            return setResultError(400, "举报失败，您已举报过该视频!");
        }
    }

    /**
     * 增加视频播放量
     */
    @ApiOperation(value = "增加视频播放量")
    @ResponseBody
    @GetMapping("addPlayNum")
    public Result addPlayNum(Integer v_no){
        return setResultSuccess(tVideosService.addPlayNum(v_no));
    }


//
//    /**
//     * 获取视频的点赞数
//     * @param v_no
//     * @return
//     */
//    @ResponseBody
//    @PostMapping("getLikesNum")
//    public Result getLikesNum(Integer v_no){
//        return setResultSuccess(200,"获取点赞数");
//    }

    /**
     * 新增视频，（投稿视频）
     */
    @ApiOperation(value = "投稿视频（新增视频）")
    @ResponseBody
    @PostMapping("tVideos/upload")
    public String upload(@RequestParam("file") MultipartFile[] file, HttpServletRequest httpServletRequest) throws IOException {
        //多个文件
        if (file.length == 0) {
//            attributes.addFlashAttribute("msg", "上传的文件不能为空");
//            return "redirect:/files/fileAll";
            return "false";
        }

        //开Ftp通道
        Ftp ftp = new Ftp("49.234.77.189", 21, "13593568046", "123456");
        ftp.ftpLogin();
        TVideos tVideos = new TVideos();
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
                tVideos.setV_pic("http://49.234.77.189:8080/video/" + file1.getName());
            } else {
                int nameLength = multipartFile.getOriginalFilename().lastIndexOf('.');
                String vTitle = multipartFile.getOriginalFilename().substring(0,nameLength);
                String vUrl = "http://49.234.77.189:8080/video/" + file1.getName();
                tVideos.setV_title(vTitle);
                tVideos.setV_url(vUrl);
                String con = httpServletRequest.getParameter("con_no");
                if(con==null || con.length()==0){
                    return ("无效参数");
                }

                tVideos.setCon_no(Integer.valueOf(con));
//                tVideos.setCon_no(1);
                tVideos.setV_coins(0);
            }
        }
        tVideosService.insert(tVideos);

        //获取资源路径 classpath的项目路径+/static/files  classpath就是resources的资源路径
//        String path = ResourceUtils.getURL("classpath:").getPath() + "static/files/";
        //新建一个时间文件夹标识，用来分类
//        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //全路径(存放资源的路径) 资源路径+时间文件夹标识
//        String dataDir = path + format;
//        System.out.println(dataDir);
        //全路径存放在文件类中，判断文件夹是否存在不存在就创建
//        File dataFile = new File(dataDir);  //也可以直接放进去进行拼接 File dataFile = new File(path,format);
//        if (!dataFile.exists()) {
//            dataFile.mkdirs();
//        }
//          文件上传至指定路径
//        file.transferTo(new File(dataFile, newFileName));
//        上传本地文件夹
//        boolean up = ftp.uploadDirectory("C:\\Users\\77181\\Desktop\\123", "/home/data/");
//        System.out.println(lo);
//        System.out.println(up);
//=============================================================================================
        ftp.ftpLogOut();
        return "success";
    }

}