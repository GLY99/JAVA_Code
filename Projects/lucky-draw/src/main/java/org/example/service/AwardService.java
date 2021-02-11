package org.example.service;

import org.example.mapper.AwardMapper;
import org.example.mapper.SettingMapper;
import org.example.model.Award;
import org.example.model.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardService {
    @Autowired
    private AwardMapper awardMapper;
    @Autowired
    private SettingMapper settingMapper;

    public List<Award> queryBySettingId(Integer id) {
        return awardMapper.selectBySettingId(id);
    }

    public int add(Award award, Integer userId) {
        Setting setting = settingMapper.selectByUserId(userId);
        award.setSettingId(setting.getId());
        return awardMapper.insertSelective(award);
    }

    public int update(Award award) {
        return awardMapper.updateByPrimaryKeySelective(award);
    }

    public int delete(Integer id) {
        return awardMapper.deleteByPrimaryKey(id);
    }
}
