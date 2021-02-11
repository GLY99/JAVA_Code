package org.example.service;

import org.example.exception.AppException;
import org.example.mapper.SettingMapper;
import org.example.mapper.UserMapper;
import org.example.model.Setting;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SettingMapper settingMapper;
    private static final DateFormat DF = new SimpleDateFormat("yyyyMMdd");
    @Value("${user.head.local-path}")//用户头像本地根路径
    private String headLocalPath;
    @Value("${user.head.remote-path}")//http请求路径
    private String headRemotePath;

    public String saveHead(MultipartFile headFile) {
        //建子文件夹
        Date now = new Date();
        String dirUri = "/" + DF.format(now);
        File dir = new File(headLocalPath + dirUri);
        if (!dir.exists()){
            dir.mkdir();
        }
        //保存在本地以天为单位的文件夹,保证文件唯一:随机字符串作为文件名,后缀为上传文件的后缀
        String suffix = headFile.getOriginalFilename().substring(headFile.getOriginalFilename().lastIndexOf("."));//后缀名
        String headName = UUID.randomUUID().toString() + suffix;//文件名
        String uri = dirUri + "/" + headName;
        try {
            headFile.transferTo(new File(headLocalPath + uri));
        } catch (IOException e) {
            throw new AppException("REG001","上传用户头像出错");
        }
        return headRemotePath + uri;
    }
    @Transactional
    public void register(User user) {
        //数据库校验,用户名不能重复
        User exist = userMapper.selectByUsername(user.getUsername());
        if (exist != null){
            throw new AppException("REG002","用户名已存在");
        }
        //插入user数据
        userMapper.insertSelective(user);//自增主键插入后会设置到user中
        //插入setting数据:登录后添加奖项和抽奖人员要setting字段
        Setting setting = new Setting();
        setting.setUserId(user.getId());
        setting.setBatchNumber(8);//每次抽奖数量设置为默认值
        settingMapper.insertSelective(setting);
    }

    public User queryByUsername(String username) {
        User query = userMapper.selectByUsername(username);
        return query;
    }
}
