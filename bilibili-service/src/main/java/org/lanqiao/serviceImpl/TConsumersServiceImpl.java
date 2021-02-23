package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.dao.TConsumersDao;
import org.lanqiao.entity.TConsumers;
import org.lanqiao.service.TConsumersService;
import org.lanqiao.util.RandomCharData;
import org.lanqiao.vo.ConsumerCodeVo;
import org.lanqiao.vo.ConsumerCodeVoToConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 用户(ConsumersVo)表服务实现类
 *
 * @since 2020-10-07 11:30:05
 */
@Service
@Component
public class TConsumersServiceImpl implements TConsumersService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource
    private TConsumersDao tConsumersDao;

    @Autowired
    private JavaMailSender mailSender;//一定要用@Autowired

    private String from = "sonnie_yyds@qq.com";

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    @Override
    public TConsumers queryByName(String name) {
        return this.tConsumersDao.queryByName(name);
    }

    @Override
    public TConsumers queryByNameAndPwd(String name, String password) {
        return this.tConsumersDao.queryByNameAndPwd(name, password);
    }


    @Override
    public TConsumers queryByCno(Integer con_no) {
        return this.tConsumersDao.queryByCno(con_no);
    }

    @Override
    public String getRoleName(Integer con_no) {
        return this.tConsumersDao.getRoleName(con_no);
    }

    @Override
    public List<TConsumers> queryAll(TConsumers tConsumers) {
        return this.tConsumersDao.queryAll(tConsumers);
    }

    @Override
    public List<TConsumers> queryByTelNum(TConsumers tConsumers) {
        return this.tConsumersDao.queryByTelNum(tConsumers);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TConsumers> queryAllByLimit(int offset, int limit) {
        return this.tConsumersDao.queryAllByLimit(offset, limit);
    }

    @Override
    public Object getAllConsumersByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TConsumers> list = tConsumersDao.getListByPage();
        return new PageInfo<>(list);

    }

    /**
     * 新增数据
     *
     * @param tConsumers 实例对象
     * @return 实例对象
     */
    @Override
    public TConsumers insert(TConsumers tConsumers) {
        this.tConsumersDao.insert(tConsumers);
        return tConsumers;
    }

    /**
     * 修改数据
     *
     * @param tConsumers 实例对象
     * @return 实例对象
     */
    @Override
    public TConsumers update(TConsumers tConsumers) {
        this.tConsumersDao.update(tConsumers);
        return tConsumers;

    }

//    public ConsumersVo getConsumersVo(){
//        return this.tConsumersDao.getConsumersVo();
//    }


    /**
     * 通过主键删除数据
     *
     * @return 是否成功
     */
    @Override
    public String deleteById(Integer con_no) {
        this.tConsumersDao.deleteById(con_no);
        return "删除成功！";
    }

    /**
     * 发送验证码
     *
     * @param mail
     * @return
     */
    @Override
    public boolean sendMimeMail(String mail) {
        try {
            Date date = new Date();

            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setSubject("验证码邮件");//主题
            //生成随机数
            String code = RandomCharData.createRandomCharData(6);

            //将随机数放置到session中
//            session.setAttribute("email", email);
//            session.setAttribute("code", code);

            mailMessage.setText("您的验证码为：" + code + " ，请在该验证码过期之前完成验证");//内容

            mailMessage.setTo(mail);//发给谁
            mailMessage.setSentDate(date);

            mailMessage.setFrom(from);//你自己的邮箱

            mailSender.send(mailMessage);//发送

            stringRedisTemplate.opsForValue().set("mail", mail, 60, TimeUnit.SECONDS);
            stringRedisTemplate.opsForValue().set("code", code, 60, TimeUnit.SECONDS);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 注册
     *
     * @param consumerCodeVo
     * @return
     */
    @Override
    public boolean registered(ConsumerCodeVo consumerCodeVo) {
        String mail = stringRedisTemplate.opsForValue().get("mail");
        String code = stringRedisTemplate.opsForValue().get("code");

        //获取表单中的提交的验证信息
        String voCode = consumerCodeVo.getCode();

        //如果email数据为空，或者不一致，注册失败
        if (mail == null || mail.isEmpty()) {
            //return "error,请重新注册";
            return false;
        } else {
            assert code != null;
            if (!code.equals(voCode)) {
                //return "error,请重新注册";
                return false;
            }
        }
        //保存数据
        TConsumers tConsumers = ConsumerCodeVoToConsumer.toConsumer(consumerCodeVo);
        //将数据写入数据库
        this.tConsumersDao.insert(tConsumers);

        //跳转成功页面
        return true;
    }

    /**
     * 邮箱验证码登录
     *
     * @param mail
     * @param code
     * @return
     */
    @Override
    public TConsumers loginInByEmail(String mail, String code) {

        TConsumers tConsumers = tConsumersDao.queryByMail(mail);
        if (tConsumers != null) {
            String redisCode = stringRedisTemplate.opsForValue().get("code");
            assert redisCode != null;
            if (redisCode.equals(code)) {
                return tConsumers;
            }
        }
        return null;
    }

    @Override
    public String findPwd(String name,String mail,String code) {
        String password = tConsumersDao.findPwd(name);
        if (!"".equals(password)) {
            String redisCode = stringRedisTemplate.opsForValue().get("code");
            if (code.equals(redisCode)) {
                try {
                    Date date = new Date();

                    SimpleMailMessage mailMessage = new SimpleMailMessage();

                    mailMessage.setSubject("找回密码");//主题

                    mailMessage.setText("您的密码为：" + password);//内容

                    mailMessage.setTo(mail);//发给谁
                    mailMessage.setSentDate(date);

                    mailMessage.setFrom(from);//你自己的邮箱

                    mailSender.send(mailMessage);//发送

                    stringRedisTemplate.opsForValue().set("mail", mail, 60, TimeUnit.SECONDS);
                    stringRedisTemplate.opsForValue().set("password", code, 60, TimeUnit.SECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return password;
            }
            return null;
        }
        return null;
    }

    @Override
    public Integer updatePwd(String name, String password) {
            return tConsumersDao.updatePwd(name, password);
    }

    @Override
    public Integer updateDetail(String name, String tele_num, Integer age) {
        return tConsumersDao.updateDetail(name, tele_num, age);
    }

    @Override
    public int uploadPic( byte[] pic,Integer con_no) {
        return tConsumersDao.uploadPic(pic,con_no);
    }

    @Override
    public int report(Integer con_no) {
        return tConsumersDao.addReportNum(con_no);
    }

    @Override
    public int toIllegal(Integer con_no) {

        return tConsumersDao.toIllegal(con_no);
    }

}